/**
 * Game class.
 */
public class Game {
    /**
     * win streak size for the game, with default value 3.
     */
    private int winStreak=3;

    /**
     * game renderer.
     */
    private Renderer renderer;
    /**
     * player with mark X.
     */
    private Player playerX;

    /**
     * player with mark O.
     */
    private Player playerO;

    /**
     * game board instance.
     */
    private Board board;

    /**
     * game winner.
     */
    private Mark winner;


    /**
     * Default Ctr - initialize new Game.
     * @param playerX player 1
     * @param playerO player 2
     * @param renderer Renderer
     */
    public Game(Player playerX, Player playerO, Renderer renderer) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
        this.board = new Board();
        this.winner = Mark.BLANK;
    }

    /**
     * Ctr - with size and win streak given.
     * @param playerX player 1
     * @param playerO player 2
     * @param size board size
     * @param winStreak win streak size
     * @param renderer Renderer
     */
    public Game(Player playerX, Player playerO, int size, int winStreak, Renderer renderer) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
        if(!(winStreak<=size)){
            winStreak = size;
        }
        this.winStreak = winStreak;
        this.board = new Board(size);
        this.winner = Mark.BLANK;
    }

    /**
     * Get win streak of game.
     * @return win streak
     */
    public int getWinStreak(){
        return this.winStreak;
    }

    /**
     * Run the game.
     * @return the winner
     */
    public Mark run() {
        int i = 0;
        while (!this.gameEnded()) {
            this.renderer.renderBoard(this.board);
            if (i % 2 == 0) {
                playerX.playTurn(this.board, Mark.X);
                if(checkWinner(Mark.X)){
                    this.winner = Mark.X;
                }
            } else {
                playerO.playTurn(this.board, Mark.O);
                if(checkWinner(Mark.O)){
                    this.winner = Mark.O;
                }
            }
            i++;
        }
        return this.winner;
    }

    /**
     * return true if the game is over, else false.
     */
    private boolean gameEnded() {
        if (board_is_full()) {
            return true;
        }
        if (this.winner != Mark.BLANK) {
            return true;
        }
        return false;
    }

    /**
     * return true if cell is valid on board,
     * else false.
     */
    private boolean is_valid(int x, int y) {
            return x >= 0 && x < this.board.getSize() &&
                    y >= 0 && y < this.board.getSize();
    }

    /**
     * check if board is full, meaning that all
     * the cell in the board are X/O
     */
    private boolean board_is_full() {
        for (int i = 0; i < this.board.getSize(); i++) {
            for (int j = 0; j < this.board.getSize(); j++) {
                if (this.board.getBoard()[i][j] == Mark.BLANK) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * check if current player turn make him the winner.
     */
    private boolean checkWinner(Mark mark) {
        for (int x = 0; x < this.board.getSize(); x++) {
            for(int y=0; y < this.board.getSize(); y++){
                // check in all 8 directions if mark is winner.
                for (int i = 0; i < winStreak; i++)
                    if (checkWinStreak(mark,y + i, 1, x, 0))
                        return true;
                for (int i = 0; i < this.winStreak; i++)
                    if (checkWinStreak(mark,y + i, 1, x + i, -1))
                        return true;
                for (int i = 0; i < this.winStreak; i++)
                    if (checkWinStreak(mark,y + i, 1, x + i, 1))
                        return true;
                for (int i = 0; i < this.winStreak; i++)
                    if (checkWinStreak(mark, y, 0, x + i, 1))
                        return true;
                for (int i = 0; i < this.winStreak; i++)
                    if (checkWinStreak(mark,y - i, -1, x, 0))
                        return true;
                for (int i = 0; i < this.winStreak; i++)
                    if (checkWinStreak(mark,y - i, -1, x - i, -1))
                        return true;
                for (int i = 0; i < this.winStreak; i++)
                    if (checkWinStreak(mark, y, 0, x - i, -1))
                        return true;
                for (int i = 0; i < this.winStreak; i++)
                    if (checkWinStreak(mark,y - i, -1, x + i, 1))
                        return true;
            }
        }
        return false;
    }

    /**
     * check if (row,col) with shift create win streak
     * in the board.
     */
    private boolean checkWinStreak(Mark mark, int row, int rowShift, int col, int colShift) {
        for (int i = 0; i < this.winStreak; i++){
            if (!is_valid(row - i * rowShift, col - i * colShift))
                return false;  // invalid cell
            if(!(this.board.getBoard()[row - i * rowShift][col - i * colShift] == mark))
                return false;  // unmatched mark.
        }
        return true;
    }

}
