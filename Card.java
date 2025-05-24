/**
 * Represents a playing card with a suit, rank, and value.
 * <p>
 * Provides ASCII art representation for GUI display.
 */
public class Card {
    private final String suit;
    private final String rank;
    private final int value;

    /**
     * Constructs a Card with the specified suit, rank, and value.
     *
     * @param suit  the suit of the card (e.g., "Hearts")
     * @param rank  the rank of the card (e.g., "King")
     * @param value the numeric value of the card for game logic
     */
    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    /** @return the suit of the card */
    public String getSuit() { return suit; }

    /** @return the rank of the card */
    public String getRank() { return rank; }

    /** @return the numeric value of the card */
    public int getValue() { return value; }

    /**
     * Returns a string representing the card in ASCII-art style.
     * Used to visually display the card in GUI dialogs.
     *
     * @return ASCII-art representation of the card
     */
    public String getAsciiArt() {
        String l1 = "┌─────────┐";
        String l2 = String.format("│ %-2s      │", rank.length() > 2 ? rank.substring(0, 2) : rank);
        String l3 = "│         │";
        String l4 = String.format("│    %s    │", suit.charAt(0));
        String l5 = "│         │";
        String l6 = String.format("│      %-2s │", rank.length() > 2 ? rank.substring(0, 2) : rank);
        String l7 = "└─────────┘";
        return String.join("\n", l1, l2, l3, l4, l5, l6, l7);
    }
}
