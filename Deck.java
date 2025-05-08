import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards = new ArrayList<>();
    private int currentIndex = 0;

    public Deck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int[] vals =    {2,     3,     4,     5,     6,     7,     8,     9,     10,      10,       10,        10,      11};
        for (String s : suits) for (int i=0;i<ranks.length;i++) cards.add(new Card(s, ranks[i], vals[i]));
    }

    public void shuffle() {
        Collections.shuffle(cards);
        currentIndex = 0;
    }

    public Card draw() {
        if (currentIndex >= cards.size()) shuffle();
        return cards.get(currentIndex++);
    }
}