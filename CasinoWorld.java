import javax.swing.*;

/**
 * Acts as a controller to launch specific games from the casino.
 * <p>
 * Provides methods to start Blackjack or War using a shared GUI frame and player instance.
 */
public class CasinoWorld {

    /**
     * Launches a round of Blackjack using the specified frame and player.
     *
     * @param frame  the JFrame used for displaying dialogs
     * @param player the player participating in the game
     */
    public void playBlackjack(JFrame frame, Player player) {
        new Blackjack(player).play(frame);
    }

    /**
     * Launches a round of War using the specified frame and player.
     *
     * @param frame  the JFrame used for displaying dialogs
     * @param player the player participating in the game
     */
    public void playWar(JFrame frame, Player player) {
        new War(player).play(frame);
    }
}
