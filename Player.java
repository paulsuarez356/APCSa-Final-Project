public class Player {
    private final String name;
    private int chips;

    public Player(String name) {
        this.name = name;
        this.chips = 100;
    }

    public String getName() { return name; }
    public int getChips() { return chips; }
    public void addChips(int amount) { chips += amount; }
    public void subtractChips(int amount) { chips -= amount; }
}