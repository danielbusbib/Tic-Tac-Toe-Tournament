/**
 * Clever Player Class.
 * Strategy ---> first put all marks possible in row 0,
 * then, column 0 and finally in the board main diagonal,
 * else choose whatever player strategy.
 */
public class CleverPlayer implements Player {
    /**
     * Ctr - define new player.
     */
    public CleverPlayer(){}

    /**
     * play single turn based on the Clever player strategy.
     * @param board Board
     * @param mark current player mark
     */
    public void playTurn(Board board, Mark mark) {
        for (int i = 0; i < board.getSize(); i++) {
            if (board.putMark(mark, 0, i))
                return;
        }
        for (int i = 0; i < board.getSize(); i++) {
            if (board.putMark(mark, i, 0))
                return;
        }
        for (int i = 0; i < board.getSize(); i++) {
            if (board.putMark(mark, i, i))
                return;
        }

        WhateverPlayer randomMove = new WhateverPlayer();
        randomMove.playTurn(board, mark);
    }
}
