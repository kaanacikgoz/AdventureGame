class Inventory extends Player {

    private boolean water;
    private boolean food;
    private boolean firewood;
    private String weaponName;
    private String armorName;
    private byte weaponDamage;
    private byte armorDefence;

    Inventory(Player player, Location location, Inventory inventory, byte damage, byte health, byte money, String name, boolean water, boolean food, boolean firewood, String weaponName, String armorName, byte weaponDamage, byte armorDefence) {
        super(player, location, inventory, damage, health, money, name);
        this.water = water;
        this.food = food;
        this.firewood = firewood;
        this.weaponName = weaponName;
        this.armorName = armorName;
        this.weaponDamage = weaponDamage;
        this.armorDefence = armorDefence;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public byte getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(byte weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public byte getArmorDefence() {
        return armorDefence;
    }

    public void setArmorDefence(byte armorDefence) {
        this.armorDefence = armorDefence;
    }
}
