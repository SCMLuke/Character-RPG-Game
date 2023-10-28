package classes;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CharacterScreen extends JPanel {

        //Labels with hard-coded text.
    private JLabel characterGeneratorTitle;
    private JLabel enterNameTitle;
    private JLabel characterSelectTitle;
    private JLabel characterStatsTitle;
    private JLabel selectYourWeaponTitle;
    private JLabel weaponStatsTitle;

        //Labels that have overridden properties.
    private JLabel characterImage;
    private JLabel characterStats;
    private JLabel weaponImage;
    private JLabel weaponStats;

        //Buttons/Text fields.
    private JTextField nameEntryBox;
    private JButton rerollButton;
    private JButton startButton;

    //Radio Buttons.
    private JRadioButton rdoWarrior;
    private JRadioButton rdoPaladin;
    private JRadioButton rdoMage;
    private JRadioButton rdoSword;
    private JRadioButton rdoStaff;

    //For final display.
    private Warrior warrior;
    private Paladin paladin;
    private Mage mage;



    public CharacterScreen() {
        //Font
        Font myFont = new Font("Calibri", Font.BOLD, 24);
        Font myFontSmall = new Font("Calibri", Font.BOLD, 16);

        //Set Panel Properties
        setLayout(null);

        //Label properties with hard-coded text.
        characterGeneratorTitle = new JLabel("Make Your Character");
        characterGeneratorTitle.setFont(myFont);
        characterGeneratorTitle.setBounds(260,10,300,50);

        enterNameTitle = new JLabel("Enter Name:");
        enterNameTitle.setFont(myFont);
        enterNameTitle.setBounds(30,60,200,50);

        characterSelectTitle = new JLabel("Select Class:");
        characterSelectTitle.setFont(myFont);
        characterSelectTitle.setBounds(30,120,200,50);

        characterStatsTitle = new JLabel("Character Stats:");
        characterStatsTitle.setFont(myFont);
        characterStatsTitle.setBounds(450,120,200,50);

        selectYourWeaponTitle = new JLabel("Select Weapon:");
        selectYourWeaponTitle.setFont(myFont);
        selectYourWeaponTitle.setBounds(30,360,200,50);

        weaponStatsTitle = new JLabel("Weapon Stats:");
        weaponStatsTitle.setFont(myFont);
        weaponStatsTitle.setBounds(450,360,200,50);

        add(characterGeneratorTitle);
        add(enterNameTitle);
        add(characterSelectTitle);
        add(characterStatsTitle);
        add(selectYourWeaponTitle);
        add(weaponStatsTitle);



        //Labels with overwritten values.
        characterImage = new JLabel("Selected Class");
        characterImage.setFont(myFontSmall);
        characterImage.setBounds(225,120,150,150);

        characterStats = new JLabel("Character Stats");
        characterStats.setFont(myFontSmall);
        characterStats.setBounds(450,120,150,150);

        weaponImage = new JLabel("Selected Weapon");
        weaponImage.setFont(myFontSmall);
        weaponImage.setBounds(225,370,150,150);

        weaponStats = new JLabel("Weapon Stats");
        weaponStats.setFont(myFontSmall);
        weaponStats.setBounds(450,370,150,150);

        add(characterImage);
        add(characterStats);
        add(weaponImage);
        add(weaponStats);



        //Buttons and Text Fields.
        nameEntryBox = new JTextField();
        nameEntryBox.setFont(myFont);
        nameEntryBox.setBounds(180,60,200,40);

        rerollButton = new JButton("Reroll");
        rerollButton.setFont(myFont);
        rerollButton.setBounds(450,300,100,35);

        startButton = new JButton("Fight!");
        startButton.setFont(myFont);
        startButton.setBounds(250,600,200,50);

        add(nameEntryBox);
        add(rerollButton);
        add(startButton);



        //Get the method containing the radios and add the buttons to the frame.
        addCharacterRadios(myFont);
        add(rdoWarrior);
        add(rdoPaladin);
        add(rdoMage);

        addWeaponRadios(myFont);
        add(rdoSword);
        add(rdoStaff);
    }

    //Methods for making/organizing the radio buttons.
    private void addCharacterRadios(Font myFont) {
        rdoWarrior = new JRadioButton("Warrior");
        rdoWarrior.setFont(myFont);
        rdoWarrior.setBounds(30,170,150,50);
        rdoWarrior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Warrior warrior = MainFrame.getTheWarrior();
                characterStats.setText(warrior.getPlayerInfoString());
                characterImage.setIcon(warrior.getClassPicture());
            }
        });

        rdoPaladin = new JRadioButton("Paladin");
        rdoPaladin.setFont(myFont);
        rdoPaladin.setBounds(30,220,150,50);
        rdoPaladin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Paladin paladin = MainFrame.getThePaladin();
                characterStats.setText(paladin.getPlayerInfoString());
                characterImage.setIcon(paladin.getClassPicture());
            }
        });

        rdoMage = new JRadioButton("Mage");
        rdoMage.setFont(myFont);
        rdoMage.setBounds(30,270,150,50);
        rdoMage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mage mage = MainFrame.getTheMage();
                characterStats.setText(mage.getPlayerInfoString());
                characterImage.setIcon(mage.getClassPicture());
            }
        });

        ButtonGroup grpPlayerClassRadios = new ButtonGroup();
        grpPlayerClassRadios.add(rdoWarrior);
        grpPlayerClassRadios.add(rdoPaladin);
        grpPlayerClassRadios.add(rdoMage);
    }



    private void addWeaponRadios(Font myFont) {
        WeaponInfo weapon = MainFrame.getTheWeapons().get(0);
        rdoSword = new JRadioButton(weapon.getWeaponName());
        rdoSword.setFont(myFont);
        rdoSword.setBounds(30,400,150,50);
        rdoSword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WeaponInfo sword = MainFrame.getTheSword();
                weaponStats.setText(sword.getWeaponInfoString());
                weaponImage.setIcon(sword.getSwordIcon());
            }
        });

        weapon = MainFrame.getTheWeapons().get(1);
        rdoStaff = new JRadioButton(weapon.getWeaponName());
        rdoStaff.setFont(myFont);
        rdoStaff.setBounds(30,450,150,50);
        rdoStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WeaponInfo staff = MainFrame.getTheStaff();
                weaponStats.setText(staff.getWeaponInfoString());
                weaponImage.setIcon(staff.getStaffIcon());
            }
        });

        ButtonGroup grpWeaponButtons = new ButtonGroup();
        grpWeaponButtons.add(rdoSword);
        grpWeaponButtons.add(rdoStaff);
    }


    public JButton getStartButton() {
        return startButton;
    }

    public JButton getRerollButton() {
        return rerollButton;
    }

    public JRadioButton getRdoWarrior() {
        return rdoWarrior;
    }

    public JRadioButton getRdoPaladin() {
        return rdoPaladin;
    }

    public JRadioButton getRdoMage() {
        return rdoMage;
    }

    public JRadioButton getRdoSword() {
        return rdoSword;
    }

    public JRadioButton getRdoStaff() {
        return rdoStaff;
    }

    public JLabel getCharacterStats() {
        return characterStats;
    }

    public void createFinalOutput() {
        String name = nameEntryBox.getText();
        if (rdoWarrior.isSelected()) {
            if (rdoSword.isSelected()) {
                MainFrame.setSelectedWeapon(0);
            } else if (rdoStaff.isSelected()) {
                MainFrame.setSelectedWeapon(1);
            }
            warrior = MainFrame.getTheWarrior();
            warrior.setWeapon(MainFrame.getTheWeapons().get(MainFrame.getSelectedWeapon()));
            warrior.setName(name);
        } else if (rdoPaladin.isSelected()) {
            if (rdoSword.isSelected()) {
                MainFrame.setSelectedWeapon(0);
            } else if (rdoStaff.isSelected()) {
                MainFrame.setSelectedWeapon(1);
            }
            paladin = MainFrame.getThePaladin();
            paladin.setWeapon(MainFrame.getTheWeapons().get(MainFrame.getSelectedWeapon()));
            paladin.setName(name);
        } else if (rdoMage.isSelected()) {
            if (rdoSword.isSelected()) {
                MainFrame.setSelectedWeapon(0);
            } else if (rdoStaff.isSelected()) {
                MainFrame.setSelectedWeapon(1);
            }
            mage = MainFrame.getTheMage();
            mage.setWeapon(MainFrame.getTheWeapons().get(MainFrame.getSelectedWeapon()));
            mage.setName(name);
        }
    }
}
