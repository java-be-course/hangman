package com.mokhovav.utils;

import org.junit.Test;

import java.io.IOException;

public class FileUtilsTest {
    private static final String TEXT_FILE_NAME = "src/test/resources/testWords.txt";

    @Test
    public void testGetNumbersOfLines() throws IOException {
        assert FileUtils.getNumberOfLines(TEXT_FILE_NAME) == 10;
    }

    @Test(expected = IOException.class)
    public void testGetNumbersOfLinesWrongFileName() throws IOException {
        assert FileUtils.getNumberOfLines(TEXT_FILE_NAME + "1") == 10;
    }

    @Test()
    public void testExecuteForEachLine() throws IOException {
        FileUtils.executeForEachLine(TEXT_FILE_NAME, (str) -> {
            assert str.length() > 3;
        });
    }

    @Test()
    public void testExecuteForSeveralLines() throws IOException {
        FileUtils.executeForSeveralLines(TEXT_FILE_NAME, 3, 1, (str) -> {
            assert str.equals("абазин");
        });
    }

    @Test()
    public void testFindLine() throws IOException {
        assert FileUtils.findLine(TEXT_FILE_NAME, 3).orElseThrow().equals("абазин");
    }

}
