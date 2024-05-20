class Inventory {

    private Weapon weapon;
    private Armor armor;

    Inventory() {
        this.weapon = new Weapon("Yumruk",-1,0,0);
        this.armor = new Armor(-1,"None",0,0);
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

}

