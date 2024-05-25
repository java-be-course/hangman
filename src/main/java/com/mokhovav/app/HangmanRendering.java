package com.mokhovav.app;

import com.mokhovav.utils.ConsoleUtils;

public class HangmanRendering {
    private static final Hangman hangman = new Hangman();
    private static final BodyView head = new BodyView(3, 6, "o");
    private static final BodyView body = new BodyView(4, 5, "(_)");
    private static final BodyView leftArm = new BodyView(4, 4, "/");
    private static final BodyView rightArm = new BodyView(4, 8, "\\");
    private static final BodyView leftLeg = new BodyView(5, 5, "/");
    private static final BodyView rightLeg = new BodyView(5, 7, "\\");

    public static void drawHangman(int errors) {
        ConsoleUtils.cleanAll();
        hangman.render();
        switch (errors) {
            case 6:
                rightLeg.render();
            case 5:
                leftLeg.render();
            case 4:
                body.render();
            case 3:
                rightArm.render();
            case 2:
                leftArm.render();
            case 1:
                head.render();
        }
        ConsoleUtils.move(7, 1);
    }

}
