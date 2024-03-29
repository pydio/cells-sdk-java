package com.pydio.cells.legacy;

import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.callbacks.ProgressListener;
import com.pydio.cells.utils.Str;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;

public class P8RequestBody {

    // private final String logTag = "P8RequestBody";

    private String mFilename;
    private String mimeType;

    private final long mLength;
    private long mCursor;
    // private File mFile;
    private InputStream mInStream;

    private int mChunkIndex = 0;
    private final int mChunkCount;

    private long mChunkSize;
    private long mLastChunkSize;

    private long mMaxChunkSize;

    private final String DEFAULT_MIME_TYPE = "application/octet-stream";

    private LocalProgressListener localProgressListener;

    public P8RequestBody(String filename, long length, long maxPartSize) {
        mFilename = filename;
        mLength = length;

        //we remove 1 Kb just to make sure we do not exceed the client_upload_max_size
        if (maxPartSize == 0) {
            maxPartSize = mLength;
        } else {
            mMaxChunkSize = maxPartSize;
        }

        if (maxPartSize >= length) {
            mChunkCount = 1;
        } else {
            mChunkSize = maxPartSize;
            mChunkCount = (int) Math.ceil((float) mLength / mChunkSize);
            mLastChunkSize = mLength % this.mChunkSize;
        }
    }

    public P8RequestBody(InputStream in, String filename, long length, String mimeType, long maxPartSize) {
        this(filename, length, maxPartSize);
        mInStream = in;
        this.mimeType = mimeType;
    }

    public String getFilename() {
        return mFilename;
    }

    public String getCharset() {
        return "utf-8";
    }

    public void setFilename(String label) {
        mFilename = label;
    }

    public long getContentLength() {
        return mLength;
    }

    public String getContentType() {

        if (Str.notEmpty(mimeType)) {
            return mimeType;
        }

        String contentType = URLConnection.guessContentTypeFromName(getFilename());
        if (contentType == null) {
            return DEFAULT_MIME_TYPE;
        }
        return contentType;
    }

    public InputStream getContent() throws IllegalStateException {
        return mInStream;
    }

    public void writeTo(OutputStream out) throws IOException, SDKException {

        long limit = mChunkSize;
        long bufferSize = Math.min(SdkNames.LOCAL_CONFIG_BUFFER_SIZE_DEFAULT_VALUE, mChunkSize);
        long start = mChunkIndex * mChunkSize;
        long totalRead = start;

        if (mChunkCount > 1) {

            // Write the content of a file to the output stream
//            if (mFile != null) {
//                byte[] buffer = new byte[(int) Math.min(SdkNames.LOCAL_CONFIG_BUFFER_SIZE_DEFAULT_VALUE, mChunkSize)];
//
//                if (mChunkIndex == (mChunkCount - 1)) {
//                    limit = mLastChunkSize;
//                }
//
//                RandomAccessFile raf = new RandomAccessFile(mFile, "r");
//                raf.seek(start);
//                int read, maximumToRead = (int) Math.min(bufferSize, limit);
//
//                while (limit > 0) {
//                    read = raf.read(buffer, 0, maximumToRead);
//                    out.write(buffer, 0, read);
//                    totalRead += read;
//                    if (localProgressListener != null) {
//                        localProgressListener.transferred(start + totalRead);
//                    }
//                    limit -= read;
//                    maximumToRead = (int) Math.min(bufferSize, limit);
//                }
//                raf.close();
//
//            } else {

            byte[] buffer = new byte[(int) Math.min(SdkNames.LOCAL_CONFIG_BUFFER_SIZE_DEFAULT_VALUE, mChunkSize)];
            if (mChunkIndex == (mChunkCount - 1)) {
                limit = mLastChunkSize;
            }
            int maximumToRead = (int) Math.min(bufferSize, limit);
            int read;
            while (limit > 0) {
                read = mInStream.read(buffer, 0, maximumToRead);
                out.write(buffer, 0, read);
                totalRead += read;
                if (localProgressListener != null) {
                    // localProgressListener.transferred(start + totalRead);
                    localProgressListener.transferred(read);
                }
                limit -= read;
                maximumToRead = (int) Math.min(bufferSize, limit);
            }
//            }

            mChunkIndex++;

        } else {

//            if (mFile != null) {
//                mInStream = new FileInputStream(mFile);
//            }

            byte[] buf = new byte[(int) Math.min(SdkNames.LOCAL_CONFIG_BUFFER_SIZE_DEFAULT_VALUE, mLength)];
            int len;
            while ((len = mInStream.read(buf)) > 0) {
                out.write(buf, 0, len);
                totalRead += len;
                if (localProgressListener != null) {
                    localProgressListener.transferred(len);
                }
            }
            mInStream.close();
            mChunkIndex++;
        }
        if (localProgressListener != null && mChunkCount > 1) {
            localProgressListener.partTransferred(mChunkIndex, mChunkCount);
        }
    }

    public void writeTo(OutputStream out, long len) throws IOException, SDKException {
        long writtenCount = 0;
        int bufferSize = (int) Math.min(Math.min(SdkNames.LOCAL_CONFIG_BUFFER_SIZE_DEFAULT_VALUE, len), available());
        byte[] buffer = new byte[bufferSize];

        int read, maximumToRead = (int) Math.min(len, available());

//        if (mFile != null) {
//            RandomAccessFile raf = new RandomAccessFile(mFile, "r");
//            raf.seek(mCursor);
//
//            while (writtenCount < maximumToRead) {
//                read = raf.read(buffer, 0, Math.min(bufsize, (int) (maximumToRead - writtenCount)));
//                out.write(buffer, 0, read);
//                writtenCount += read;
//                if (localProgressListener != null) {
//                    localProgressListener.transferred(mCursor + writtenCount);
//                }
//            }
//            raf.close();
//        } else
//
        if (mInStream != null) {

            while (writtenCount < maximumToRead) {
                read = mInStream.read(buffer, 0, Math.min(bufferSize, (int) (maximumToRead - writtenCount)));
                out.write(buffer, 0, read);
                writtenCount += read;
                if (localProgressListener != null) {
                    // localProgressListener.transferred(mCursor + writtenCount);
                    localProgressListener.transferred(read);
                }
            }
        } else {
            throw new IOException("No source in content body");
        }

        mCursor += writtenCount;
        // return maximumToRead;
    }

    public boolean isChunked() {
        return mChunkCount > 1;
    }

    public boolean allChunksWritten() {
        return mChunkIndex >= mChunkCount || mCursor >= mLength;
    }

    public boolean lastChunk() {
        return isChunked() && mChunkIndex == (mChunkCount - 1);
    }

    public long maxChunkSize() {
        return mMaxChunkSize;
    }

    public long available() {
        return mLength - mCursor;
    }

    public LocalProgressListener listener() {
        return localProgressListener;
    }

    // TODO double check it works both for Cells and P8
    public void setTransferListener(final ProgressListener listener) {
        this.localProgressListener = new LocalProgressListener() {
            @Override
            public void transferred(long progress) throws SDKException {

                String cancellationMsg = listener.onProgress(progress);
                if (Str.notEmpty(cancellationMsg)) {
                    throw SDKException.cancel(cancellationMsg);
                }
            }

            @Override
            public void partTransferred(int part, int total) throws SDKException {
                if (total == 0) {
                    return;
                }

                long progress = (long) ((float) part / (float) total);
                String cancellationMsg = listener.onProgress(progress);
                if (Str.notEmpty(cancellationMsg)) {
                    throw SDKException.cancel(cancellationMsg);
                }
            }
        };
    }

    private interface LocalProgressListener {

        void transferred(long num) throws SDKException;

        void partTransferred(int part, int total) throws SDKException;
    }
}
