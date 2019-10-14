package net.curiosprogrammer.javaexperiments.files.leaks;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Experiments with https://file-leak-detector.kohsuke.org
 * See <a href="https://github.com/kohsuke/file-leak-detector/blob/master/src/main/java/org/kohsuke/file_leak_detector/AgentMain.java"
 * AgentMain</a> for complete list of options.
 * 
 */
public class FileLeakDetector {



    private static void leakFiles(int n) throws InterruptedException {
        final int newThreadIntervalMs = 5000;
        for (int i = 0; i < n; i++) {
            final String fileName = "leak" + i + ".txt";
            final Thread leakFileThread = new Thread(() -> {
                final FileOutputStream fos;
                try {
                    fos = new FileOutputStream(fileName);
                    System.out.println("Opened file: " + fileName);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Cannot find file: " + fileName);
                }
                try {
                    Thread.sleep(2 * newThreadIntervalMs);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    fos.close();
                    System.out.println("Closed file: " + fileName);
                } catch (IOException e) {
                    System.err.println("Cannot close file: " + fileName);
                    e.printStackTrace();
                }
            });
            leakFileThread.start();
            Thread.sleep(newThreadIntervalMs);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        leakFiles(20);
    }
}
