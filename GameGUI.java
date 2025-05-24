/**
 * Represents a casino game player with a name and chip balance.
 */
public class Player {
    private final String name;
    private int chips;

    /**
     * Constructs a new player with the specified name and 100 starting chips.
     *
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
        this.chips = 100;
    }

    /** @return the name of the player */
    public String getName() { return name; }

    /** @return the current chip count of the player */
    public int getChips() { return chips; }

    /**
     * Adds chips to the player's total.
     *
     * @param amount the number of chips to add
     */
    public void addChips(int amount) { chips += amount; }

    /**
     * Subtracts chips from the player's total.
     *
     * @param amount the number of chips to subtract
     */
    public void subtractChips(int amount) { chips -= amount; }
}
