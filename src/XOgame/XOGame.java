package XOgame;

import BoardGame.*;

import java.util.InputMismatchException;

public class XOGame extends Game {


    @Override
    protected void welcomeMessage() {
        System.out.println("Welcome to the game of XO!\n\nTo play a move, you need to choose the number of the cell you wanna play.\n\nhere are the numbers of each cell:\n\n");
        System.out.println("|1|2|3|\n|4|5|6|\n|7|8|9|\n");
    }

    @Override
    protected void menu() {
        String player1;
        String player2;
        int choice;
        System.out.println("What game mode do you want to play ?\n1) Computer vs Player\n2) Player vs Player\nEnter the number of your choise: ");
        boolean choiceOn = true;
        while (choiceOn) {
            try {
                choice = input.nextInt();
                switch (choice) {
                    default -> {
                        System.out.println("Please enter a valid option...\\nEnter the number of your choise: \"");
                        choice = input.nextInt();
                    }
                    case 1 -> {
                        input.nextLine();
                        System.out.println("\n\nplease player1 enter your name: ");
                        player1 = input.nextLine();
                        initPlayers(new XOPlayer(player1, 'X'), new ComputerPlayer((XOBoard) board, 'O'));
                        choiceOn = false;
                    }
                    case 2 -> {
                        input.nextLine();
                        System.out.println("\n\nplease player1 enter your name: ");
                        player1 = input.nextLine();
                        System.out.println("please player2 enter your name: ");
                        player2 = input.nextLine();
                        initPlayers(new XOPlayer(player1, 'X'), new XOPlayer(player2, 'O'));
                        choiceOn = false;

                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid option...\\nEnter the number of your choise: \"");
                choice = input.nextInt();

            }

        }
    }

    @Override
    protected void initPlayers(Player player1, Player player2) {
        players = new Player[2];
        players[0] = player1;
        players[1] = player2;

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
