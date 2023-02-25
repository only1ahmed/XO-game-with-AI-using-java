package XOgame;

import BoardGame.Coordinates;
import BoardGame.Player;

import java.util.InputMismatchException;

public class XOPlayer extends Player {
    public XOPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public Coordinates getMove() {
        int position, row, column;
        try {
            position = input.nextInt();
            position--;
            row = position / 3;
            column = position % 3;
            return new Coordinates(row, column);
        } catch (InputMismatchException e) {
            input.nextLine();
            //the user needs to enter a valid move
            return new Coordinates(-1, -1);
        }
    }
}
