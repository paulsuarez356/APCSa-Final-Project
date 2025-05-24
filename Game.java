import javax.swing.*;

/**
 * Abstract base class for casino games.
 * <p>
 * Provides shared structure and resources such as player reference and shuffled deck.
 * Specific games like Blackjack or War extend this class and implement the {@code play} method.
 */
public abstract class Game {
    /** The player participating in the game. */
    protected final Player player;

    /** The deck of cards used in the game. */
    protected final Deck deck;

    /**
     * Constructs a new game with a given player.
     * Initializes and shuffles the deck.
     *
     * @param player the Player participating in the game
     */
    public Game(Player player) {
        this.player = player;
        this.deck = new Deck();
        this.deck.shuffle();
    }

    /**
     * Starts the game. Must be implemented by concrete subclasses.
     *
     * @param frame the JFrame used for displaying dialogs and user interaction
     */
    public abstract void play(JFrame frame);
}
