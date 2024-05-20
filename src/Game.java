import java.util.Scanner;

class Game {

    private Player player;
    private Location location;
    Scanner input = new Scanner(System.in);

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
        System.out.println("Welcome the Adventure Game");
        System.out.print("Please enter your name: ");
        String charName = input.next().toUpperCase();
        Player player = new Player(charName);
        System.out.println("Dear "+player.getName()+", Welcome to this dark and foggy island, everything that will happen here is real.");
        player.selectChar();
        Location location=null;
        while (true) {
            player.playerInfo();
            System.out.println("Locations");
            System.out.println("1-Safe House\n2-Tool Store\n3-Cave\n4-Forest\n5-River\n0-Exit Game");
            System.out.print("Where do you want to go? Please select one: ");
            int locChoose = input.nextInt();
            switch (locChoose) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player); //SafeHouse(getPlayer()), niye olmuyor??
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Please enter a valid location");
            }
            if (location == null) {
                System.out.println("You quickly gave up on this dark and foggy island!");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("Game Over!");
                break;
            }
        }
    }

}
