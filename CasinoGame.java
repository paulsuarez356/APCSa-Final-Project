import javax.swing.*;

/**
 * Entry point for the ASCII Casino World application.
 * <p>
 * Prompts the player for their name and launches the game menu.
 */
public class CasinoGame {

    /**
     * Main method to start the casino game application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog(null, "Enter your player name:");
        if (name == null || name.trim().isEmpty()) name = "Player";
        Player player = new Player(name);
        new GameGUI(player).show();
    }
}
