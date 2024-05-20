class Player extends Game {

    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private String name;
    private Inventory inventory;

    Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    int getTotalDamage() {
        return this.damage + inventory.getWeapon().getDamage();
    }
    int getDamage() {
        return damage;
    }

    void setDamage(int damage) {
        this.damage = damage;
    }

    int getHealth() {
        return health;
    }

    void setHealth(int health) {
        if (health<0) {
            health=0;
        }
        this.health = health;
    }

    int getMoney() {
        return money;
    }

    void setMoney(int money) {
        this.money = money;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    Inventory getInventory() {
        return inventory;
    }

    void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    int getOriginalHealth() {
        return originalHealth;
    }

    void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    void selectChar() {
        GameChar[] charList = {new GameChar("Samurai", 5, 21, 15),
                new GameChar("Archer", 7, 18, 20),
                new GameChar("Knight", 8, 24, 5)};
        System.out.println("Characters");
        System.out.println("----------------------------------------------------------");
        for (GameChar chars : charList) {
            System.out.println(chars.getName() +
                    ", Damage is " + chars.getDamage() +
                    ", Health is " + chars.getHealth() +
                    ", Money is " + chars.getMoney());
        }
        System.out.println("----------------------------------------------------------");
        System.out.print("Please select your character? 1/Samurai, 2/Archer, 3/Knight: ");
        int choose = input.nextByte();
        switch (choose) {
            case 1:
                initChar(new GameChar("Samurai", 5, 21, 15));
                break;
            case 2:
                initChar(new GameChar("Archer", 7, 18, 20));
                break;
            case 3:
                initChar(new GameChar("Knight", 8, 24, 5));
                break;
            default:
                System.out.println("Please enter correct data!");
                selectChar();
                return;
        }
        System.out.println("Your choice is " + this.getName() +
                ", Damage is " + this.getDamage() +
                ", Health is " + this.getHealth() +
                ", Money is " + this.getMoney());
    }

    void initChar(GameChar gameChar) {
        this.setName(gameChar.getName());
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOriginalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
    }

    void playerInfo() {
        System.out.println("Your weapon " + getInventory().getWeapon().getName() +
                ", Damage is " + this.getDamage() +
                ", Armor is " + getInventory().getArmor().getName() +
                ", Block is " + getInventory().getArmor().getBlock() +
                ", Health is " + this.getHealth() +
                ", Money is " + this.getMoney());
    }


}
