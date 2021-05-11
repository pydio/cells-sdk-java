package com.pydio.cells.integration;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Paths;

public class CecWrapper {

    private String basePath;
    private String cecCmd;

    public void setUpCec() {

        URL url = CecWrapper.class.getResource("/default-target-server.properties");
        basePath = Paths.get(url.getPath()).getParent().toString();
        cecCmd = Paths.get(basePath, "cells-client").toString();

        String prepareCmd = Paths.get(basePath, "prepare-cec.sh").toString();

        try {
            ProcessBuilder builder = new ProcessBuilder(prepareCmd, TestUtils.getOS(), basePath);
            builder.redirectErrorStream(true);
            Process process = builder.start();

            int returnValue = process.waitFor();
            System.out.println("## After runnning prepare-cec script. Exit code: " + returnValue);

            displayOutput(process);

            if (returnValue != 0) {
                throw new RuntimeException("Excecution of Setup failed with code " + returnValue);
            }

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
            throw new RuntimeException("Excecution of command " + args[0] + " failed with code " + returnValue);
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
}
