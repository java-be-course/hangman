package com.mokhovav.renderer;

import com.mokhovav.utils.ConsoleUtils;

public class HangmanViewAssembler implements ViewAssembler {
    @Override
    public void toView() {
        ConsoleUtils.println("______", "|    |","|","|","|","|");
    }
}
