import javax.swing.*;

public class GameGUI {
    private final Player player;

    public GameGUI(Player player) {
        this.player = player;
    }

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
