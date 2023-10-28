package classes;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class MainFrame extends JFrame {

    private static Warrior theWarrior;
    private static Paladin thePaladin;
    private static Mage theMage;
    private static Monster theMonster;
    private static ArrayList<WeaponInfo> theWeapons = new ArrayList<>();
    private static WeaponInfo theSword;
    private static WeaponInfo theStaff;
    private static int selectedWeapon = 0;

    private static Random randomMonster;
    private static Random randomPlayer;

    public MainFrame() {

        randomMonster = new Random();
        int monsterHealthRandom = randomMonster.nextInt(80);
        int monsterMagicRandom = randomMonster.nextInt(80);;
        int monsterAttackRandom = randomMonster.nextInt(80);;
        int monsterDefenseRandom = randomMonster.nextInt(80);;
        int monsterExpRandom = randomMonster.nextInt(500);

        theWarrior = new Warrior(60,70,40,20,null);
        thePaladin = new Paladin(50,50,60,30,null);
        theMage = new Mage(40,30,30,90,null);
        theMonster = new Monster(monsterHealthRandom,monsterAttackRandom,monsterDefenseRandom,monsterMagicRandom,monsterExpRandom);

        theSword = new WeaponInfo("Sword",1.5,0.3);
        theStaff = new WeaponInfo("Staff",0.5,1.5);
        theWeapons.add(theSword);
        theWeapons.add(theStaff);

        //Set the properties of the frame.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 750, 750);
        setTitle("RPG");
        setLayout(new CardLayout());

        //Add the panels.
        OpeningScreen openingScreen = new OpeningScreen();
        CharacterScreen characterScreen = new CharacterScreen();
        BattleScreen battleScreen = new BattleScreen();
        add(openingScreen);
        add(characterScreen);
        add(battleScreen);


        //Functionality of the buttons.
        JButton beginButton = openingScreen.getBeginButton();
        beginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openingScreen.setVisible(false);
                characterScreen.setVisible(true);
            }
        });

        JButton startButton = characterScreen.getStartButton();
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                characterScreen.setVisible(false);
                characterScreen.createFinalOutput();
                battleScreen.setVisible(true);
                battleScreen.displayUserChoice();
            }
        });

        JButton rerollButton = characterScreen.getRerollButton();
        rerollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton rdoMage = characterScreen.getRdoMage();
                JRadioButton rdoWarrior = characterScreen.getRdoWarrior();
                JRadioButton rdoPaladin = characterScreen.getRdoPaladin();
                JLabel characterStats = characterScreen.getCharacterStats();
                randomPlayer = new Random();
                int playerHealthRandom = randomPlayer.nextInt(80);
                int playerMagicRandom = randomPlayer.nextInt(80);;
                int playerAttackRandom = randomPlayer.nextInt(80);;
                int playerDefenseRandom = randomPlayer.nextInt(80);;
                if (rdoWarrior.isSelected()) {
                    theWarrior.setHealth(playerHealthRandom);
                    theWarrior.setAttackPower(playerAttackRandom);
                    theWarrior.setDefensePower(playerDefenseRandom);
                    theWarrior.setMagicPower(playerMagicRandom);
                    characterStats.setText(theWarrior.getPlayerInfoString());
                } else if (rdoPaladin.isSelected()) {
                    thePaladin.setHealth(playerHealthRandom);
                    thePaladin.setAttackPower(playerAttackRandom);
                    thePaladin.setDefensePower(playerDefenseRandom);
                    thePaladin.setMagicPower(playerMagicRandom);
                    characterStats.setText(thePaladin.getPlayerInfoString());
                } else if (rdoMage.isSelected()) {
                    theMage.setHealth(playerHealthRandom);
                    theMage.setAttackPower(playerAttackRandom);
                    theMage.setDefensePower(playerDefenseRandom);
                    theMage.setMagicPower(playerMagicRandom);
                    characterStats.setText(theMage.getPlayerInfoString());
                }
            }
        });

        JButton endButton = battleScreen.getBackButton();
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }

    public static Warrior getTheWarrior() {
        return theWarrior;
    }

    public static Paladin getThePaladin() {
        return thePaladin;
    }

    public static Mage getTheMage() {
        return theMage;
    }

    public static Monster getTheMonster() {
        return theMonster;
    }

    public static WeaponInfo getTheSword() {
        return theSword;
    }

    public static WeaponInfo getTheStaff() {
        return theStaff;
    }

    public static ArrayList<WeaponInfo> getTheWeapons() {
        return theWeapons;
    }

    public static int getSelectedWeapon() {
        return selectedWeapon;
    }

    public static void setSelectedWeapon(int selectedWeapon) {
        MainFrame.selectedWeapon = selectedWeapon;
    }
}
