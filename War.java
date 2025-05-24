import javax.swing.*;

/**
 * The War class implements a simple card game where the player and an opponent draw one card each,
 * and the higher card wins.
 * <p>
 * The player places a bet and wins, loses, or ties based on the result.
 * This class extends the Game class and uses standard card drawing and betting logic.
 */
public class War extends Game {

    /**
     * Constructs a new War game for the specified player.
     *
     * @param player the Player participating in the game
     */
    public War(Player player) {
        super(player);
    }

    /**
     * Starts a round of War, prompting the user to bet and displaying the card results.
     *
     * @param frame the JFrame used for dialog display
     */
    @Override
    public void play(JFrame frame) {
        // Prompt for bet
        int bet = 0;
        while (bet <= 0 || bet > player.getChips()) {
            String input = JOptionPane.showInputDialog(frame, "Enter your bet (1 - " + player.getChips() + "): ");
            if (input == null) return;
            try { bet = Integer.parseInt(input); } catch (NumberFormatException e) { bet = 0; }
        }

        // Draw and show cards
        Card playerCard = deck.draw();
        JOptionPane.showMessageDialog(frame, "Your card:\n" + playerCard.getAsciiArt());
        Card opponentCard = deck.draw();
        JOptionPane.showMessageDialog(frame, "Opponent's card:\n" + opponentCard.getAsciiArt());

        // Determine winner
        String result;
        if (playerCard.getValue() > opponentCard.getValue()) {
            player.addChips(bet);
            result = "You win! Gained " + bet + " chips.";
        } else if (playerCard.getValue() < opponentCard.getValue()) {
            player.subtractChips(bet);
            result = "You lose! Lost " + bet + " chips.";
        } else {
            result = "Tie! No chips lost.";
        }

        showEnd(frame, result);
    }

    /**
     * Displays the outcome of the round and offers to replay, return to menu, or exit.
     *
     * @param frame   the JFrame for displaying dialogs
     * @param message the result message to show
     */
    private void showEnd(JFrame frame, String message) {
        String full = message + "\nChips: " + player.getChips();
        int choice = JOptionPane.showOptionDialog(frame, full + "\nWhat next?", "Round Over",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, new Object[]{"Play Again", "Menu", "Exit"}, "Menu");
        if (choice == 0) play(frame);
        else if (choice == 1) new GameGUI(player).show();
        else System.exit(0);
    }
}
