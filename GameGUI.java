import javax.swing.*;

/**
 * Provides a graphical user interface (GUI) for the ASCII Casino World application.
 * <p>
 * The GameGUI class displays a welcome menu that allows the player to select
 * a casino game to play or exit the application. It initializes and launches
 * the chosen game using the provided player instance.
 */
public class GameGUI {

    /**
     * The player currently using the casino application.
     */
    private final Player player;

    /**
     * Constructs a new GameGUI for the specified player.
     *
     * @param player the Player using the casino application
     */
    public GameGUI(Player player) {
        this.player = player;
    }

    /**
     * Displays the main casino menu as a GUI window.
     * <p>
     * The menu greets the player, shows their current chip count, and presents
     * options to play Blackjack, War, or exit the application. Launches the
     * selected game or exits the program based on the user's choice.
     */
    public void show() {
        JFrame frame = new JFrame("ASCII Casino World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        String[] options = {"Blackjack", "War", "Exit"};
        int choice = JOptionPane.showOptionDialog(frame,
                "Welcome, " + player.getName() + "!\nChips: " + player.getChips(),
                "Casino Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == 0) {
            new Blackjack(player).play(frame);
        } else if (choice == 1) {
            new War(player).play(frame);
        } else {
            System.exit(0);
        }
    }
}
