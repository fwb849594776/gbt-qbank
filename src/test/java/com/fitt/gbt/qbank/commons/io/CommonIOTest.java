/*
 * Copyright (c) 2018 by Sixawn.inc All rights reserved
 */
package com.fitt.gbt.qbank.commons.io;

import org.apache.commons.io.*;
import org.apache.commons.io.filefilter.NameFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.commons.io.monitor.FileEntry;

import java.io.File;
import java.io.IOException;

/**
 * @author : <a href="mailto:congchun.zheng@gmail.com">sixawn</a>
 * @version : 1.0.0
 * @description : null.java
 * @since : 2018-12-01 22:50
 */
public class CommonIOTest {
    /**
     * 实例文件
     */
    private static final String FILE_PATH = "/Users/sixawn/Documents/01MyData/03SourceCodes/gbt-qbank/logs/qbank.log";
    /**
     * 实例目录
     */
    private static final String DIR_PATH = "/Users/sixawn/Documents/01MyData/03SourceCodes/gbt-qbank/logs";

    /** 工具类: FileUtils, IOCase, FileNameUtils **/
    public static void testUtility() {
        try {
            // FileNameUtils
            System.out.println("Full Path: " + FilenameUtils.getFullPath(FILE_PATH));
            System.out.println("Full Name: " + FilenameUtils.getName(FILE_PATH));
            System.out.println("Extension: " + FilenameUtils.getExtension(FILE_PATH));
            System.out.println("Base Name: " + FilenameUtils.getBaseName(FILE_PATH));

            // FileUtils
            File expFile = new File(FILE_PATH);
            LineIterator lineIterator = FileUtils.lineIterator(expFile);
            System.out.println("Print File Content:");

            while (lineIterator.hasNext()) {
                System.out.println(lineIterator.next());
            }
            lineIterator.close();

            File dirPath = FileUtils.getFile(DIR_PATH);
            System.out.println("Dir Path:" + FileUtils.directoryContains(dirPath, expFile));


            // IOCase
            String first = "Ride a little donkey.";
            String second = "Down to Down";

            System.out.println("End with donkey." + IOCase.SENSITIVE.checkEndsWith(first, "donkey."));

            System.out.println("String equals:" + IOCase.SENSITIVE.checkEquals(first, second));

            // FileSystemUtils
            System.out.println("Free disk space(KB):" + FileSystemUtils.freeSpaceKb("/"));
            System.out.println("Free disk space(MB):" + FileSystemUtils.freeSpaceKb("/") / 1024);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // TODO
    public static void testInput() {

    }

    // TODO
    public static void testOutput() {

    }

    public static void testFilter() {
        // File Filter: name, prefix, suffix, wildCard, OrFileFilter
        File dir = FileUtils.getFile(DIR_PATH);

        String[] acceptNames = {"qbank"};

        for (String file : dir.list(new NameFileFilter(acceptNames, IOCase.INSENSITIVE))) {
            System.out.println("File Found: " + file);
        }

        // suffix
        for (String file : dir.list(new SuffixFileFilter(".txt"))) {
            System.out.println("File Found: " + file);
        }
    }

    // TODO
    public static void testCompareror() {

    }

    public static void testFileMonitor() {
        // FileEntry
        FileEntry entry = new FileEntry(FileUtils.getFile(DIR_PATH));

        System.out.println("File monitored:" + entry.getFile());
        System.out.println("File name:" + entry.getName());
        System.out.println("File is directory:" + entry.isDirectory());


        // File Monitoring
        File dirFile = new File(DIR_PATH);
        FileAlterationObserver observer = new FileAlterationObserver(dirFile);
        observer.addListener(new FileAlterationListenerAdaptor(){
            @Override
            public void onDirectoryCreate(File directory) {
                System.out.println("directory created: " + directory.getName());
            }

            @Override
            public void onDirectoryChange(File directory) {
                System.out.println("directory changed: " + directory.getName());
            }

            @Override
            public void onDirectoryDelete(File directory) {
                System.out.println("directory deleted: " + directory.getName());
            }

            @Override
            public void onFileCreate(File file) {
                System.out.println("file created: " + file.getName());
            }

            @Override
            public void onFileChange(File file) {
                System.out.println("file changed: " + file.getName());
            }

            @Override
            public void onFileDelete(File file) {
                System.out.println("file deleted: " + file.getName());
            }
        });

        FileAlterationMonitor monitor = new FileAlterationMonitor(500, observer);
        try {
            monitor.start();

            File newDir = new File(DIR_PATH + "/newDir/");
            File newFile = new File(DIR_PATH + "/newFile.txt");

            Thread.sleep(1000);

            monitor.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        testUtility();

//        testFileMonitor();

//        testFilter();

//        testInput();

//        testOutput();

//        testCompareror();
    }
}
