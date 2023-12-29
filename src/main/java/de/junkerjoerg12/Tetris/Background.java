package de.junkerjoerg12.Tetris;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Background extends JFrame {

    MainWindow mainWindow;
    ExitButton extiButton;

    int breite;
    int hoehe;

    JLabel scoreFeld;
    JLabel highscoreFeld;
    MainMenue mainMenue;

    private Spielfeld spielfeld;

    public Background(MainWindow mainWindow, int breite, int hoehe) {

        this.mainWindow = mainWindow;

        JLabel ueberschrift = new JLabel("Tetris by Jakob Engel");
        ueberschrift.setBounds(0, 0, 200, 200);
        this.add(ueberschrift);

        this.setLayout(null);
        this.setUndecorated(true); // kein
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        String spiele[] = { "Tetris" };
        int highscores[] = { 0 };

        mainMenue = new MainMenue(spiele, this, highscores);
        add(mainMenue);

        extiButton = new ExitButton(this);
        this.add(extiButton);
        // extiButton.requestFocus(); // Ohne wird der Knopf nicht angezeigt

        // repaint();
        // setVisible(true);
    }

    public void spielfeldErstellen() {
        spielfeld = new Spielfeld(this, 20, 20);
        add(spielfeld);
    }

    // public void addScoreFeld() {

    // scoreFeld = new JLabel("Score: " + mainWindow.getSpielfeld().getScore());

    // int hoehe = 100;
    // int breite = (mainWindow.getHintergrund().getWidth()) / 2;
    // int x = mainWindow.getSpielfeld().getX() +
    // mainWindow.getSpielfeld().getWidth();
    // int y = mainWindow.getHintergrund().getHeight() / 2 - hoehe;

    // scoreFeld.setBounds(x, y, breite, hoehe);
    // this.add(scoreFeld);
    // }

    // public void addHighscoreFeld() {

    // highscoreFeld = new JLabel("Highscore: " +
    // mainWindow.getSpielfeld().getHighscore());

    // int hoehe = 100;
    // int breite = (mainWindow.getHintergrund().getWidth()) / 2;
    // int x = mainWindow.getSpielfeld().getX() +
    // mainWindow.getSpielfeld().getWidth();
    // int y = mainWindow.getHintergrund().getHeight() / 2 + hoehe;

    // highscoreFeld.setBounds(x, y, breite, hoehe);
    // this.add(highscoreFeld);
    // }

    // public void scoreUpddate() {
    // scoreFeld.setText("Score: " + mainWindow.getSpielfeld().getScore());
    // highscoreFeld.setText("HighScore: " +
    // mainWindow.getSpielfeld().getHighscore());
    // }

    public MainWindow getMainWindow() {
        return mainWindow;
    }

    public MainMenue getMainmenue() {
        return mainMenue;
    }

}
