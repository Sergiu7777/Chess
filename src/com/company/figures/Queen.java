package com.company.figures;

import com.company.Board;

public class Queen extends AbstractFigure {

    public Queen(String color, int x, int y, char name) {
        super(color, x, y, name);
    }

    @Override
    public boolean validateMove(int fromX, int fromY, int toX, int toY, Board board) {
        return true;
    }
}
