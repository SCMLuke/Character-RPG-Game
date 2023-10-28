package classes;

import javax.swing.*;

public class Monster extends Being {
    private int exp;

    public Monster(int health, int attackPower, int defensePower, int magicPower, int exp) {
        super(health, attackPower, defensePower, magicPower);
        this.exp = exp;
        super.setClassPicture(new ImageIcon(this.getClass().getResource("/images/monster.png")));
    }

    @Override
    public String toString() {
        return "MONSTER STATS\n----------------\n"+"Health: "+super.getHealth()+"\nAttack: "+super.getAttackPower()+"\nDefense: "+super.getDefensePower()+"\nMagic: "+super.getMagicPower();
    }
}
