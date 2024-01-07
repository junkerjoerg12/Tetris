package de.junkerjoerg12.Tetris;

import java.awt.Color;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ExitButton extends JButton {

    int breite = 50;
    int hoehe = 50;
    private Background hintergrund;

    public ExitButton(Background hintergrund) {
        this.hintergrund = hintergrund;

        ImageIcon icon = new ImageIcon("src\\main\\resources\\ExitSymbol.png");

        this.setBounds(0, hintergrund.getHeight() - hoehe, breite, hoehe);
        this.addActionListener(e -> exit());
        this.setIcon(icon);
        this.setBackground(Color.WHITE);
    }

    private void exit() {
        try {
            DataManger.getDataManger().saveHighscore("normal", hintergrund.getSpielfeld().getHighscore());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NullPointerException e) {// NullPointerExeption, wenn der Knopf gedrückt wird, solage man sich im HM
                                          // befindet, weil spielfeld gelöscht/ noch nicht initialiseirt ist
            System.exit(0);
        }
        System.exit(0);
    }
}
