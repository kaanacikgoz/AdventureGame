public class GameChar {

    private String name;
    private int damage;
    private int health;
    private int money;

    GameChar(String name, int damage, int health, int money) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    String getName() {
        return this.name;
    }

    void setCharName(String name) {
        this.name = name;
    }

    int getDamage() {
        return this.damage;
    }

    void setDamage(int damage) {
        this.damage = damage;
    }

    int getHealth() {
        return this.health;
    }

    void setHealth(int health) {
        this.health = health;
    }

    int getMoney() {
        return this.money;
    }

    void setMoney(int money) {
        this.money = money;
    }

}
