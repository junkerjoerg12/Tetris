package de.junkerjoerg12.Tetris;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Verloren extends JPanel {

    JLabel textFeld;
    JButton hauptmenueButton;
    JButton neustartButton;
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

        int breiteKnopf = 100;
        int hoeheKnopf = 100;

        // Hauptmenue knopf

        int xHauptmenue = this.getWidth() / 3;
        int yHauptmenue = this.getHeight() - hoeheKnopf;
        hauptmenueButton = new JButton("Hauptmenue");

        hauptmenueButton.setBounds(xHauptmenue, yHauptmenue, breiteKnopf, hoeheKnopf);
        hauptmenueButton.setHorizontalAlignment(SwingConstants.CENTER);
        hauptmenueButton.setVerticalAlignment(SwingConstants.CENTER);
        hauptmenueButton.addActionListener(e -> insHauptmenue());
        hauptmenueButton.setVisible(false);

        this.add(hauptmenueButton);

        // neustart Knopf

        int xNeustart = this.getWidth() / 3 * 2 - breiteKnopf;
        int yNeustart = this.getHeight() - hoeheKnopf;
        neustartButton = new JButton("neustarten");

        neustartButton.setBounds(xNeustart, yNeustart, breiteKnopf, hoeheKnopf);
        neustartButton.setHorizontalAlignment(SwingConstants.CENTER);
        neustartButton.setVerticalAlignment(SwingConstants.CENTER);
        neustartButton.addActionListener(e -> neustarten());
        neustartButton.setVisible(false);

        this.add(neustartButton);
    }

    public void showVerloren() {
        this.setVisible(true);
        textFeld.setVisible(true);
        neustartButton.setVisible(true);
        hauptmenueButton.setVisible(true);
    }

    private void neustarten() {
        hideVerloren();
        hintergrund.getSpielfeld().deletAllKoords();
        hintergrund.getSpielfeld().deletAllTiles();
        hintergrund.getSpielfeld().setScoreZero();
        hintergrund.getSpielfeld().repaint();
        hintergrund.tetrisSpielen();
        hintergrund.scoreUpdate();
    }

    private void hideVerloren() {
        this.setVisible(false);
        textFeld.setVisible(false);
        neustartButton.setVisible(false);
        hauptmenueButton.setVisible(false);
    }

    private void insHauptmenue() {
        hideVerloren();
        hintergrund.getSpielfeld().deletAllKoords();
        hintergrund.getSpielfeld().deletAllTiles();
        hintergrund.getSpielfeld().setScoreZero();
        try {
            DataManger.getDataManger().saveHighscore("normal", hintergrund.getSpielfeld().getHighscore());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        hintergrund.deletSpielfeld();
        hintergrund.getMainmenue().setAllVisible(true);
        hintergrund.requestFocus(); // sonst ist der Exitbutton nicht sichbar
        // Quasi alle UI objekte löschen, nur Highscore speichern und HIntergrund
        // behalten
    }
}
