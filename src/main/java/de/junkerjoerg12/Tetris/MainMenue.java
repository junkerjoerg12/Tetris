package de.junkerjoerg12.Tetris;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenue extends JPanel {

    private int anzahlSpiele;
    private JButton[] auswahlKnoepfe;
    private JLabel[] highscoreAnnzeigen;
    private Background hintergrund;

    public MainMenue(String[] spielnamen, Background hintergrund, int[] highscores) {

        // setLayout(new LayoutManager(FlowLayout.LEFT,20,20));

        this.anzahlSpiele = spielnamen.length;
        this.hintergrund = hintergrund;

        this.setBounds(0, 0, hintergrund.getWidth(), hintergrund.getHeight());

        auswahlKnoepfe = new JButton[anzahlSpiele];
        highscoreAnnzeigen = new JLabel[anzahlSpiele];

        for (int i = 0; i < auswahlKnoepfe.length; i++) {

            auswahlKnoepfe[i] = new JButton();
            highscoreAnnzeigen[i] = new JLabel();

            JButton knopfSpeicher = auswahlKnoepfe[i]; // Muss tastsächich da sein, kann nicht später ersetzt werden!!

            auswahlKnoepfe[i].setText(spielnamen[i]);
            auswahlKnoepfe[i].addActionListener(e -> knopfgedrueckt(knopfSpeicher));
            highscoreAnnzeigen[i].setText("Highscore: " + highscores[i]);

            auswahlKnoepfe[i].setBounds(700, 500, 500, 500);
            highscoreAnnzeigen[i].setBounds(300, 0, 200, 200);

            this.add(auswahlKnoepfe[i]);
            this.add(highscoreAnnzeigen[i]);

        }
        hintergrund.add(this);
        setAllVisible(true);

    }

    private void knopfgedrueckt(JButton knopf) {
        // muss noch tatsächlich ausgearbeitet werden
        setAllVisible(false);
        hintergrund.spielfeldErstellen();
        hintergrund.tetrisSpielen();
    }

    public void setAllVisible(boolean visible) {
        for (int i = 0; i < auswahlKnoepfe.length; i++) {
            auswahlKnoepfe[i].setVisible(visible);
            highscoreAnnzeigen[i].setVisible(visible);
        }
        this.setVisible(visible);
    }

}
