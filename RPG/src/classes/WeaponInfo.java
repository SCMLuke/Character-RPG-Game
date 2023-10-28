package classes;

import javax.swing.*;

public class WeaponInfo {
    private String weaponName;
    private double weaponPhysicalMultiplier;
    private double weaponMagicMultiplier;
    private ImageIcon swordIcon;
    private ImageIcon staffIcon;

    public WeaponInfo(String weaponName, double weaponPhysicalMultiplier, double weaponMagicMultiplier) {
        this.weaponName = weaponName;
        this.weaponPhysicalMultiplier = weaponPhysicalMultiplier;
        this.weaponMagicMultiplier = weaponMagicMultiplier;
        this.setStaffIcon(new ImageIcon(this.getClass().getResource("/images/staff.png")));
        this.setSwordIcon(new ImageIcon(this.getClass().getResource("/images/sword.png")));
    }

    public String getWeaponName() {
        return weaponName;
    }

    public double getWeaponPhysicalMultiplier() {
        return weaponPhysicalMultiplier;
    }

    public double getWeaponMagicMultiplier() {
        return weaponMagicMultiplier;
    }
    public String getWeaponInfoString() {
        return "<html> Attack Multiplier: "+weaponPhysicalMultiplier+"<br/> Magic Multiplier: "+weaponMagicMultiplier+"</html>";
    }

    @Override
    public String toString() {
        return "\nWeapon Name: "+getWeaponName()+"\nAttack Multiplier: "+getWeaponPhysicalMultiplier()+"\nMagic Multiplier: "+getWeaponMagicMultiplier();
    }

    public ImageIcon getSwordIcon() {
        return swordIcon;
    }

    public void setSwordIcon(ImageIcon swordIcon) {
        this.swordIcon = swordIcon;
    }

    public ImageIcon getStaffIcon() {
        return staffIcon;
    }

    public void setStaffIcon(ImageIcon staffIcon) {
        this.staffIcon = staffIcon;
    }
}
