package com.company.figures;

import com.company.Board;

public class Pawn extends AbstractFigure {

    public Pawn(String color, int x, int y, char name) {
        super(color, x, y, name);
    }

    @Override
    public boolean validateMove(int fromX, int fromY, int toX, int toY, Board board) {
        if (this.getColor().equalsIgnoreCase("white") && (toX - fromX >= 0)) {
            return false;
        } else if (this.getColor().equalsIgnoreCase("black") && (toX - fromX <= 0)) {
            return false;
        }

        if ((fromX == 1 || fromX == 6) && Math.abs(toX - fromX) == 2 || Math.abs(toX - fromX) == 1 && fromY == toY) {
            return true;
        }
        if (Math.abs(fromY - toY) == 1) {
            if (board.getBoard()[toX][toY] instanceof WhiteCell || board.getBoard()[toX][toY] instanceof BlackCell)
                return true;
        }
        return Math.abs(fromX - toX) == 1 && Math.abs(fromY - toY) == 1;
    }
}
