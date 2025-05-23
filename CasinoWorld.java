import javax.swing.*;

/**
 * Facilitates access to different casino games within the application.
 * <p>
 * The CasinoWorld class provides methods to launch various games, such as Blackjack and War,
 * using the provided graphical interface and player instance.
 */
public class CasinoWorld {

    /**
     * Starts a game of Blackjack for the specified player.
     * <p>
     * This method creates a new Blackjack game instance and launches the game UI in the specified frame.
     *
     * @param frame  the JFrame to use for dialog windows and game display
     * @param player the Player who will play the Blackjack game
     */
    public void playBlackjack(JFrame frame, Player player) {
        new Blackjack(player).play(frame);
    }

    /**
     * Starts a game of War for the specified player.
     * <p>
     * This method creates a new War game instance and launches the game UI in the specified frame.
     *
     * @param frame  the JFrame to use for dialog windows and game display
     * @param player the Player who will play the War game
     */
    public void playWar(JFrame frame, Player player) {
        new War(player).play(frame);
    }
}
