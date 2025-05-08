import java.util.*;
import javax.swing.*;

public class Blackjack extends Game {
    public Blackjack(Player player) {
        super(player);
    }

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

        // Deal cards one by one
        playerHand.add(deck.draw());
        JOptionPane.showMessageDialog(frame, "Your first card:\n" + playerHand.get(0).getAsciiArt());
        playerHand.add(deck.draw());
        JOptionPane.showMessageDialog(frame, "Your second card:\n" + playerHand.get(1).getAsciiArt());

        dealerHand.add(deck.draw());
        JOptionPane.showMessageDialog(frame, "Dealer shows:\n" + dealerHand.get(0).getAsciiArt());

        int playerTotal = getHandValue(playerHand);
        int dealerTotal = getHandValue(dealerHand);

        // Player's turn
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

        // Check bust
        if (playerTotal > 21) {
            player.subtractChips(bet);
            showEnd(frame, "Busted with " + playerTotal + "! You lose " + bet + " chips.", bet);
            return;
        }

        // Dealer's turn
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
