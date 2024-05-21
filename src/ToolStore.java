public class ToolStore extends NormalLoc {

    static Weapon[] weapons = {new Weapon("Gun", 1, 2, 15),
            new Weapon("Sword", 2, 3, 35),
            new Weapon("Rifle", 3, 7, 45)};
    static Armor[] armors = {new Armor(1, "Light Armor", 1, 15),
            new Armor(2, "Middle Armor", 3, 25),
            new Armor(3, "Heavy Armor", 5, 40)};

    ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    boolean onLocation() {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Welcome the Tool Store!");
            System.out.println("1-Weapons, 2-Armors, 3-Exit");
            int toolChoose = input.nextInt();
            while (toolChoose<1 || toolChoose>3) {
                System.out.println("Please enter correct data!");
                toolChoose = input.nextInt();
            }
            switch (toolChoose) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Hope to see you again!");
                    isExit = true;
                    break;
            }
        }
        return true;
    }

    private void printWeapon() {
        System.out.println("--------------------Weapons--------------------");
        for (Weapon w:weapons) {
            System.out.println("id: "+w.getId()+", Name: "+w.getName()+", Damage: "+w.getDamage()+", Price: "+w.getPrice());
        }
        System.out.println("0 - For Exit");
    }

    private void buyWeapon() {
        System.out.print("Enter the id of the weapon you want: ");
        int selectWeaponId = input.nextInt();
        while (selectWeaponId<0 || selectWeaponId>weapons.length) {
            System.out.println("Please enter correct data!");
            selectWeaponId = input.nextInt();
        }
        if (selectWeaponId!=0) {
            if (selectWeapon(selectWeaponId)!=null) {
                if (getPlayer().getMoney()<weapons[selectWeaponId-1].getPrice()) {
                    System.out.println("You don't have enough money!");
                } else {
                    int balance = getPlayer().getMoney() - weapons[selectWeaponId-1].getPrice();
                    getPlayer().setMoney(balance);
                    System.out.println("Your remaining money: "+getPlayer().getMoney());
                    System.out.println("Before weapon:"+getPlayer().getInventory().getWeapon().getName());
                    getPlayer().getInventory().setWeapon(selectWeapon(selectWeaponId));
                    System.out.println("New weapon: "+getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }

    private Weapon selectWeapon(int id) {
        for (Weapon w:weapons) {
            if (w.getId()==id) {
                return weapons[id-1];
            }
        }
        return null;
    }

    private void printArmor() {
        System.out.println("--------------------Armors--------------------");
        for (Armor armor:armors) {
            System.out.println( armor.getId()+
                                "-"+ armor.getName()+
                                ", Block: "+ armor.getBlock()+
                                ", Price: "+ armor.getPrice());
        }
        System.out.println("0 - For Exit");
    }

    private void buyArmor() {
        System.out.print("Which armor do you want? Please select id: ");
        int armorChoose = input.nextInt();
        while (armorChoose<0 || armorChoose>armors.length) {
            System.out.println("Please enter correct data!");
            armorChoose = input.nextInt();
        }
        if (armorChoose!=0) {
            if (selectArmor(armorChoose)!=null) {
                if (getPlayer().getMoney()<armors[armorChoose-1].getPrice()) {
                    System.out.println("You don't have enough money!");
                } else {
                    int balance = getPlayer().getMoney()-armors[armorChoose-1].getPrice();
                    System.out.println("You buy the "+armors[armorChoose-1].getName()+"!");
                    getPlayer().setMoney(balance);
                    System.out.println("Your remaining money: "+getPlayer().getMoney());
                    getPlayer().getInventory().setArmor(selectArmor(armorChoose));
                }
            }
        }
    }

    private Armor selectArmor(int id) {
        for (Armor armor : armors) {
            if (armor.getId() == id) {
                return armors[id - 1];
            }
        }
        return null;
    }

}
