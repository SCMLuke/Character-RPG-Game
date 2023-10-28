package classes;

import javax.swing.*;

public abstract class Being {
    private int health;
    private int attackPower;
    private int defensePower;
    private int magicPower;
    private ImageIcon classPicture;

    public Being(int health, int attackPower, int defensePower, int magicPower) {
        this.health = health;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.magicPower = magicPower;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }

    public ImageIcon getClassPicture() {
        return classPicture;
    }

    public void setClassPicture(ImageIcon classPicture) {
        this.classPicture = classPicture;
    }

    //Override for showing player stats at the battle screen.
    @Override
    public String toString() {
        return "Player/Monster stats shown here with override.";
    }
}
