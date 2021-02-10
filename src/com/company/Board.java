package com.company;

import com.company.figures.*;

import java.util.Arrays;
import java.util.List;


public class Board {
    private AbstractFigure[][] board = new AbstractFigure[8][8];
    private boolean isCheck;

    public Board() {
        //black start
        board[0][0] = new Rook("black", 0, 0, 'r');
        board[0][1] = new Knight("black", 0, 1, 'n');
        board[0][2] = new Bishop("black", 0, 2, 'b');
        board[0][3] = new Queen("black", 0, 3, 'q');
        board[0][4] = new King("black", 0, 4, 'k');
        board[0][5] = new Bishop("black", 0, 5, 'b');
        board[0][6] = new Knight("black", 0, 6, 'n');
        board[0][7] = new Rook("black", 0, 7, 'r');

        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn("black", 1, i, 'p');
        }

        //white pieces start
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn("white", 6, i, 'P');
        }

        board[7][0] = new Rook("white", 7, 0, 'R');
        board[7][1] = new Knight("white", 7, 1, 'N');
        board[7][2] = new Bishop("white", 7, 2, 'B');
        board[7][3] = new Queen("white", 7, 3, 'Q');
        board[7][4] = new King("white", 7, 4, 'K');
        board[7][5] = new Bishop("white", 7, 5, 'B');
        board[7][6] = new Knight("white", 7, 6, 'N');
        board[7][7] = new Rook("white", 7, 7, 'R');
    }

    public AbstractFigure[][] getBoard() {
        return board;
    }

    public void setBoard(AbstractFigure[][] board) {
        this.board = board;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public void play (List<String> lines) throws InterruptedException {
        AbstractFigure[][] elements = getBoard();

        for (String line : lines) {
            drawBoard();
            Thread.sleep(1000);

            int[] move = new int[]{line.charAt(0) - 97, 56 - line.charAt(1), line.charAt(2) - 97, 56 - line.charAt(3)};
            int fromX = move[1];
            int fromY = move[0];
            int toX = move[3];
            int toY = move[2];

            AbstractFigure figure = elements[fromX][fromY];
            if (isPositionsValid(fromX, fromY, toX, toY) && figure.validateMove(fromX, fromY,toX, toY, this)) {
                elements[toX][toY] = elements[fromX][fromY];
                elements[fromX][fromY] = null;
            } else {
                System.out.println("Invalid move!\n");
                continue;
            }

            setBoard(elements);
            if (isCheck) System.out.println("Check!");
            isCheck = false;
        }
    }

    private void drawBoard() {
        fillEmptyCells();

        for (AbstractFigure[] row : board) {
            Arrays.stream(row).map(AbstractFigure::getName).forEach(System.out::print);
            System.out.println();
        }
        System.out.println();
    }

    private void fillEmptyCells() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == null) {
                    if (i % 2 == 0) {
                        if (j % 2 == 0) board[i][j] = new BlackCell(i, j);
                        else board[i][j] = new WhiteCell(i, j);
                    } else {
                        if (j % 2 == 0) board[i][j] = new WhiteCell(i, j);
                        else board[i][j] = new BlackCell(i, j);
                    }
                }
            }
        }
    }

    private boolean isPositionsValid(int fromX, int fromY, int toX, int toY) {
        return fromX >= 0 && fromX <= 7 && fromY >= 0 && fromY <= 7
                && toX >= 0 && toX <= 7 && toY >= 0 && toY <= 7;
    }
}
