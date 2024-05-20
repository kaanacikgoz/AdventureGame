import java.util.Scanner;

abstract class Location {

    private Player player;
    private String name;
    Scanner input = new Scanner(System.in);

    Location(Player player, String name) {
        this.player = player;
        this.name = name;
    }

    Player getPlayer() {
        return player;
    }

    void setPlayer(Player player) {
        this.player = player;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    abstract boolean onLocation();

}
