package com.pydio.cells.utils.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * In order to simplify dependency management, we do not provide an implementation of the S3 client
 * in this layer. It is thus not possible to upload or download files directly in this layer.
 * <p>
 * To workaround this issue and enable integration tests we provide a simple wrapper around the
 * Cells Client (cec), a go binary that provides the packaged client a single binary.
 * <p>
 * It is for test only and might prove buggy, so use at your own risk.
 */
public class CecWrapper {

    private String basePath;
    private String cecCmd;

    public void setUpCec(String prepareCmd, String workingDir, String propsFile) throws IOException {

        try {
            ProcessBuilder builder = new ProcessBuilder(prepareCmd, TestUtils.getOS(), workingDir, propsFile);
            builder.redirectErrorStream(true);
            Process process = builder.start();

            int returnValue = process.waitFor();
            System.out.println("## After running prepare-cec script. Exit code: " + returnValue);

            displayOutput(process);

            if (returnValue != 0) {
                throw new RuntimeException("Execution of Setup failed with code " + returnValue);
            }

            basePath = workingDir;
            cecCmd = workingDir.concat(File.separator).concat("cells-client");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int callCommand(String... args) throws Exception {
        if (cecCmd == null) {
            throw new RuntimeException("You must call setup command before trying to use the cells client");
        }

        ProcessBuilder builder = new ProcessBuilder(buildArgs(args));
        builder.redirectErrorStream(true);
        Process process = builder.start();
        int returnValue = process.waitFor();

        displayOutput(process);

        if (returnValue != 0) {
            throw new RuntimeException("Execution of command " + args[0] + " failed with code " + returnValue);
        } else
            return 0;
    }

    private String[] buildArgs(String... args) {
        String[] args2 = new String[args.length + 1];
        args2[0] = cecCmd;
        int i = 1;
        for (String elem : args) {
            args2[i] = elem;
            i++;
        }
        return args2;
    }

    private void displayOutput(Process process) throws Exception {
        try (InputStream out = process.getInputStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(out));
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println("Stdout: " + line);
            }
        }
    }


    // print input stream
    private static void printInputStream(InputStream is) {

        try (InputStreamReader streamReader =
                     new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
