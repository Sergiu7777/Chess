package com.company.figures;

import com.company.Board;

public class Knight extends AbstractFigure {

    public Knight(String color, int x, int y, char name) {
        super(color, x, y, name);
    }

    @Override
    public boolean validateMove(int fromX, int fromY, int toX, int toY, Board board) {
        AbstractFigure destination = board.getBoard()[toX][toY];

        if (destination instanceof King && this.getColor() != destination.getColor()) {
            board.setCheck(true);
        }

        if(Math.abs(toX - fromX) == 2 && Math.abs(toY - fromY) == 1){
            return true;
        }

        if(Math.abs(toX - fromX) == 1 && Math.abs(toY - fromY) == 2){
            return true;
        }

        return false;
    }
}
