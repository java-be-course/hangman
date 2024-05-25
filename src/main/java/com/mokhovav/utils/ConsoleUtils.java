package com.mokhovav.utils;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.List;

public class ConsoleUtils {

    private static final String CSI = "\033[";

    public static void cleanAll() {
        print('H');
        print('J');
    }

    public static void move(int n, int m) {
        print(n,m,'H');
    }

    public static void println(List<String> lines) {
        if (CollectionUtils.isEmpty(lines)) {
            return;
        }
        lines.forEach(System.out::println);
    }

    public static void println(String... lines) {
        if (lines == null) {
            return;
        }
        Arrays.asList(lines).forEach(System.out::println);
    }

    public static void print(String... lines) {
        if (lines == null) {
            return;
        }
        Arrays.asList(lines).forEach(System.out::print);
    }

    private static void print(char command) {
        System.out.print(CSI + command);
    }

    private static void print(int n, char command) {
        System.out.print(CSI + n + command);
    }

    private static void print(int n, int m, char command) {
        System.out.print(CSI + n + ';' + m + command);
    }
}
