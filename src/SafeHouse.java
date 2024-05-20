class SafeHouse extends NormalLoc {

    SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    boolean onLocation() {
        if (isWin()) {
            return false;
        }
        System.out.println("You are in the safe house!");
        System.out.println("Your health is filling up!");
        this.getPlayer().setHealth(getPlayer().getOriginalHealth());
        return true;
    }

    boolean isWin() {
        return getPlayer().getInventory().getFood() == 1 &&
                getPlayer().getInventory().getFirewood() == 1 &&
                getPlayer().getInventory().getWater() == 1;
    }
}
