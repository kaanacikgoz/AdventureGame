abstract class Location extends Game {

    private String name;

    Location(Player player, Location location, String name) {
        super(player, location);
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    abstract boolean onLocation();

}
