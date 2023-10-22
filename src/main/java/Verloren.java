package main.java;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Verloren extends JLabel {

    public Verloren(Background hintergrund, int spielfeldbreite, int spielfeldhoehe) {

        System.out.println("breize: " + spielfeldbreite + " Hoehe: " + spielfeldhoehe);

        int breiteText = spielfeldbreite;
        int hoeheText = (int) Math.round(spielfeldbreite / 5.1111111111);
        int xText = (spielfeldbreite / 2 - breiteText / 2);
        int yText = (spielfeldhoehe / 2 - hoeheText / 2);

        // Schriftgröße muss noch ausgerechent werden
        this.setFont(new Font("Arial", Font.PLAIN, 310));
        this.setText("Verloren");
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
        this.setForeground(Color.RED);
        this.setBackground(Color.black);
        this.setVisible(true);

        this.setBounds(xText, yText, breiteText, hoeheText);
    }
}
