package XOgame;

import BoardGame.Board;
import BoardGame.Coordinates;
import BoardGame.Player;

public class XOBoard extends Board {

    XOBoard(int rows, int columns) {
        super(rows, columns);
    }

    @Override
    public void display() {
        for (char[] row : board) {
            System.out.print("|");

            for (char element : row) {
                System.out.print(element + "|");
            }
            System.out.println();
        }
    }

    @Override
    public boolean isValidMove(Coordinates coordinates) {
        if (coordinates.getRow() >= 3 || coordinates.getColumn() >= 3 || coordinates.getRow() < 0 || coordinates.getColumn() < 0) {
            return false;
        }
        if (board[coordinates.getRow()][coordinates.getColumn()] != ' ') {
            return false;
        }
        return true;
    }

    @Override
    public boolean isWinner(Player player) {
        int numberOfCells;
        for (char[] row : board) {
            numberOfCells = 0;
            for (char cell : row) {
                if (cell == player.getSymbol()) {
                    numberOfCells++;
                }
            }
            if (numberOfCells == 3) {
                return true;
            }
        }
        for (int column = 0; column < 3; column++) {
            numberOfCells = 0;
            for (int row = 0; row < 3; row++) {
                if (board[row][column] == player.getSymbol()) {
                    numberOfCells++;
                }
            }
            if (numberOfCells == 3) {
                return true;
            }
        }
        numberOfCells = 0;
        for (int mid = 0; mid < 3; mid++) {
            if (board[mid][mid] == player.getSymbol()) {
                numberOfCells++;
            }
        }
        if (numberOfCells == 3) {
            return true;
        }
        numberOfCells = 0;
        for (int mid = 0; mid < 3; mid++) {
            if (board[mid][2 - mid] == player.getSymbol()) {
                numberOfCells++;
            }
        }
        if (numberOfCells == 3) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isDraw() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        // it returns true even if there is someone who won in the last more, make sure to call it after checking that there is no one who won.
        return true;
    }

    @Override
    public void boardFill() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                board[row][column] = ' ';
            }
        }
    }
}
