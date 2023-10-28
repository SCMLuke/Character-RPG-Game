package classes;

import javax.swing.*;

public abstract class Player extends Being {
    private String name;
    private WeaponInfo weapon;

    public Player(int health, int attackPower, int defensePower, int magicPower, String name) {
        super(health, attackPower, defensePower, magicPower);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeaponInfo getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponInfo weapon) {
        this.weapon = weapon;
    }



    //Info string+
    public abstract String getPlayerInfoString();
}
