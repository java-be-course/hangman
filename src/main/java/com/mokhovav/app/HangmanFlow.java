package com.mokhovav.app;

import com.mokhovav.renderer.HangmanRenderer;
import com.mokhovav.utils.FileUtils;

import java.io.IOException;
import java.util.Random;

public class HangmanFlow {

    public static void process(String fileName) throws IOException {
        startGame();
        long numberOfLines = FileUtils.getNumberOfLines(fileName);
        String word = getWord(fileName, numberOfLines);
        HangmanRenderer.drawHangman(0);
    }

    private static void startGame() {

    }

    public static String getWord(String fileName, long numberOfLines) throws IOException {
        Random random = new Random();
        int wordPosition = random.nextInt(Long.valueOf(numberOfLines).intValue());
        return FileUtils.findLine(fileName, wordPosition).orElseThrow();
    }
}
