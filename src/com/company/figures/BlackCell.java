package com.company.figures;

import com.company.Board;

public class BlackCell extends AbstractFigure {

    public BlackCell(int x, int y) {
        super("black", x, y, '_');
    }

    @Override
    public boolean validateMove(int fromX, int fromY, int toX, int toY, Board board) {
        return true;
    }
}
