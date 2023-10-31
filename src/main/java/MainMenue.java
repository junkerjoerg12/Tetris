package main.java;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenue extends JPanel {

    private int anzahlSpiele;
    private JButton[] auswahlKnoepfe;
    private JLabel[] highscoreAnnzeigen;
    private MainWindow mainWindow;

    public MainMenue(String[] spielnamen, MainWindow mainWindow, int[] highscores) {

        this.anzahlSpiele = spielnamen.length;
        this.mainWindow = mainWindow;

        this.setPreferredSize(new Dimension(mainWindow.getWidth(), mainWindow.getHeight()));
        mainWindow.add(this);

        auswahlKnoepfe = new JButton[anzahlSpiele];
        highscoreAnnzeigen = new JLabel[anzahlSpiele];

        for (int i = 0; i < auswahlKnoepfe.length; i++) {

            JButton knopfSpeicher = auswahlKnoepfe[i];

            auswahlKnoepfe[i].setText(spielnamen[i]);
            auswahlKnoepfe[i].addActionListener(e -> knopfgedrueckt(knopfSpeicher));
            this.add(auswahlKnoepfe[i]);

            highscoreAnnzeigen[i].setText("Highscore: " + highscores[i]);
            this.add(highscoreAnnzeigen[i]);

        }

    }

    private void knopfgedrueckt(JButton knopf) {
        System.out.println("Wir wollen " + knopf.getText() + " spielen");
        // muss noch tatsächlich ausgearbeitet werden

        mainWindow.spielen();
    }

    public void setAllVisible(boolean visible) {

        for (int i = 0; i < auswahlKnoepfe.length; i++) {
            auswahlKnoepfe[i].setVisible(visible);
            highscoreAnnzeigen[i].setVisible(visible);
        }
        this.setVisible(visible);
    }

}
