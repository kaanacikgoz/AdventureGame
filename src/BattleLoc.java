import java.util.Random;

public abstract class BattleLoc extends Location {

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    private final Random random = new Random();

    BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    boolean onLocation() {
        int obsNumber = random.nextInt(getMaxObstacle()) + 1;
        System.out.println("You are here now: " + getName());
        System.out.println("Watch your step!, There are " + obsNumber + " " + getObstacle().getName() + " here!");
        System.out.print("Press S for Battle or R for Run: ");
        String selectCase = input.next().toUpperCase();
        if (selectCase.equals("S") && combat(obsNumber)) {
            System.out.println(getPlayer().getName() + " kill obstacles!");
            return true;
        }
        if (getPlayer().getHealth() <= 0) {
            System.out.println("You Died!!");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber) {
        int kill = 0;
        for (int i = 1; i <= obsNumber; i++) {
            getObstacle().setHealth(getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
            int randomStart = random.nextInt(100);
            while (getPlayer().getHealth() > 0 && getObstacle().getHealth() > 0) {
                System.out.print("Press for T-Tackle or R-Run: ");
                String battleChoose = input.next().toUpperCase();
                if (battleChoose.equals("T")) {
                    if (randomStart >= 50) {
                        System.out.println("You hit!");
                        getObstacle().setHealth(getObstacle().getHealth() - getPlayer().getTotalDamage());
                        afterHit();
                        if (getObstacle().getHealth() > 0) {
                            System.out.println("Obstacle hit!");
                            int obstacleDamage = getPlayer().getHealth() - getObstacle().getDamage();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            getPlayer().setHealth(obstacleDamage + getPlayer().getInventory().getArmor().getBlock());
                            afterHit();
                        }
                    } else {
                        System.out.println("Obstacle hit!");
                        int obstacleDamage = getPlayer().getHealth() - getObstacle().getDamage();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        getPlayer().setHealth(obstacleDamage + getPlayer().getInventory().getArmor().getBlock());
                        afterHit();
                        if (getPlayer().getHealth() > 0) {
                            System.out.println("You hit!");
                            getObstacle().setHealth(getObstacle().getHealth() - getPlayer().getTotalDamage());
                            afterHit();
                        }
                    }
                } else {
                    return false;
                }
            }
            if (getObstacle().getHealth() < getPlayer().getHealth()) {
                kill++;
                System.out.println("You killed enemy");
                System.out.println("You earn " + getObstacle().getAward() + " money!");
                getPlayer().setMoney(getPlayer().getMoney() + getObstacle().getAward());
                System.out.println("Your current money: " + getPlayer().getMoney());
            } else {
                return false;
            }
        }
        if (kill == obsNumber) {
            battleAwards();
        }
        return true;
    }

    public void battleAwards() {
        switch (getName()) {
            case "Cave":
                getPlayer().getInventory().setFood(1);
                System.out.println("You earn Food!");
                break;
            case "Forest":
                getPlayer().getInventory().setFirewood(1);
                System.out.println("You earn Firewood!");
                break;
            case "River":
                getPlayer().getInventory().setWater(1);
                System.out.println("You earn Water!");
                break;
            case "Mine":
                int randomNum = random.nextInt(100);
                int randomNum2 = random.nextInt(100);
                if (randomNum < 15) {
                    if (randomNum2 < 50) {
                        System.out.print("Snake drop the gun. Do you want to take?: Y/N");
                        if (input.next().equalsIgnoreCase("Y")) {
                            getPlayer().getInventory().setWeapon(ToolStore.weapons[0]);
                        }
                    } else if (randomNum2 < 80) {
                        System.out.print("Snake drop the Sword. Do you want to take?: Y/N");
                        if (input.next().equalsIgnoreCase("Y")) {
                            getPlayer().getInventory().setWeapon(ToolStore.weapons[1]);
                        }
                    } else {
                        System.out.print("Snake drop the Rifle. Do you want to take? Y/N: ");
                        if (input.next().equalsIgnoreCase("Y")) {
                            getPlayer().getInventory().setWeapon(ToolStore.weapons[2]);
                        }
                    }
                } else if (randomNum < 30) {
                    if (randomNum2 < 50) {
                        System.out.print("Snake drop the Light Armor. Do you want to take? Y/N: ");
                        if (input.next().equalsIgnoreCase("Y")) {
                            getPlayer().getInventory().setArmor(ToolStore.armors[0]);
                            getPlayer().getInventory().getArmor().setBlock(getPlayer().getInventory().getArmor().getBlock());
                        }
                    } else if (randomNum2 < 80) {
                        System.out.print("Snake drop the Middle Armor. Do you want to take? Y/N: ");
                        if (input.next().equalsIgnoreCase("Y")) {
                            getPlayer().getInventory().setArmor(ToolStore.armors[1]);
                            getPlayer().getInventory().getArmor().setBlock(getPlayer().getInventory().getArmor().getBlock());
                        }
                    } else {
                        System.out.print("Snake drop the Heavy Armor. Do you want to take? Y/N: ");
                        if (input.next().equalsIgnoreCase("Y")) {
                            getPlayer().getInventory().setArmor(ToolStore.armors[2]);
                            getPlayer().getInventory().getArmor().setBlock(getPlayer().getInventory().getArmor().getBlock());
                        }
                    }
                } else if (randomNum < 55) {
                    if (randomNum2 < 50) {
                        getPlayer().setMoney(getPlayer().getMoney()+1);
                        System.out.println("You earn 1 money!");
                    } else if (randomNum2 < 80) {
                        getPlayer().setMoney(getPlayer().getMoney()+5);
                        System.out.println("You earn 5 money!");
                    } else {
                        getPlayer().setMoney(getPlayer().getMoney()+10);
                        System.out.println("You earn 10 money!");
                    }
                }
        }
    }

    public void playerStats() {
    System.out.println("Player Stats");
    System.out.println("--------------------");
    System.out.println("Health: " + getPlayer().getHealth() +
            ", Weapon is: " + getPlayer().getInventory().getWeapon().getName() +
            ", Damage: " + getPlayer().getTotalDamage() +
            ", Armor is: " + getPlayer().getInventory().getArmor().getName() +
            ", Block is: " + getPlayer().getInventory().getArmor().getBlock() +
            ", Money is: " + getPlayer().getMoney());
}

public void obstacleStats(int i) {
    System.out.println(i + ". " + getObstacle().getName() + " Stats");
    System.out.println("--------------------");
    System.out.println("Health: " + this.getObstacle().getHealth() +
            ", Damage: " + this.getObstacle().getDamage() +
            ", Award: " + this.getObstacle().getAward());
}

public void afterHit() {
    System.out.println("Your health: " + getPlayer().getHealth());
    System.out.println("Obstacle health: " + getObstacle().getHealth());
    System.out.println();
}

public Obstacle getObstacle() {
    return obstacle;
}

public void setObstacle(Obstacle obstacle) {
    this.obstacle = obstacle;
}

public String getAward() {
    return award;
}

public void setAward(String award) {
    this.award = award;
}

int getMaxObstacle() {
    return maxObstacle;
}

void setMaxObstacle(int maxObstacle) {
    this.maxObstacle = maxObstacle;
}

}
