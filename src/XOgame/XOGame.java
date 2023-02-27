package XOgame;

import BoardGame.*;

public class XOGame extends Game {


    @Override
    protected void welcomeMessage() {
        System.out.println("Welcome to the game of XO!\n\nTo play a move, you need to choose the number of the cell you wanna play.\n\nhere are the numbers of each cell:\n\n");
        System.out.println("|1|2|3|\n|4|5|6|\n|7|8|9|\n");
    }

    @Override
    protected void initPlayers(String player1, String player2) {
        players = new Player[2];
        players[0] = new XOPlayer(player1, 'X');
        players[1] = new XOPlayer(player2, 'O');

    }

    @Override
    protected void initBoard() {
        board = new XOBoard(3, 3);
    }

    @Override
    protected Coordinates transform(int position) {
        position--;
        int row = position / 3;
        int column = position % 3;
        return new Coordinates(row, column);
    }

}
