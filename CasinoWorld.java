import javax.swing.*;

public class CasinoWorld {
    public void playBlackjack(JFrame frame, Player player) {
        new Blackjack(player).play(frame);
    }

    public void playWar(JFrame frame, Player player) {
        new War(player).play(frame);
    }
}