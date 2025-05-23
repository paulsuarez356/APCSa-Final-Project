/**
 * Abstract base class for all casino games.
 * <p>
 * The Game class provides a common structure for casino-style games and manages
 * the player and a deck of cards. Subclasses must implement the play method to define
 * their game logic.
 */
public abstract class Game {

    /**
     * The player participating in the game.
     */
    protected Player player;

    /**
     * The deck of cards used in the game.
     */
    protected Deck deck;

    /**
     * Constructs a new Game with the specified player.
     * Initializes a new shuffled deck for the game.
     *
     * @param player the Player participating in the game
     */
    public Game(Player player) {
        this.player = player;
        this.deck = new Deck();
        deck.shuffle();
    }

    /**
     * Starts and manages a round of the game.
     * <p>
     * Subclasses must implement this method to provide the specific game logic.
     *
     * @param frame the JFrame used for displaying dialogs and messages
     */
    public abstract void play(javax.swing.JFrame frame);
}
