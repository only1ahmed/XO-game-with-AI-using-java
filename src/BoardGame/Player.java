package BoardGame;

import BoardGame.Coordinates;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Player {

    public static Scanner input = new Scanner(System.in);
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public Coordinates getMove() {
        int row, column;
        try {
            row = input.nextInt();
            column = input.nextInt();
            return new Coordinates(row, column);
        } catch (InputMismatchException e) {
            input.nextLine();
            //the user needs to enter a valid move
            return new Coordinates(-1, -1);
        }

    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
}
