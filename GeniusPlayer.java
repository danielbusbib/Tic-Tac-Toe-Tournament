/**
 * Genius Player class.
 * Strategy ---> choose first column and fill it, else
 * use clever player strategy.
 */
public class GeniusPlayer implements Player {
    /**
     * Ctr - define new player.
     */
    public GeniusPlayer() {}

    /**
     * play single turn of genius player, based on his strategy.
     * @param board Board
     * @param mark current player mark
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        for (int i = 0; i < board.getSize(); i++)
            if (board.putMark(mark, i, 1))
                return;
        CleverPlayer cleverPlayer = new CleverPlayer();
        cleverPlayer.playTurn(board, mark);
    }
}
