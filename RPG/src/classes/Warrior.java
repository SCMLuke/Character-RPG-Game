package classes;

import javax.swing.*;

public class Warrior extends Player {
    public Warrior(int health, int attackPower, int defensePower, int magicPower, String name) {
        super(health, attackPower, defensePower, magicPower, name);
        super.setClassPicture(new ImageIcon(this.getClass().getResource("/images/warrior.png")));
    }


    @Override
    public String getPlayerInfoString() {
        return "<html> Health: "+this.getHealth()+" Attack: "+this.getAttackPower()+"<br/> Defense: "+this.getDefensePower()+" Magic: "+this.getMagicPower()+"</html>";
    }
    @Override
    public String toString() {
        return "PLAYER STATS\n----------------\n"+"Name: "+super.getName()+"\nHealth: "+super.getHealth()+"\nAttack: "+super.getAttackPower()+"\nDefense: "+super.getDefensePower()+"\nMagic: "+super.getMagicPower()+this.getWeapon();
    }
}
