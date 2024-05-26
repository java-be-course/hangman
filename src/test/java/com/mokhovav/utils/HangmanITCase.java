package com.mokhovav.utils;

import com.mokhovav.app.HangmanFlow;
import org.junit.Test;

import java.io.IOException;

public class HangmanITCase {
    private static final String TEXT_FILE_NAME = "src/test/resources/testWords.txt";
    @Test
    public void testHangman() throws IOException {
        HangmanFlow.process(TEXT_FILE_NAME);
    }
}
