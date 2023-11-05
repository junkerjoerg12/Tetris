package main.java;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Background extends JPanel {

    MainWindow mainWindow;
    ExitButton extiButton;

    int breite;
    int hoehe;

    JLabel scoreFeld;
    JLabel highscoreFeld;
    MainMenue mainMenue;

    public Background(MainWindow mainWindow, int breite, int hoehe) {

        this.mainWindow = mainWindow;

        JLabel ueberschrift = new JLabel("Tetris by Jakob Engel");
        ueberschrift.setBounds(0, 0, 200, 200);
        this.add(ueberschrift);

        this.setSize(1920, 1080);
        this.setVisible(true);
        this.setLayout(null);

        extiButton = new ExitButton(this);

        this.add(extiButton);

        String spiele[] = { "Tetris" };
        int highscores[] = { 0 };

        mainMenue = new MainMenue(spiele, this, highscores);

    }

    public void addScoreFeld() {

        scoreFeld = new JLabel("Score: " + mainWindow.getSpielfeld().getScore());

        int hoehe = 100;
        int breite = (mainWindow.getHintergrund().getWidth()) / 2;
        int x = mainWindow.getSpielfeld().getX() + mainWindow.getSpielfeld().getWidth();
        int y = mainWindow.getHintergrund().getHeight() / 2 - hoehe;

        scoreFeld.setBounds(x, y, breite, hoehe);
        this.add(scoreFeld);
    }

    public void addHighscoreFeld() {

        highscoreFeld = new JLabel("Highscore: " + mainWindow.getSpielfeld().getHighscore());

        int hoehe = 100;
        int breite = (mainWindow.getHintergrund().getWidth()) / 2;
        int x = mainWindow.getSpielfeld().getX() + mainWindow.getSpielfeld().getWidth();
        int y = mainWindow.getHintergrund().getHeight() / 2 + hoehe;

        highscoreFeld.setBounds(x, y, breite, hoehe);
        this.add(highscoreFeld);
    }

    public void scoreUpddate() {
        scoreFeld.setText("Score: " + mainWindow.getSpielfeld().getScore());
        highscoreFeld.setText("HighScore: " + mainWindow.getSpielfeld().getHighscore());
    }

    public MainWindow getMainWindow() {
        return mainWindow;
    }

}
