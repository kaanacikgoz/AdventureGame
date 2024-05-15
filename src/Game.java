class Game {

    private Player player;
    private Location location;

    Game(Player player, Location location) {
        this.player = player;
        this.location = location;
    }

    Player getPlayer() {
        return this.player;
    }

    void setPlayer(Player player) {
        this.player = player;
    }

    Location getLocation() {
        return this.location;
    }

    void setLocation(Location location) {
        this.location = location;
    }

    void start() {

    }

}
