package main.java;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ExitButton extends JButton {

    int breite = 50;
    int hoehe = 50;

    public ExitButton(Background hintergrund) {

        ImageIcon icon = new ImageIcon("resources\\ExitSymbol.png");

        this.setBounds(0, hintergrund.getHeight() - hoehe, breite, hoehe);
        this.addActionListener(e -> System.exit(0));
        this.setIcon(icon);
        this.setBackground(Color.WHITE);
    }
}
