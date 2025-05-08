import javax.swing.*;

public class CasinoGame {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog(null, "Enter your player name:");
        if (name == null || name.trim().isEmpty()) name = "Player";
        Player player = new Player(name);
        new GameGUI(player).show();
    }
}