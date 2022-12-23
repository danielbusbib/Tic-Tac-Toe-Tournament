import java.util.Scanner;

/**
 * Human Player Class.
 */
public class HumanPlayer implements Player{
    Scanner scanner = new Scanner(System.in);

    /**
     * Ctr - defining new player
     */
    public HumanPlayer(){}

    /**
     *  play single turn of the game.
     *  in charge of telling the board to put mark of current turn.
     * @param board Board
     * @param mark current player mark
     */
    @Override
    public void playTurn(Board board, Mark mark){
        int x,y; // x-> row, y-> col
        String coordinates;
        System.out.print("Player " + mark + ", type coordinates: ");
        coordinates = scanner.next(); // get user input ##
        x = Character.getNumericValue(coordinates.charAt(0));
        y = Character.getNumericValue(coordinates.charAt(1));
        while (!board.putMark(mark, x, y)){
            // invalid coordinates so ask again
            System.out.println("Invalid coordinates, type again: ");
            coordinates = scanner.next();
            x = Character.getNumericValue(coordinates.charAt(0));
            y = Character.getNumericValue(coordinates.charAt(1));
        }
    }
}

