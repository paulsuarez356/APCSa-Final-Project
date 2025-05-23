import javax.swing.*;

/**
 * Entry point for the casino game application.
 * <p>
 * This class contains the main method which prompts the user for their name,
 * creates a Player, and launches the GameGUI.
 */
public class CasinoGame {

    /**
     * The main method that starts the casino game application.
     * <p>
     * Prompts the user for their player name using a dialog box. If the user input is empty or cancelled,
     * a default name "Player" is used. A Player instance is created and the graphical game interface
     * is launched.
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
