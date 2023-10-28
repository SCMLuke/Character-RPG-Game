package classes;

import javax.swing.*;
import java.awt.*;

public class OpeningScreen extends JPanel {
    private JLabel titleLabel;
    private JLabel openingImageLabel;
    private JButton beginButton;

    public OpeningScreen() {
        //Font
        Font myFont = new Font("Calibri", Font.BOLD, 24);

        //Panel Properties
        setLayout(null);
        setVisible(true);

        //Opening text
        titleLabel = new JLabel("Bungeons and Bagpipes");
        titleLabel.setFont(myFont);
        titleLabel.setBounds(240,20,500,200);

        //Opening Picture
        openingImageLabel = new JLabel();
        openingImageLabel.setBounds(175,150,375,375);
        ImageIcon openingImage = new ImageIcon(getClass().getResource("/images/openinglandscape.jpg"));
        openingImageLabel.setIcon(openingImage);

        //Begin button
        beginButton = new JButton("Begin");
        beginButton.setFont(myFont);
        beginButton.setBounds(500,600,200,50);

        //Add all buttons to frame.
        add(titleLabel);
        add(openingImageLabel);
        add(beginButton);
    }

    public JButton getBeginButton() {
        return beginButton;
    }
}
