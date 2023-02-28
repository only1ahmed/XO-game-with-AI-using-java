package XOgame;

import BoardGame.Coordinates;
import BoardGame.Player;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class ComputerPlayer extends XOPlayer {
    private XOBoard board;
    
    public ComputerPlayer(XOBoard board, char symbol) {
        super("Computer", symbol);
        this.board = board;
    }

    private int Minimax(Boolean isComputerTurn, char previousMove) {

        if (board.isWinner(this)) {
            return 1;
        }
        char playerSymbol;
        if (this.getSymbol() == 'X') {
            playerSymbol = 'O';
        } else {
            playerSymbol = 'X';
        }
        if (board.isWinner(new XOPlayer("temp", playerSymbol))) {
            return -1;
        }

        if (board.isDraw()) {
            return 0;
        }
        int Weight;
        if (isComputerTurn) {
            Weight = -100;
        } else {
            Weight = 100;
        }
        char nextMoveSymbol;
        if (previousMove == 'X') {
            nextMoveSymbol = 'O';
        } else {
            nextMoveSymbol = 'X';
        }
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (board.isValidMove(new Coordinates(row, column))) {
                    board.update(new Coordinates(row, column), nextMoveSymbol);
                    if (isComputerTurn) {
                        Weight = max(Weight, Minimax(!isComputerTurn, nextMoveSymbol));
                    } else {
                        Weight = min(Weight, Minimax(!isComputerTurn, nextMoveSymbol));
                    }
                    board.update(new Coordinates(row, column), ' ');
                    if (isComputerTurn && Weight == 1) {
                        return 1;
                    }
                    if (!isComputerTurn && Weight == -1) {
                        return -1;
                    }
                }
            }
        }
        return Weight;
    }

    @Override
    public Coordinates getMove() {

        int Weight = -2;
        int weightOfWining = -2;
        Coordinates coordinates = new Coordinates(-1, -1);
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (board.isValidMove(new Coordinates(row, column))) {

                    board.update(new Coordinates(row, column), this.getSymbol());
                    weightOfWining = max(weightOfWining, Minimax(false, this.getSymbol()));
                    board.update(new Coordinates(row, column), ' ');

                    if (weightOfWining > Weight) {
                        Weight = weightOfWining;
                        coordinates = new Coordinates(row, column);
                    }
                    if (Weight == 1) {
                        return coordinates;
                    }
                }
            }
        }
        return coordinates;
    }
}
