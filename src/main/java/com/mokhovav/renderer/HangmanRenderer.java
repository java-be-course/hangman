package com.mokhovav.renderer;

import com.mokhovav.utils.ConsoleUtils;

import java.util.HashMap;
import java.util.Map;

public class HangmanRenderer {

    private static final HangmanView HANGMAN = new HangmanView();
    private static final BodyPartView HEAD = new BodyPartView(3, 6, "o");
    private static final BodyPartView BODY = new BodyPartView(4, 5, "(_)");
    private static final BodyPartView LEFT_ARM = new BodyPartView(4, 4, "/");
    private static final BodyPartView RIGHT_ARM = new BodyPartView(4, 8, "\\");
    private static final BodyPartView LEFT_LEG = new BodyPartView(5, 5, "/");
    private static final BodyPartView RIGHT_LEG = new BodyPartView(5, 7, "\\");

    private static final Map<Integer, ViewAssembler> viewPartsByMinErrorNumber = new HashMap<>() {{
        put(0, HANGMAN);
        put(1, HEAD);
        put(2, BODY);
        put(3, LEFT_ARM);
        put(4, RIGHT_ARM);
        put(5, LEFT_LEG);
        put(6, RIGHT_LEG);
    }};

    public static void drawHangman(int errorNumber) {
        ConsoleUtils.cleanAll();
        viewPartsByMinErrorNumber.forEach((key, assembler) -> {
            if (key >= errorNumber) {
                assembler.toView();
            }
        });
        ConsoleUtils.move(7, 1);
    }

}
