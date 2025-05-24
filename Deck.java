import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a standard 52-card deck used in card games.
 * <p>
 * Supports shuffling and drawing cards in sequence.
 */
public class Deck {
    private final List<Card> cards = new ArrayList<>();
    private int currentIndex = 0;

    /**
     * Constructs a new deck containing all 52 standard playing cards.
     * Initializes the deck but does not shuffle it.
     */
    public Deck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int[] vals =     {2,   3,   4,   5,   6,   7,   8,   9,   10,   10,     10,     10,     11};

        for (String s : suits)
            for (int i = 0; i < ranks.length; i++)
                cards.add(new Card(s, ranks[i], vals[i]));
    }

    /**
     * Shuffles the deck and resets the draw index to the beginning.
     */
    public void shuffle() {
        Collections.shuffle(cards);
        currentIndex = 0;
    }

    /**
     * Draws the next card from the deck.
     * If all cards have been drawn, the deck is automatically reshuffled.
     *
     * @return the next Card in the deck
     */
    public Card draw() {
        if (currentIndex >= cards.size()) shuffle();
        return cards.get(currentIndex++);
    }
}
