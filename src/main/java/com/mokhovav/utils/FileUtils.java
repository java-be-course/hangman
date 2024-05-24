package com.mokhovav.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {

    public static long getNumberOfLines(String fileName) throws IOException {
        checkFileName(fileName);
        try (FileReader fr = new FileReader(fileName); BufferedReader br = new BufferedReader(fr)) {
            return br.lines().count();
        }
    }

    public static void executeForEachLine(String fileName, StringHandler handler) throws IOException {
        checkFileName(fileName);
        checkHandler(handler);
        try (FileReader fr = new FileReader(fileName); BufferedReader br = new BufferedReader(fr)) {
            br.lines().forEach(handler::process);
        }
    }

    public static void executeForSeveralLines(String fileName, long skip, long limit, StringHandler handler) throws IOException, IllegalArgumentException {
        checkFileName(fileName);
        checkHandler(handler);
        if (skip < 0) {
            throw new IllegalArgumentException("Start line is negative");
        }
        if (limit < 0) {
            throw new IllegalArgumentException("Limit is negative");
        }

        try (FileReader fr = new FileReader(fileName); BufferedReader br = new BufferedReader(fr)) {
            br.lines().skip(skip).limit(limit).forEach(handler::process);
        }
    }

    private static void checkFileName(String fileName) {
        if (StringUtils.isBlank(fileName)) {
            throw new IllegalArgumentException("File name is blank");
        }
    }

    private static void checkHandler(StringHandler handler) {
        if (handler == null) {
            throw new IllegalArgumentException("Handler is null");
        }
    }

    public interface StringHandler {
        void process(String str);
    }

}
