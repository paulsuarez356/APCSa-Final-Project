import javax.swing.*;

/**
 * Displays the main menu GUI for selecting and launching casino games.
 */
public class GameGUI {
    private final Player player;

    /**
     * Constructs a new GameGUI for the specified player.
     *
     * @param player the player interacting with the menu
     */
    public GameGUI(Player player) {
        this.player = player;
    }

    /**
     * Displays the main menu where the user can choose to play Blackjack, War, or Exit.
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
