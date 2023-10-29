package main.java;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Spielfeld extends JPanel {

    int anzahlSpalten;
    int anzahlZeilen;
    int score;
    int highscore;
    int breite;
    int hoehe;

    Verloren verloren;

    ArrayList<String> speicherKoords = new ArrayList<String>();
    ArrayList<Subtile> speicherTiles = new ArrayList<Subtile>();

    Background hintergrund;

    public Spielfeld(Background hintergrund, int breite, int hoehe) {

        anzahlSpalten = breite;
        anzahlZeilen = hoehe;

        this.breite = anzahlSpalten * 50;
        this.hoehe = anzahlZeilen * 50;

        this.hintergrund = hintergrund;

        // kein Layout manager d.h. alle Koordinaten müssen absolut eingetragen werden
        this.setLayout(null);

        this.setPreferredSize(new Dimension(this.breite + 1, this.hoehe + 1));

        verloren = new Verloren(hintergrund, this.breite, this.hoehe);
        this.add(verloren);

        // Das Gitter im Hintergrund wird gezeichent
        for (int i = 0; i < anzahlSpalten + 1; i++) {
            Line x = new Line(true, i * 50, anzahlZeilen * 50);
            this.add(x);
        }
        for (int i = 0; i < anzahlZeilen + 1; i++) {
            Line x = new Line(false, i * 50, anzahlSpalten * 50);
            this.add(x);
        }

        this.setBounds((hintergrund.getWidth() - this.breite) / 2, (hintergrund.getHeight() - this.hoehe) / 2,
                this.breite + 1, this.hoehe + 1);

    }

    public void speichern(Subtile subtile) {
        // speichert x und y als String im Speicher
        // und das Subtile in einem anderen Array, aber auf der selben position wie die
        // die dazugehörige koordinate
        if (!(speicherKoords.contains(subtile.getX() + " " + subtile.getY())))
            ;
        speicherKoords.add(subtile.getX() + " " + subtile.getY());
        if (!(speicherTiles.contains(subtile))) {
            speicherTiles.add(subtile);
        }
    }

    public void loeschen(int x, int y) {
        // löscht den String, der x und y enthält aus dem Speicher
        speicherKoords.remove(x + " " + y);
    }

    public boolean vergleichen(int x, int y) {
        if (speicherKoords.contains(x + " " + y)) {
            return true;
        }
        return false;
    }

    public int getIndex(int x, int y) {
        // gibt den index zurück, auf dem das Subtile und die zugehörige koordinate
        // gespeichert sind
        int index;

        index = speicherKoords.indexOf(x + " " + y);
        return index;

    }

    public void reihePruefen() {
        // Überprüft jede reihe, ob sie voll ist

        boolean reiheVoll = true;

        // jede Zeile wird geprüft

        for (int i = anzahlZeilen; i > 0; i--) {
            reiheVoll = true;

            // und jede Spalte in der betreffenden Reihe
            for (int j = 0; j < anzahlSpalten; j++) {
                if (vergleichen(j * 50, i * 50) == true && reiheVoll == true) {

                } else {
                    reiheVoll = false;
                }

            }

            // Wenn ja wird die Entsprechende Reihe gelöscht
            if (reiheVoll == true) {
                reiheEntfernen(i * 50);
                aufrutschen(i * 50);

                // weil aufgerutscht wurde muss die gelöschte zeile erneut überprüft werden
                i++;

                score += breite / 50;

                hintergrund.scoreUpddate();

            }
        }
    }

    public void reiheEntfernen(int y) {
        // entfernt die Reihe auf der Übergebenen Y Koordinate
        int index;

        for (int j = 0; j < anzahlSpalten; j++) {
            // setz jedes Subtile der Reihe unsichtbar und löscht dannach sowohl sie
            // koordinate als auch das Subtile
            index = getIndex(j * 50, y);
            speicherKoords.remove(index);
            speicherTiles.get(index).setVisible(false);
            speicherTiles.remove(index);
        }
    }

    public void aufrutschen(int y) {
        // Versciebt Subtiles nach unten, wenn eine Reihe gelöscht wurde und ändert die
        // Koordinaten im String

        for (int i = 0; i < speicherTiles.size(); i++) {
            if (speicherTiles.get(i).getY() < y) {
                speicherTiles.get(i).setLocation(speicherTiles.get(i).getX(), speicherTiles.get(i).getY() + 50);
                speicherKoords.set(i, speicherTiles.get(i).getX() + " " + speicherTiles.get(i).getY());
            }
        }
    }

    public void deleteTile(boolean verloren) {
        hintergrund.getMainWindow().deleteTile(verloren);
    }

    public ArrayList<String> getKoords() {
        return speicherKoords;
    }

    public int getBreite() {
        return anzahlSpalten;
    }

    public int getHoehe() {
        return hoehe;
    }

    public int getScore() {
        return score;
    }

    public int getHighscore() {

        if (score > highscore) {
            highscore = score;
        }
        return highscore;
    }

    public Background getHIntergrund() {
        return hintergrund;
    }

    public void setVerlorenVisible() {
        verloren.setVisible(true);
    }

    public void setScoreZero() {
        score = 0;
    }

    public void deletAllTiles() {
        int laenge = speicherTiles.size();

        for (int i = 0; i < laenge; i++) {
            speicherTiles.get(0).setVisible(false);
            speicherTiles.remove(0);
        }
    }

    public void deletAllKoords() {
        int laenge = speicherKoords.size();

        for (int i = 0; i < laenge; i++) {
            speicherKoords.remove(0);
        }
    }
}