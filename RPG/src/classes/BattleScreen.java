package classes;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class BattleScreen extends JPanel {
    private JTextArea playerText;
    private JTextArea monsterText;
    private JLabel characterImage;
    private JLabel monsterImage;
    private JLabel battleText;
    private JButton backButton;
    private Warrior warrior;
    private Paladin paladin;
    private Mage mage;
    private Monster monster;

    public BattleScreen() {

        Font myFont = new Font("Calibri", Font.BOLD, 24);

        //Set Panel Properties
        setLayout(null);

        characterImage = new JLabel();
        characterImage.setFont(myFont);
        characterImage.setBounds(50,50,150,150);
        add(characterImage);

        monster = MainFrame.getTheMonster();
        monsterImage = new JLabel();
        monsterImage.setFont(myFont);
        monsterImage.setBounds(525,50,150,150);
        monsterImage.setIcon(monster.getClassPicture());
        add(monsterImage);

        battleText = new JLabel("Battle Results:");
        battleText.setFont(myFont);
        battleText.setBounds(280,15,500,100);
        add(battleText);

        playerText = new JTextArea();
        playerText.setBounds(50,250,300,300);
        playerText.setFont(myFont);
        playerText.setLineWrap(true);
        playerText.setEnabled(false);
        playerText.setWrapStyleWord(true);
        add(playerText);

        monsterText = new JTextArea();
        monsterText.setBounds(375,250,300,300);
        monsterText.setFont(myFont);
        monsterText.setLineWrap(true);
        monsterText.setEnabled(false);
        monsterText.setWrapStyleWord(true);
        add(monsterText);

        backButton = new JButton("Finish!");
        backButton.setFont(myFont);
        backButton.setBounds(260,600,200,50);
        add(backButton);
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void displayUserChoice() {
        warrior = MainFrame.getTheWarrior();
        paladin = MainFrame.getThePaladin();
        mage = MainFrame.getTheMage();
        monster = MainFrame.getTheMonster();
        String text = " ";


        if (warrior.getName() != null && warrior.getName() != "") {
            text = warrior.toString();
            characterImage.setIcon(warrior.getClassPicture());
        } else if (paladin.getName() != null && paladin.getName() != "") {
            text = paladin.toString();
            characterImage.setIcon(paladin.getClassPicture());
        } else if (mage.getName() != null && mage.getName() != "") {
            text = mage.toString();
            characterImage.setIcon(mage.getClassPicture());
        }
        playerText.setText(text);
        monsterText.setText(monster.toString());
    }

    public JLabel getCharacterImage() {
        return characterImage;
    }

    public void setCharacterImage(JLabel characterImage) {
        this.characterImage = characterImage;
    }
}
