package de.junkerjoerg12.Tetris;

import java.io.IOException;

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

        // for (int i = 0; i < auswahlKnoepfe.length; i++) {
        int i = 0;
        try {
            highscores[i] = DataManger.getDataManger().getGeneralHighscore();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // Liest den Highscore aus der Datei

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
        try {
            highscoreAnnzeigen[0].setText("Highscore: " + DataManger.getDataManger().getGeneralHighscore());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.setVisible(visible);
    }

}
