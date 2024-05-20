import java.util.Random;

public abstract class BattleLoc extends Location {

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    int randomObstacleNumber() {
        Random random = new Random();
        return random.nextInt(getMaxObstacle())+1;
    }

    @Override
    boolean onLocation() {
        int obsNumber = randomObstacleNumber();
        System.out.println("You are here now: "+getName());
        System.out.println("Watch your step!, There are "+obsNumber+" "+getObstacle().getName()+" here!");
        System.out.print("Press S for Battle or R for Run: ");
        String selectCase = input.next().toUpperCase();
        if (selectCase.equals("S") && combat(obsNumber)) {
            System.out.println(getPlayer().getName()+" kill obstacles!");
            return true;
        }
        if (getPlayer().getHealth()<=0) {
            System.out.println("You Died!!!");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber) {
        for (int i=1;i<=obsNumber;i++) {
            getObstacle().setHealth(getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
            while (getPlayer().getHealth()>0 && getObstacle().getHealth()>0) {
                System.out.print("Press for T-Tackle or R-Run: ");
                String battleChoose = input.next().toUpperCase();
                if (battleChoose.equals("T")) {
                    System.out.println("You hit!");
                    getObstacle().setHealth(obstacle.getHealth()-getPlayer().getTotalDamage());
                    afterHit();
                    if (getObstacle().getHealth()>0) {
                        System.out.println("Obstacle hit!");
                        int obstacleDamage=getPlayer().getHealth()-getObstacle().getDamage();
                        if (obstacleDamage<0) {
                            obstacleDamage = 0;
                        }
                        getPlayer().setHealth(obstacleDamage+getPlayer().getInventory().getArmor().getBlock());
                        afterHit();
                    }
                } else {
                    return false;
                }
            }
            if (getObstacle().getHealth()<getPlayer().getHealth()) {
                System.out.println("You killed enemy");
                System.out.println("You earn " + getObstacle().getAward()+" money!");
                getPlayer().setMoney(getPlayer().getMoney()+getObstacle().getAward());
                System.out.println("Your current money: "+getPlayer().getMoney());
            } else {
                return false;
            }
        }
        return true;
    }

    public void playerStats() {
        System.out.println("Player Stats");
        System.out.println("--------------------");
        System.out.println("Health: "+ getPlayer().getHealth() +
                        ", Weapon is: "+getPlayer().getInventory().getWeapon().getName() +
                        ", Damage: "+ getPlayer().getTotalDamage() +
                        ", Armor is: "+getPlayer().getInventory().getArmor().getName() +
                        ", Block is: "+getPlayer().getInventory().getArmor().getBlock()  +
                        ", Money is: "+ getPlayer().getMoney());
    }

    public void obstacleStats(int i) {
        System.out.println(i +". "+getObstacle().getName()+" Stats");
        System.out.println("--------------------");
        System.out.println("Health: "+ this.getObstacle().getHealth() +
                            ", Damage: "+ this.getObstacle().getDamage() +
                            ", Award: "+ this.getObstacle().getAward());
    }

    public void afterHit() {
        System.out.println("Your health: "+getPlayer().getHealth());
        System.out.println("Obstacle health: "+getObstacle().getHealth());
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
