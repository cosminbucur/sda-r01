package com.bucur.recap.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DemoException {

    public static void main(String[] args) {

        boolean wrongPassword = true;

        if (wrongPassword) {
            // throw runtime (unchecked) exception
            throw new LoginException("wrong password");
        }

        readAndPrintAllLines();

        try {
            readAndPrintAllLines2();
        } catch (IOException e) {
            System.out.println("error reading file");
        }
    }

    private static void readAndPrintAllLines() {
        Path path = Paths.get("test.txt");

        // handle checked exception (in place)
        try {
            Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("error reading file " + path);
        }
    }

    private static void readAndPrintAllLines2() throws IOException {
        Path path = Paths.get("test.txt");

        // handle checked exception by caller
        Files.readAllLines(path);
    }
}
