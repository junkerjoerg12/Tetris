package de.junkerjoerg12.Tetris;

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

    // public void spielfeldErstellen() {
    // spielfeld = new Spielfeld(hintergrund, breite, hoehe);
    // hintergrund.add(spielfeld);
    // // hintergrund.addScoreFeld();
    // // hintergrund.addHighscoreFeld();
    // }

    public void tetrisSpielen() {
        spielfeld.spawnTile();
    }

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
