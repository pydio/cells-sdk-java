package com.pydio.cells.utils;

import java.io.File;
import java.util.Map;

public class Log {

    // Temporary tags
    public static final String TAG_SDK = "CELLS/SDK";
//    public static final String TAG_UI = "CELLS/UI";
//    public static final String TAG_AUTH = "CELLS/AUTH";
//    public static final String TAG_DB = "CELLS/DB";
//    public static final String TAG_BACKEND = "CELLS/BE";
//    public static final String TAG_SYNC = "CELLS/SYNC";

    private static Logger logger;

    public static void setLogger(Logger l) {
        logger = l;
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BCKGD_RED = "\u001B[41m";
    public static final String ANSI_BCKGD_YELLOW = "\u001B[43m";
    public static final String ANSI_BCKGD_WHITE = "\u001B[47m";
//    public static final String ANSI_BLUE = "\u001B[34m";
//    public static final String ANSI_RED = "\u001B[31m";
//    public static final String ANSI_PURPLE = "\u001B[35m";
//    public static final String ANSI_CYAN = "\u001B[36m";
//    public static final String ANSI_WHITE = "\u001B[37m";
//
//    public static final String ANSI_BCKGD_BLACK = "\u001B[40m";
//    public static final String ANSI_BCKGD_GREEN = "\u001B[42m";
//    public static final String ANSI_BCKGD_BLUE = "\u001B[44m";
//    public static final String ANSI_BCKGD_PURPLE = "\u001B[45m";
//    public static final String ANSI_BCKGD_CYAN = "\u001B[46m";


    public static void e(String tag, String msg) {
        if (logger != null) {
            logger.e(tag, msg);
            return;
        }

        if (UNIXLike()) {
            msg = ANSI_GREEN + tag + "\t" + msg + ANSI_RESET;
            System.out.println(ANSI_BCKGD_RED + msg + ANSI_RESET);
        } else {
            System.out.println(tag + "\t" + msg);
        }
    }

    public static void i(String tag, String msg) {
        if (logger != null) {
            logger.i(tag, msg);
            return;
        }
        if (UNIXLike()) {
            msg = ANSI_BLACK + tag + "\t" + msg + ANSI_RESET;
            System.out.println(ANSI_BCKGD_WHITE + msg + ANSI_RESET);
        } else {
            System.out.println(tag + "\t" + msg);
        }
    }

    public static void d(String tag, String msg) {
        if (logger != null) {
            logger.d(tag, msg);
            return;
        }
        if (UNIXLike()) {
            System.out.println(ANSI_YELLOW + msg + ANSI_RESET);
        } else {
            System.out.println(tag + "\t" + msg);
        }
    }

    public static void v(String tag, String msg) {
        if (logger != null) {
            logger.v(tag, msg);
            return;
        }
        System.out.println(tag + "\t" + msg);
    }

    public static void w(String tag, String msg) {
        if (logger != null) {
            logger.w(tag, msg);
            return;
        }
        if (UNIXLike()) {
            msg = ANSI_BLACK + tag + "\t" + msg + ANSI_RESET;
            System.out.println(ANSI_BCKGD_YELLOW + msg + ANSI_RESET);
        } else {
            System.out.println(tag + "\t" + msg);
        }
    }

    public static String paramString(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        // API Level 24: params.forEach((k, v) -> builder.append(" " + k + "=" + v));
        for (String k : params.keySet()) {
            builder.append(" " + k + "=" + params.get(k));
        }
        if (builder.length() == 0) {
            return "";
        } else {
            return builder.substring(1);
        }
    }

    private static boolean UNIXLike() {
        return File.separator.equals("/");
    }

    public interface Logger {
        void e(String tag, String text);

        void i(String tag, String text);

        void v(String tag, String text);

        void d(String tag, String text);

        void w(String tag, String text);
    }
}
