package com.mokhovav.app;

import com.mokhovav.utils.ConsoleUtils;

public class Hangman implements ViewRendering {
    @Override
    public void render() {
        ConsoleUtils.println("______", "|    |","|","|","|","|");
    }
}
