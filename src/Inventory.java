class Inventory {

    private Weapon weapon;
    private Armor armor;
    private static int food;
    private static int firewood;
    private static int water;

    Inventory() {
        this.weapon = new Weapon("Yumruk",-1,0,0);
        this.armor = new Armor(-1,"None",0,0);
        food = 0;
        firewood = 0;
        water = 0;
    }

    Weapon getWeapon() {
        return weapon;
    }

    void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    Armor getArmor() {
        return armor;
    }

    void setArmor(Armor armor) {
        this.armor = armor;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getFirewood() {
        return firewood;
    }

    public void setFirewood(int firewood) {
        this.firewood = firewood;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

}

