import javax.swing.*;

/**
 * Implements the card game "War" as a casino game.
 * <p>
 * The War class extends the abstract Game class and provides the logic for a
 * simple card game where the player and an opponent each draw a single card,
 * compare values, and adjust chips based on the outcome.
 */
public class War extends Game {

    /**
     * Constructs a new War game for the specified player.
     *
     * @param player the Player participating in the War game
     */
    public War(Player player) {
        super(player);
    }

    /**
     * Starts and manages a round of the War game.
     * <p>
     * Prompts the player for a bet, draws cards for the player and the opponent,
     * determines the winner, updates the player's chips, and displays the result.
     * Offers the player options to play again, return to the menu, or exit.
     *
     * @param frame the JFrame used for displaying dialogs and messages
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

        Card playerCard = deck.draw();
        JOptionPane.showMessageDialog(frame, "Your card:\n" + playerCard.getAsciiArt());
        Card opponentCard = deck.draw();
        JOptionPane.showMessageDialog(frame, "Opponent's card:\n" + opponentCard.getAsciiArt());

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
     * Displays the end-of-round dialog and handles the user's next action.
     * <p>
     * Shows the result message, updated chip count, and offers options to
     * play again, return to menu, or exit the application.
     *
     * @param frame   the JFrame used for displaying the dialog
     * @param message the message describing the round's outcome
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
