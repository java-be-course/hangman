package com.mokhovav.utils;

import org.apache.commons.collections4.CollectionUtils;

import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class ConsoleUtils {
    private static final Charset CHARSET = StandardCharsets.UTF_8;
    private static final String CSI = "\033[";
    public static final PrintStream PRINT_STREAM = new PrintStream(System.out, true, CHARSET);

    public static void cleanAll() {
        printCommand('H');
        printCommand('J');
    }

    public static void move(int n, int m) {
        printCommand(n,m,'H');
    }

    public static void println(List<String> lines) {
        if (CollectionUtils.isEmpty(lines)) {
            return;
        }
        lines.forEach(PRINT_STREAM::println);
    }

    public static void println(String... lines) {
        if (lines == null) {
            return;
        }
        Arrays.asList(lines).forEach(PRINT_STREAM::println);
    }

    public static void print(String... lines) {
        if (lines == null) {
            return;
        }
        Arrays.asList(lines).forEach(PRINT_STREAM::print);
    }

    private static void printCommand(char command) {
        PRINT_STREAM.print(CSI + command);
    }

    private static void printCommand(int n, char command) {
        PRINT_STREAM.print(CSI + n + command);
    }

    private static void printCommand(int n, int m, char command) {
        PRINT_STREAM.print(CSI + n + ';' + m + command);
    }
}
