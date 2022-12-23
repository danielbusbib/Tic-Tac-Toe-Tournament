import java.util.Random;

/**
 * Whatever Player.
 * Strategy ---> choose random cells each turn.
 */
public class WhateverPlayer implements Player {
    /**
     * Ctr - defining new player.
     */
    public WhateverPlayer() {}

    /**
     * play single turn.
     * @param board Board
     * @param mark current player mark
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        Random random = new Random();
        int x, y;
        do {
            // take random cell index
            x = random.nextInt(board.getSize());
            y = random.nextInt(board.getSize());
        } while (!board.putMark(mark, x, y));
    }
}
