package com.mokhovav.renderer;

import com.mokhovav.utils.ConsoleUtils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class HangmanRenderer {

    private static final HangmanViewAssembler HANGMAN = new HangmanViewAssembler();
    private static final BodyPartViewAssembler HEAD = new BodyPartViewAssembler(3, 6, "o");
    private static final BodyPartViewAssembler BODY = new BodyPartViewAssembler(4, 5, "(_)");
    private static final BodyPartViewAssembler LEFT_ARM = new BodyPartViewAssembler(4, 4, "/");
    private static final BodyPartViewAssembler RIGHT_ARM = new BodyPartViewAssembler(4, 8, "\\");
    private static final BodyPartViewAssembler LEFT_LEG = new BodyPartViewAssembler(5, 5, "/");
    private static final BodyPartViewAssembler RIGHT_LEG = new BodyPartViewAssembler(5, 7, "\\");

    private static final Map<Integer, ViewAssembler> viewPartsByMinErrorNumber = new HashMap<>() {{
        put(0, HANGMAN);
        put(1, HEAD);
        put(2, BODY);
        put(3, LEFT_ARM);
        put(4, RIGHT_ARM);
        put(5, LEFT_LEG);
        put(6, RIGHT_LEG);
    }};
    public static final int MAX_ERRORS = viewPartsByMinErrorNumber.keySet().stream().max(Comparator.comparingInt((it) -> it)).orElse(0);

    public static void drawHangman(int errorNumber) {
        ConsoleUtils.cleanAll();
        viewPartsByMinErrorNumber.forEach((key, assembler) -> {
            if (key <= errorNumber) {
                assembler.toView();
            }
        });
        ConsoleUtils.move(7, 1);
    }

}
