package main.java;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import java.util.Random;

public class MainWindow extends JFrame {

    Random random = new Random();

    private Spielfeld spielfeld;
    private Background hintergrund;

    int x;

    int breite;
    int hoehe;
    Tile tile;

    private final int timerZeit = 1000;

    // Kostruktor
    public MainWindow(int breite, int hoehe) {

        this.breite = breite;
        this.hoehe = hoehe;

        this.setLayout(null);
        this.setUndecorated(true); // kein
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        System.out.println(breite + " " + hoehe);

        hintergrund = new Background(this, breite, hoehe);
        this.add(hintergrund);

    }

    public void spielfeldErstellen() {

        spielfeld = new Spielfeld(hintergrund, breite, hoehe);
        hintergrund.add(spielfeld);

        hintergrund.addScoreFeld();
        hintergrund.addHighscoreFeld();

        // this.addKeyListener(this);

    }

    public void tetrisSpielen() {

        spielfeld.spawnTile();
        System.out.println("ja oder nein...");

        // tile = new Tile(spielfeld, random.nextInt(6)); // erstellt ein neues tile,
        // weches wird vai random entschieden

        // repaint();
        // requestFocus();
        // spielfeld.requestFocus();

    }

    // User Input

    public void deleteTile(boolean verloren) {
        tile = null;
        // darf nur aufgerufen werden, wenn das Spiel noch nicht beendet ist
        if (verloren == false) {
            tetrisSpielen();
        } else {
            System.out.println("hier kommt nichts mehr");
        }
    }

    public Tile getTile() {
        return tile;
    }

    public Background getHintergrund() {
        return hintergrund;
    }

    public Spielfeld getSpielfeld() {
        return spielfeld;
    }

    public void deletSpielfeld() {
        this.spielfeld = null;
    }

}
