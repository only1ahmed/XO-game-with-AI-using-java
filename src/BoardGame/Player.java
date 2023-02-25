package BoardGame;

import BoardGame.Coordinates;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Player {

    private static Scanner input = new Scanner(System.in);
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public int getMove() {
        int move;
        try {
            move = input.nextInt();
        } catch (InputMismatchException e) {
            input.nextLine();
            //the user needs to enter a valid move
            move = -1;
        }

        return move;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
}
