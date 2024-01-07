package de.junkerjoerg12.Tetris;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Background extends JFrame {

    ExitButton extiButton;

    int breite;
    int hoehe;

    JLabel scoreFeld;
    JLabel highscoreFeld;
    MainMenue mainMenue;

    private Spielfeld spielfeld;

    public Background(int breite, int hoehe) {

        this.setLayout(null);
        this.setUndecorated(true); // kein
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        JLabel ueberschrift = new JLabel("Tetris by Jakob Engel");
        ueberschrift.setBounds(0, 0, 200, 200);
        this.add(ueberschrift);

        String spiele[] = { "Tetris" };
        int highscores[] = { 0 };

        DataManger.getDataManger().checkFolders();// Ordner zum speichern von daten wird auf vollständigkeit überprüft
                                                  // und ggf. vervollständigt
        mainMenue = new MainMenue(spiele, this, highscores);
        add(mainMenue);

        extiButton = new ExitButton(this);
        this.add(extiButton);
        extiButton.requestFocus(); // Ohne wird der Knopf nicht angezeigt

    }

    public void spielfeldErstellen() {
        this.spielfeld = new Spielfeld(this, 20, 20);
        add(this.spielfeld);
        if (scoreFeld == null) {
            addscorefeld();
        }
        if (highscoreFeld == null) {
            addHighscoreFeld();
        }
        scoreUpdate();
    }

    public void tetrisSpielen() {
        this.spielfeld.spawnTile();
    }

    public void addscorefeld() {

        scoreFeld = new JLabel("Score: " + spielfeld.getScore());

        int hoehe = 100;
        int breite = getWidth() / 2;
        int x = spielfeld.getX() + spielfeld.getWidth();
        int y = getHeight() / 2 - hoehe;

        scoreFeld.setBounds(x, y, breite, hoehe);
        this.add(scoreFeld);
    }

    public void addHighscoreFeld() {

        highscoreFeld = new JLabel("Highscore: " + spielfeld.getHighscore());

        int hoehe = 100;
        int breite = getWidth() / 2;
        int x = spielfeld.getX() + spielfeld.getWidth();
        int y = getHeight() / 2 + hoehe;

        highscoreFeld.setBounds(x, y, breite, hoehe);
        this.add(highscoreFeld);
    }

    // muss noch aufgerufen werden
    public void scoreUpdate() {
        scoreFeld.setText("Score: " + spielfeld.getScore());
        highscoreFeld.setText("HighScore: " + spielfeld.getHighscore());
    }

    public Spielfeld getSpielfeld() {
        return spielfeld;
    }

    public MainMenue getMainmenue() {
        extiButton.setVisible(true);
        return mainMenue;
    }

    public void deletSpielfeld() {
        spielfeld.deletAllTiles();
        spielfeld.deletAllKoords();
        this.spielfeld = null;
    }
}
