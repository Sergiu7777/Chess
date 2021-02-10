package com.company.figures;

import com.company.Board;

public class Bishop extends AbstractFigure {

    public Bishop(String color, int x, int y, char name) {
        super(color, x, y, name);
    }

    @Override
    public boolean validateMove(int fromX, int fromY, int toX, int toY, Board board) {
        boolean result = false;

        if (fromX == toX || fromY == toY) {
            //Did not move diagonally
            return false;
        }

        if (Math.abs(toX - fromX) != Math.abs(toY - fromY)) {
            return false;
        }

        int rowOffset, colOffset;

        if (fromX < toX) {
            rowOffset = 1;
        } else {
            rowOffset = -1;
        }

        if (fromY < toY) {
            colOffset = 1;
        } else {
            colOffset = -1;
        }

        int y = fromY + colOffset;

        for (int x = fromX + rowOffset; x != toX; x += rowOffset) {
            if ((board.getBoard()[x][y] instanceof King) && !this.getColor().equals(board.getBoard()[x][y].getColor())) {
                board.setCheck(true);
                return true;
            }

            if (board.getBoard()[x][y] instanceof BlackCell || board.getBoard()[x][y] instanceof WhiteCell) {
                result = true;
            }
            y += colOffset;
        }

        return result;
    }
/*
    K - King
    Q - Queen

    B - Bishop

    N - KNight
    R - Rook

    P - Pawn
 */
}
