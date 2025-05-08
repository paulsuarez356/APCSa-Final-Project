public class Card {
    private final String suit;
    private final String rank;
    private final int value;

    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public String getSuit() { return suit; }
    public String getRank() { return rank; }
    public int getValue() { return value; }

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
