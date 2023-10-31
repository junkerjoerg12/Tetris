package main.java;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Verloren extends JPanel {

    JLabel textFeld;
    JButton hauptmenue;
    JButton neustart;
    Background hintergrund;

    public Verloren(Background hintergrund, int spielfeldbreite, int spielfeldhoehe) {

        this.hintergrund = hintergrund;

        int breiteText = spielfeldbreite;
        int hoeheText = (int) Math.round(spielfeldbreite / 5.1111111111);
        int xText = (spielfeldbreite / 2 - breiteText / 2);
        int yText = (spielfeldhoehe / 2 - hoeheText / 2);
        int fontsize = (int) Math.round(hoeheText * 1.3);

        this.setOpaque(false);
        this.setVisible(false);
        this.setBackground(Color.BLACK);
        this.setBounds(0, 0, spielfeldbreite, spielfeldhoehe);

        // Schrift anzeigen:
        textFeld = new JLabel();
        textFeld.setBounds(xText, yText, breiteText, hoeheText);
        textFeld.setFont(new Font("Arial", Font.PLAIN, fontsize));
        textFeld.setText("Verloren");
        textFeld.setHorizontalAlignment(SwingConstants.CENTER);
        textFeld.setVerticalAlignment(SwingConstants.CENTER);
        textFeld.setForeground(Color.RED);
        this.setVisible(false);
        this.add(textFeld);

        // Hauptmenue knopf

        int breiteKnopf = 100;
        int hoeheKnopf = 100;

        int xHauptmenue = this.getWidth() / 3;
        int yHauptmenue = this.getHeight() - hoeheKnopf;
        hauptmenue = new JButton("Hauptmenue");

        hauptmenue.setBounds(xHauptmenue, yHauptmenue, breiteKnopf, hoeheKnopf);
        hauptmenue.setHorizontalAlignment(SwingConstants.CENTER);
        hauptmenue.setVerticalAlignment(SwingConstants.CENTER);
        hauptmenue.addActionListener(e -> insHauptmenue());
        hauptmenue.setVisible(false);

        this.add(hauptmenue);

        // neustart Knopf

        int xNeustart = this.getWidth() / 3 * 2 - breiteKnopf;
        int yNeustart = this.getHeight() - hoeheKnopf;
        neustart = new JButton("neustarten");

        neustart.setBounds(xNeustart, yNeustart, breiteKnopf, hoeheKnopf);
        neustart.setHorizontalAlignment(SwingConstants.CENTER);
        neustart.setVerticalAlignment(SwingConstants.CENTER);
        neustart.addActionListener(e -> neustarten());
        neustart.setVisible(false);

        this.add(neustart);
    }

    public void showVerloren() {
        this.setVisible(true);
        textFeld.setVisible(true);
        neustart.setVisible(true);
        hauptmenue.setVisible(true);
    }

    private void neustarten() {
        System.out.println("Wir wollen neustarten und müssen dafür jetzt eine methode schreiben");
        hideVerloren();
        hintergrund.getMainWindow().getSpielfeld().deletAllKoords();
        hintergrund.getMainWindow().getSpielfeld().deletAllTiles();
        hintergrund.getMainWindow().getSpielfeld().setScoreZero();
        hintergrund.getMainWindow().getSpielfeld().repaint();
        hintergrund.getMainWindow().spielen();
        hintergrund.scoreUpddate();
    }

    private void hideVerloren() {
        this.setVisible(false);
        textFeld.setVisible(false);
        neustart.setVisible(false);
        hauptmenue.setVisible(false);
    }

    private void insHauptmenue() {
        System.out.println("wir wollen ins Hauptmenue");
        // Quasi alle UI objekte löschen, nur Highscore speichern und HIntergrund
        // behalten
    }
}
