class Player extends Game {

    private Inventory inventory;
    private byte damage;
    private byte health;
    private byte money;
    private String name;

    Player(Player player, Location location, Inventory inventory, byte damage, byte health, byte money, String name) {
        super(player, location);
        this.inventory = inventory;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.name = name;
    }

    Inventory getInventory() {
        return this.inventory;
    }

    void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    byte getDamage() {
        return this.damage;
    }

    void setDamage(byte damage) {
        this.damage = damage;
    }

    byte getHealth() {
        return this.health;
    }

    void setHealth(byte health) {
        this.health = health;
    }

    byte getMoney() {
        return this.money;
    }

    void setMoney(byte money) {
        this.money = money;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    void selectChar() {
        System.out.print("Please select your character? 1/Samurai, 2/Archer, 3/Knight: ");
    }

}
