public interface Player {
    /**
     * play single turn of player mark
     * @param board Board
     * @param mark current player mark
     */
    void playTurn(Board board, Mark mark);
}
