import java.util.*;
import javax.swing.*;

/**
 * The Blackjack class implements a simple Blackjack game with GUI interaction.
 * <p>
 * It allows a player to place bets, draw cards, and play against a dealer following standard Blackjack rules.
 * Messages and dialogs guide the player through the game round.
 * This class extends the Game class and interacts with Player, Card, and GameGUI classes.
 */
public class Blackjack extends Game {

    /**
     * Constructs a new Blackjack game for the specified player.
     *
     * @param player the Player participating in the game
     */
    public Blackjack(Player player) {
        super(player);
    }

    /**
     * Starts and manages a round of Blackjack using the provided JFrame for dialog windows.
     * Handles the player's betting, card drawing, decision making, dealer logic, and determines the outcome.
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

        List<Card> playerHand = new ArrayList<>();
        List<Card> dealerHand = new ArrayList<>();

        // Deal cards one by one to player and dealer
        playerHand.add(deck.draw());
        JOptionPane.showMessageDialog(frame, "Your first card:\n" + playerHand.get(0).getAsciiArt());
        playerHand.add(deck.draw());
        JOptionPane.showMessageDialog(frame, "Your second card:\n" + playerHand.get(1).getAsciiArt());

        dealerHand.add(deck.draw());
        JOptionPane.showMessageDialog(frame, "Dealer shows:\n" + dealerHand.get(0).getAsciiArt());

        int playerTotal = getHandValue(playerHand);
        int dealerTotal = getHandValue(dealerHand);

        // Player's turn: choose hit or stay
        boolean playerTurn = true;
        while (playerTurn && playerTotal < 21) {
            StringBuilder msg = new StringBuilder("Your cards (Total: " + playerTotal + "):\n");
            for (Card c : playerHand) msg.append(c.getAsciiArt()).append("\n");
            msg.append("Hit or Stay?");

            int choice = JOptionPane.showOptionDialog(frame, msg.toString(), "Blackjack",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, new Object[]{"Hit", "Stay"}, "Hit");

            if (choice == 0) {
                Card newCard = deck.draw();
                playerHand.add(newCard);
                JOptionPane.showMessageDialog(frame, "Drew:\n" + newCard.getAsciiArt());
                playerTotal = getHandValue(playerHand);
            } else {
                playerTurn = false;
            }
        }

        // Check if player busted
        if (playerTotal > 21) {
            player.subtractChips(bet);
            showEnd(frame, "Busted with " + playerTotal + "! You lose " + bet + " chips.", bet);
            return;
        }

        // Dealer's turn: dealer draws until 17 or higher
        while (dealerTotal < 17) {
            Card newCard = deck.draw();
            dealerHand.add(newCard);
            dealerTotal = getHandValue(dealerHand);
        }

        // Show dealer hand
        StringBuilder dealerMsg = new StringBuilder("Dealer's cards (Total: " + dealerTotal + "):\n");
        for (Card c : dealerHand) dealerMsg.append(c.getAsciiArt()).append("\n");
        JOptionPane.showMessageDialog(frame, dealerMsg.toString());

        // Determine outcome
        String result;
        if (dealerTotal > 21 || playerTotal > dealerTotal) {
            player.addChips(bet);
            result = "You win! You gain " + bet + " chips.";
        } else if (playerTotal < dealerTotal) {
            player.subtractChips(bet);
            result = "You lose! You lose " + bet + " chips.";
        } else {
            result = "Push! No chips lost.";
        }
        showEnd(frame, result, bet);
    }

    /**
     * Calculates the total value of a Blackjack hand.
     * Aces are counted as 11 unless that would cause the hand to bust, in which case they count as 1.
     *
     * @param hand the list of Card objects representing a hand
     * @return the integer value of the hand
     */
    private int getHandValue(List<Card> hand) {
        int total = 0, aces = 0;
        for (Card c : hand) {
            total += c.getValue();
            if (c.getRank().equals("Ace")) aces++;
        }
        while (total > 21 && aces > 0) {
            total -= 10; aces--;
        }
        return total;
    }

    /**
     * Shows the end-of-game dialog, displays the outcome, and provides options for the player to play again,
     * return to the menu, or exit.
     *
     * @param frame   the JFrame for displaying dialogs
     * @param message the result message to display
     * @param bet     the bet amount for the round
     */
    private void showEnd(JFrame frame, String message, int bet) {
        String full = message + "\nChips: " + player.getChips();
        int choice = JOptionPane.showOptionDialog(frame, full + "\nWhat next?", "Game Over",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, new Object[]{"Play Again", "Menu", "Exit"}, "Menu");
        if (choice == 0) play(frame);
        else if (choice == 1) new GameGUI(player).show();
        else System.exit(0);
    }
}
