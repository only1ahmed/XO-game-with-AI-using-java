package BoardGame;

public abstract class Board {

    protected char[][] board;
    private int rowSize;
    private int columnSize;

    public Board(int rowSize, int columnSize) {
        board = new char[rowSize][columnSize];
        this.columnSize = columnSize;
        this.rowSize = columnSize;
        boardFill();
    }

    public void update(Coordinates coordinates, char value) {
        int row = coordinates.getRow();
        int column = coordinates.getColumn();
//        if (isValidMove(coordinates)) {
        board[row][column] = value;
//        }
    }

    public abstract void display();

    public abstract boolean isValidMove(Coordinates coordinates);

    public abstract boolean isWinner(Player player);

    public abstract boolean isDraw();

    protected abstract void boardFill();

}
