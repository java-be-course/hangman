package com.mokhovav.renderer;

import com.mokhovav.utils.ConsoleUtils;

public class BodyPartViewAssembler implements ViewAssembler {
    private final int posX;
    private final int posY;
    private final String view;

    public BodyPartViewAssembler(int posX, int posY, String view) {
        this.posX = posX;
        this.posY = posY;
        this.view = view;
    }

    @Override
    public void toView() {
        ConsoleUtils.move(posX,posY);
        ConsoleUtils.print(view);
    }
}
