import javax.swing.*;

/**
 * The War class implements the card game "War" where the player draws one card and compares it to an opponent's card.
 * <p>
 * The player places a bet, draws a card, and wins or loses chips depending on whose card is higher.
 * In the event of a tie, no chips are exchanged. This class extends the abstract Game class.
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
     * Starts and manages a round of the War game using the provided JFrame for dialog windows.
     * Handles betting, card drawing, result calculation, and presenting end-of-round options.
     *
     * @param frame the JFrame used for displaying dialogs and messages
     */
    @Override
    public void play(JFrame frame) {
        // Prompt for bet
        int bet = 0;
        while (bet <= 0 || bet > player.getChips()) {
            String input = JOptionPane.showInputDialog(frame, "Enter your bet (1 - " + player.getChips() + "): ");
            if (input == null) return; // cancel returns to menu
            try {
                bet = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                bet = 0;
            }
        }

        // Draw and display player's card
        Card playerCard = deck.draw();
        JOptionPane.showMessageDialog(frame, "Your card:\n" + playerCard.getAsciiArt());

        // Draw and display opponent's card
        Card opponentCard = deck.draw();
        JOptionPane.showMessageDialog(frame, "Opponent's card:\n" + opponentCard.getAsciiArt());

        // Determine and show result
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
     * Shows the end-of-round dialog, displays the outcome, and provides options to play again,
     * return to the menu, or exit the game.
     *
     * @param frame   the JFrame used for dialogs
     * @param message the result message to display
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
