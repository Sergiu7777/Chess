package com.company.figures;

import com.company.Board;

public abstract class AbstractFigure {
    private String color;
    private int x;
    private int y;
    private final char name;

    public AbstractFigure(String color, int x, int y, char name) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getName() {
        return name;
    }

    public abstract boolean validateMove(int fromX, int fromY, int toX, int toY, Board board);
}
