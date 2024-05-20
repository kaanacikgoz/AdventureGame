class SafeHouse extends NormalLoc {

    SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    boolean onLocation() {
        System.out.println("You are in the safe house!");
        System.out.println("Your health is filling up!");
        this.getPlayer().setHealth(getPlayer().getOriginalHealth());
        return true;
    }
}
