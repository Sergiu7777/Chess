package com.company.figures;

import com.company.Board;

public class WhiteCell extends AbstractFigure {
    public WhiteCell(int x, int y) {
        super("white", x, y, '*');
    }

    @Override
    public boolean validateMove(int fromX, int fromY, int toX, int toY, Board board) {
        return true;
    }
}
