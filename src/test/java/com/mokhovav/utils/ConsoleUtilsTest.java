package com.mokhovav.utils;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ConsoleUtilsTest {
    @Test
    public void tesYesOrNo() throws IOException {
        Map<String, Boolean> testWords = new HashMap<>() {{
            put("Да", true);
            put("да", true);
            put("Д", true);
            put("д", true);
            put("дА", true);
            put("Дад", false);
            put("", false);
            put("Yes", true);
            put("Y", true);
            put("yes", true);
            put("y", true);
            put("yeS", true);
            put("yess", false);
        }};
        testWords.forEach((w, v) -> {
            boolean yes = ConsoleUtils.isYes(w);
            if (v) {
                assertTrue(String.format("Error: '%s' is false", w), yes);
            } else {
                assertFalse(String.format("Error: '%s' is true", w), yes);
            }
        });
    }
}
