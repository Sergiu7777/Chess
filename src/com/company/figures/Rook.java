package com.company.figures;

import com.company.Board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rook extends AbstractFigure {
    public Rook(String color, int x, int y, char name) {
        super(color, x, y, name);
    }

    @Override
    public boolean validateMove(int fromX, int fromY, int toX, int toY, Board board) {
        boolean result = true;

        if ((fromX != toX) && (fromY != toY) || (fromX == toX) && (fromY == toY))
            //did not move straight line
            return false;

        if (fromX == toX) {
            List<AbstractFigure> fields = new ArrayList<>();
            fields.addAll(Arrays.asList(board.getBoard()[fromX]).subList(0, Math.abs(toY - fromY)));
           // fields.remove(0);
            fields.remove(fields.size() - 1);

            for (AbstractFigure figure : fields) {
                if (figure instanceof King && !figure.getColor().equals(this.getColor())) {
                    board.setCheck(true);
                    return true;
                }

                if (!(figure instanceof BlackCell) || !(figure instanceof WhiteCell))
                    result = false;
            }
        }

        if (fromY == toY) {
            List<AbstractFigure> fields = new ArrayList<>();
            fields.addAll(Arrays.asList(board.getBoard()[fromX]).subList(0, Math.abs(toX - fromX)));
           // fields.remove(0);
            if (fields.size() > 0) {
                fields.remove(fields.size() - 1);

                for (AbstractFigure figure : fields) {
                    if (figure instanceof King && !figure.getColor().equals(this.getColor())) {
                        board.setCheck(true);
                        return true;
                    }

                    if (!(figure instanceof BlackCell) || !(figure instanceof WhiteCell))
                        result = false;
                }
            }
        }

        return result;
    }
}
