package BoardGame;

import BoardGame.Board;
import BoardGame.Coordinates;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Game {
    protected Board board;
    protected Player[] players;

    private static Scanner input = new Scanner(System.in);

    public Game() {
        initBoard();
    }

    public void run() {
        boolean APP_ON = true;
        String player1;
        String player2;
        welcome_message();
        System.out.println("\n\nplease player1 enter your name: ");
        player1 = input.nextLine();
        System.out.println("please player2 enter your name: ");
        player2 = input.nextLine();
        initPlayers(player1, player2);
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
                }
                case 1: {
                    System.out.println("\n\n\n");
                    initBoard();
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
        int position;
        while (gameOn) {
            for (int turn : new int[]{0, 1}) {
                System.out.print("Player ");
                System.out.print(turn + 1);
                System.out.println(" turn");
                board.display();
                position = players[turn].getMove();
                coordinates = transform(position);
                while (!isValidMove(coordinates)) {
                    System.out.println("please enter a valid move...\n");
                    position = players[turn].getMove();
                    coordinates = transform(position);
                }

                board.update(coordinates, players[turn].getSymbol());

                if (board.is_winner(players[turn])) {
                    System.out.print("\nCongrats  player");
                    System.out.print(turn + 1);
                    System.out.print(" " + players[turn].getName());
                    System.out.println("!!");
                    gameOn = false;
                    break;
                }

                if (board.is_draw()) {
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

    protected abstract void welcome_message();

    protected abstract void initPlayers(String player1, String player2);

    protected abstract void initBoard();

    protected abstract Coordinates transform(int position);
}
