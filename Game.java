import javax.swing.*;

public abstract class Game {
    protected final Player player;
    protected final Deck deck;

    public Game(Player player) {
        this.player = player;
        this.deck = new Deck();
        this.deck.shuffle();
    }

    public abstract void play(JFrame frame);
}