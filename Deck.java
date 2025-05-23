import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a standard deck of playing cards.
 * <p>
 * This class handles creation, shuffling, and drawing of cards. It automatically
 * reshuffles the deck when all cards have been drawn.
 */
public class Deck {
    /**
     * The list of cards in the deck.
     */
    private final List<Card> cards = new ArrayList<>();

    /**
     * The index of the next card to be drawn.
     */
    private int currentIndex = 0;

    /**
     * Constructs a standard deck of 52 playing cards.
     * <p>
     * Each card has a suit ("Hearts", "Diamonds", "Clubs", "Spades") and a rank
     * ("2" through "10", "Jack", "Queen", "King", "Ace") with associated values.
     * Face cards have a value of 10, and Ace has a value of 11.
     */
    public Deck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int[] vals =    {2,     3,     4,     5,     6,     7,     8,     9,     10,      10,       10,        10,      11};
        for (String s : suits)
            for (int i = 0; i < ranks.length; i++)
                cards.add(new Card(s, ranks[i], vals[i]));
    }

    /**
     * Shuffles the deck and resets the draw index.
     * <p>
     * After shuffling, cards will be drawn from the top of the shuffled deck.
     */
    public void shuffle() {
        Collections.shuffle(cards);
        currentIndex = 0;
    }

    /**
     * Draws the next card from the deck.
     * <p>
     * If all cards have been drawn, the deck is automatically reshuffled.
     *
     * @return the next Card in the deck
     */
    public Card draw() {
        if (currentIndex >= cards.size())
            shuffle();
        return cards.get(currentIndex++);
    }
}
