package com.mokhovav.app;

import com.mokhovav.utils.ConsoleUtils;

public class BodyView implements ViewRendering {
    private final int posX;
    private final int posY;
    private final String view;

    public BodyView(int posX, int posY, String view) {
        this.posX = posX;
        this.posY = posY;
        this.view = view;
    }

    @Override
    public void render() {
        ConsoleUtils.move(posX,posY);
        ConsoleUtils.print(view);
    }
}
