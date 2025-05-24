/**
 * Represents a player in the casino application.
 * <p>
 * The Player class holds the player's name and chip count, and provides methods
 * to access and modify these properties.
 */
public class Player {
    /**
     * The player's name.
     */
    private final String name;

    /**
     * The amount of chips the player currently has.
     */
    private int chips = 100;

    /**
     * Constructs a new Player with the specified name.
     * The player starts with a default chip count of 100.
     *
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the player.
     *
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the number of chips the player currently has.
     *
     * @return the player's chip count
     */
    public int getChips() {
        return chips;
    }

    /**
     * Adds the specified amount to the player's chip count.
     *
     * @param amount the number of chips to add
     */
    public void addChips(int amount) {
        chips += amount;
    }

    /**
     * Subtracts the specified amount from the player's chip count.
     * The chip count will not go below zero.
     *
     * @param amount the number of chips to subtract
     */
    public void removeChips(int amount) {
        chips -= amount;
        if (chips < 0) chips = 0;
    }

    public void subtractChips(int bet) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subtractChips'");
    }
}
