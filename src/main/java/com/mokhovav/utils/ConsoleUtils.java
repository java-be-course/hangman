package com.mokhovav.utils;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleUtils {
    private static final Logger LOG = LoggerFactory.getLogger(ConsoleUtils.class);
    private static final Charset CHARSET = StandardCharsets.UTF_8;
    private static final String CSI = "\033[";
    private static final PrintStream PRINT_STREAM = new PrintStream(System.out, true, CHARSET);
    private static final Scanner SCANNER = new Scanner(System.in, CHARSET);
    private static final Pattern YES_PATTERN = Pattern.compile("^(?:yes|y|да|д)$");
    private static final Pattern NO_PATTERN = Pattern.compile("^(?:no|n|нет|н)$");
    private static final Pattern LETTER_PATTERN = Pattern.compile("^[a-zA-Zа-яА-Я]$");

    public static void cleanAll() {
        printCommand('H');
        printCommand('J');
    }

    public static void move(int n, int m) {
        printCommand(n, m, 'H');
    }

    public static void println(Collection<String> lines) {
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

    public static Scanner getScanner() {
        return SCANNER;
    }

    public static boolean isYes(String str) {
        return YES_PATTERN.matcher(str.toLowerCase()).find();
    }

    public static Optional<String> nextLetter() {
        try {
            String input = ConsoleUtils.getScanner().nextLine();
            return Optional.ofNullable(LETTER_PATTERN.matcher(input).find() ? input : null);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return Optional.empty();
        }
    }

    public static Optional<String> nextLine() {
        try {
            return Optional.ofNullable(getScanner().nextLine());
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return Optional.empty();
        }
    }
}
