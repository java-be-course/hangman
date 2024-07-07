package com.mokhovav.app;

import com.mokhovav.renderer.HangmanRenderer;
import com.mokhovav.renderer.WordViewAssembler;
import com.mokhovav.utils.ConsoleUtils;
import com.mokhovav.utils.FileUtils;

import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import static com.mokhovav.renderer.HangmanRenderer.MAX_ERRORS;

public class HangmanFlow {

    public static void process(String fileName) throws IOException {
        boolean shouldToPlay = startGame();
        while (shouldToPlay) {
            long numberOfLines = FileUtils.getNumberOfLines(fileName);
            Set<String> letters = new HashSet<>();
            AtomicInteger hangmanErrors = new AtomicInteger();
            String word = getWord(fileName, numberOfLines);

            HangmanRenderer.drawHangman(hangmanErrors.get());
            ConsoleUtils.println(WordViewAssembler.toView(word, letters));

            while (true) {
                getCorrectNexLetterOfTheWord(word).ifPresentOrElse(letters::add, hangmanErrors::getAndIncrement);
                HangmanRenderer.drawHangman(hangmanErrors.get());
                String wordWithMask = WordViewAssembler.toView(word, letters);
                ConsoleUtils.println(wordWithMask);
                if (word.equals(wordWithMask)) {
                    ConsoleUtils.println("Поздравляем! Вы угадали слово.");
                    break;
                }
                if (hangmanErrors.get() >= MAX_ERRORS) {
                    ConsoleUtils.println("Вы не успели угадать слово. Но в следующий раз у Вас обязательно получится!");
                    break;
                }
            }
            shouldToPlay = !stopGame();
        }
    }

    private static boolean startGame() {
        ConsoleUtils.println("Добрый день! Добро пожаловать в игру \"Виселица\"!.\n Хотите начать играть? (Да/Нет)");
        return ConsoleUtils.nextLine().map(ConsoleUtils::isYes).orElse(false);
    }

    private static boolean stopGame() {
        ConsoleUtils.println("Хотите сыграть ещё раз? (Да/Нет)");
        return !ConsoleUtils.nextLine().map(ConsoleUtils::isYes).orElse(false);
    }

    private static Optional<String> getCorrectNexLetterOfTheWord(String word) {
        ConsoleUtils.println("Введите букву");
        Optional<String> letter = ConsoleUtils.nextLetter();
        return letter.filter(it -> checkLetterInTheWord(it, word));
    }

    private static boolean checkLetterInTheWord(String it, String word) {
        return word.contains(it);
    }

    public static String getWord(String fileName, long numberOfLines) throws IOException {
        Random random = new Random();
        int wordPosition = random.nextInt(Long.valueOf(numberOfLines).intValue());
        return FileUtils.findLine(fileName, wordPosition).orElseThrow();
    }

}
