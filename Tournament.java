/**
 * Tournament Class.
 * The main purpose is to run some games between
 * two players.
 */
public class Tournament {
    /**
     * tournament number of rounds
     */
    private int rounds;

    /**
     * players array
     */
    private Player[] players;

    /**
     * tournament renderer (void/console)
     */
    private Renderer renderer;

    /**
     * Ctr - initialize new Tournament.
     *
     * @param rounds   rounds number
     * @param renderer Renderer
     * @param players  array of 2 players that are going to play.
     */
    public Tournament(int rounds, Renderer renderer, Player[] players) {
        this.rounds = rounds;
        this.renderer = renderer;
        this.players = players;
    }

    /**
     * Play tournament rounds time between the players.
     * @param size board size
     * @param winStreak win streak number
     * @param playerNames array of names of 2 players
     */
    public void playTournament(int size, int winStreak, String[] playerNames) {
        Game game;
        int ties = 0, winsPlayer1 = 0, winsPlayer2 = 0;
        for (int i = 0; i < this.rounds; i++) {
            // play game.
            if (i % 2 == 0) {
                game = new Game(this.players[0], this.players[1], size, winStreak, this.renderer);
            } else {
                game = new Game(this.players[1], this.players[0], size, winStreak, this.renderer);
            }
            // get winner of current game
            Mark winner = game.run();
            if (winner == Mark.BLANK) {
                ties++;
            } else if (winner == Mark.X) {
                if (i % 2 == 0) {
                    winsPlayer1++;
                } else {
                    winsPlayer2++;
                }
            } else {
                if (i % 2 == 0) {
                    winsPlayer2++;
                } else {
                    winsPlayer1++;
                }
            }
        }
        // print the tournament results.
        System.out.println("######### Results #########");
        System.out.println("Player 1," + playerNames[0] + " won: "+ winsPlayer1 + " rounds");
        System.out.println("Player 2," + playerNames[1] + " won: "+ winsPlayer2 + " rounds");
        System.out.println("Ties: " + ties);
    }

    /**
     * Main function.
     * @param args terminal arguments.
     *             assume they are 6 arguments.
     */
    public static void main(String[] args) {
        int roundsNumber = Integer.parseInt(args[0]);
        int size = Integer.parseInt(args[1]);
        int winStreak = Integer.parseInt(args[2]);

        // build renderer
        RendererFactory rendererFactory = new RendererFactory();
        Renderer renderer = rendererFactory.buildRenderer(args[3], size);

        // build players
        PlayerFactory playerFactory = new PlayerFactory();
        Player[] players = new Player[2];
        players[0] = playerFactory.buildPlayer(args[4].toLowerCase());
        players[1] = playerFactory.buildPlayer(args[5].toLowerCase());
        // check Typo in players name
        if (players[0] == null || players[1] == null){
            System.out.println("Choose a player, and start again");
            System.out.println("The players: [human, clever, whatever, genius]");
            return;
        }

        // initialize and play a tournament
        Tournament tournament = new Tournament(roundsNumber, renderer, players);
        tournament.playTournament(
                size,
                winStreak,
                new String[]{args[4].toLowerCase(), args[5].toLowerCase()});
    }
}
