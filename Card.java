/**
 * Represents a playing card with a suit, rank, and value.
 * <p>
 * The Card class is immutable and provides methods to access card properties.
 * It also includes a method to generate a simple ASCII art representation
 * of the card for display purposes.
 */
public class Card {
    /**
     * The suit of the card (e.g., "Hearts", "Spades").
     */
    private final String suit;

    /**
     * The rank of the card (e.g., "Ace", "2", "King").
     */
    private final String rank;

    /**
     * The value of the card for gameplay purposes.
     * For example, in Blackjack, Ace might be 11, face cards 10, etc.
     */
    private final int value;

    /**
     * Constructs a Card with the specified suit, rank, and value.
     *
     * @param suit  the suit of the card (e.g., "Hearts")
     * @param rank  the rank of the card (e.g., "Ace", "10", "King")
     * @param value the value of the card for game logic
     */
    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    /**
     * Gets the suit of the card.
     *
     * @return the suit of the card
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Gets the rank of the card.
     *
     * @return the rank of the card
     */
    public String getRank() {
        return rank;
    }

    /**
     * Gets the value of the card.
     *
     * @return the value of the card
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns an ASCII art representation of the card.
     * The ASCII art displays the card's rank and the first character of its suit.
     *
     * @return a string containing the ASCII art of the card
     */
    public String getAsciiArt() {
        String l1 = "┌─────────┐";
        String l2 = String.format("│ %-2s      │", rank.length() > 2 ? rank.substring(0,2) : rank);
        String l3 = "│         │";
        String l4 = String.format("│    %s    │", suit.charAt(0));
        String l5 = "│         │";
        String l6 = String.format("│      %-2s │", rank.length() > 2 ? rank.substring(0,2) : rank);
        String l7 = "└─────────┘";
        return String.join("\n", l1, l2, l3, l4, l5, l6, l7);
    }
}
