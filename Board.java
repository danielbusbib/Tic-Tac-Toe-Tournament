/**
 * Board Class.
 */
public class Board {
    /**
     * size of the board, with default value 4.
     */
    private int size = 4;
    /**
     * 2D array representing the marks in the board.
     */
    private Mark[][] board_game;

    /**
     * Default Ctr - initialize new Board
     */
    Board() {
        this.board_game = new Mark[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board_game[i][j] = Mark.BLANK;
            }
        }
    }

    /**
     * Ctr with given size of board.
     * @param size size of board
     */
    Board(int size) {
        this.size = size;
        this.board_game = new Mark[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board_game[i][j] = Mark.BLANK;
            }
        }
    }

    /**
     * Getter - get size of board
     * @return size
     */
    public int getSize(){
        return this.size;
    }

    /**
     * Getter - get board representation
     * @return board 2d array
     */
    public Mark[][] getBoard(){
        return this.board_game;
    }

    /**
     * Try to put Mark in (row, col) cell
     * @param mark Mark
     * @param row row index
     * @param col col index
     * @return true if succeeded, else false.
     */
    public boolean putMark(Mark mark, int row, int col) {
        // validate that the (row,col) is legal
        if (!is_valid(row, col) || this.board_game[row][col] != Mark.BLANK) {
            return false;
        }
        this.board_game[row][col] = mark;
        return true;
    }

    /**
     * Get the Mark in specific cell on board
     * @param row row index
     * @param col col index
     * @return current mark in cell
     */
    public Mark getMark(int row, int col) {
        // check row,col are legal index.
        if (!is_valid(row, col)) {
            return Mark.BLANK;
        }
        return this.board_game[row][col];
    }

    /**
     * return true if row,col are valid index in board,
     * else false.
     */
    private boolean is_valid(int row, int col) {
        return row >= 0 && row < this.size && col >= 0 && col < this.size;
    }
}
