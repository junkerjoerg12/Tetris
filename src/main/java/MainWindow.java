package main.java;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import java.util.Random;

public class MainWindow extends JFrame implements KeyListener {

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
        this.setUndecorated(true);
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

        this.addKeyListener(this);

    }

    public void tetrisSpielen() {

        // wieder auf 6 zurückändern
        x = random.nextInt(6);

        // tests
        // x=4;
        tile = new Tile(spielfeld, x);

        repaint();

        requestFocus();

    }

    // User Input

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) { // Pfeil nacch unten == 40, nach links==37, nach rechts == 39

        try {
            switch (e.getKeyCode()) {
                case 40:
                    tile.getTimerThread().interrupt();
                    tile.deleteTimer();
                    tile.changeLocationDown(0, 50);

                    if (tile.getTimerThread() == null) {
                        tile.timerErstellen(timerZeit);
                    }

                    spielfeld.repaint();

                    break;
                case (37):

                    if (tile.kollisionLinks() == false) {
                        tile.changeLocation(-50, 0);
                    }

                    spielfeld.repaint();

                    break;
                case (39):

                    if (tile.kollisionRechts() == false) {
                        tile.changeLocation(50, 0);
                    }
                    spielfeld.repaint();

                    break;
                case (38):
                    tile.mitUhrDrehen();

                    spielfeld.repaint();

                    break;
                default:
                    break;
            }
        } catch (NullPointerException exception) {
            System.out.println("Du hast schon längst verloren");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
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
