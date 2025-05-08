import javax.swing.*;

public class War extends Game {
    public War(Player player) {
        super(player);
    }

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