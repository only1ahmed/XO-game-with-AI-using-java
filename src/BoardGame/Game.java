package BoardGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Game {
    protected Board board;
    protected Player[] players;

    protected static Scanner input = new Scanner(System.in);

    public Game() {
        initBoard();
    }

    public void run() {
        boolean APP_ON = true;
        welcomeMessage();
        menu();
        play();
        int choice;
        while (APP_ON) {
            System.out.print("\n\nThank you for playing the Game!\nDo you want to play again ?\n1) YES\n2) hell no!\n\n(please enter the number of your choice)\n: ");
            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\n\nOK OK, I am leaving now\nThank you for trying to crash me -_-");
                APP_ON = false;
                break;
            }
            switch (choice) {
                default: {
                    System.out.println("\n\nOK OK, I am leaving now\nThank you for trying to crash me -_-");
                    APP_ON = false;
                    break;
                }
                case 1: {
                    System.out.println("\n\n\n");
                    initBoard();
                    menu();
                    play();
                    break;
                }
                case 2: {
                    System.out.println("Thank you for playing the game!\nAgain XD\nByeeeee");
                    APP_ON = false;
                }

            }
        }
    }


    public void play() {
        boolean gameOn = true;
        Coordinates coordinates;
        while (gameOn) {
            for (int turn : new int[]{0, 1}) {
                System.out.print("Player ");
                System.out.print(turn + 1);
                System.out.println(" turn");
                board.display();

                coordinates = players[turn].getMove();
                while (!isValidMove(coordinates)) {
                    System.out.println("please enter a valid move...\n");
                    coordinates = players[turn].getMove();
                }

                board.update(coordinates, players[turn].getSymbol());

                if (board.isWinner(players[turn])) {
                    System.out.print("\nCongrats  player");
                    System.out.print(turn + 1);
                    System.out.print(" " + players[turn].getName());
                    System.out.println("!!");

                    gameOn = false;
                    break;
                }

                if (board.isDraw()) {
                    System.out.println("\nGG, it is a draw!\n");
                    gameOn = false;
                    break;
                }

            }
        }
        board.display();

    }

    protected boolean isValidMove(Coordinates coordinates) {
        return board.isValidMove(coordinates);
    }

    protected abstract void welcomeMessage();

    protected abstract void menu();

    protected abstract void initPlayers(Player player1, Player player2);

    protected abstract void initBoard();

    protected abstract Coordinates transform(int position);
}
