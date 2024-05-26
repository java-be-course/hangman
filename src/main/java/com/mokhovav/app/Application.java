package com.mokhovav.app;

import java.io.IOException;

public class Application {

    private static final String FILE_NAME = "jar/words.txt";
    public static void main(String[] args) throws IOException {
        HangmanFlow.process(FILE_NAME);
    }
}