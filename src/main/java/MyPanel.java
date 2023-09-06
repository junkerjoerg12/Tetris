package main.java;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyPanel extends JPanel {

    int anzahlSpalten;
    int anzahlZeilen;
    int score;
    int breite;
    int hoehe;

    ArrayList<String> speicherKoords = new ArrayList<String>();
    ArrayList<Subtile> speicherTiles = new ArrayList<Subtile>();

    LTile lTile;

    Spielfeld spielfeld;

    public MyPanel(Spielfeld spielfeld, int breite, int hoehe) {

        this.breite = breite;
        this.hoehe = hoehe;

        anzahlSpalten = breite;
        anzahlZeilen = hoehe;

        this.spielfeld = spielfeld;

        // kein Layout manager d.h. alee Koordinaten müssen absolut eingetragen werden
        this.setLayout(null);

        // Das Panel ist 500x 500 Pixel groß
        this.setPreferredSize(new Dimension(anzahlSpalten * 50, anzahlZeilen * 50));

        // Das Gitter im Hintergrund wird gezeichent
        for (int i = 1; i < anzahlSpalten; i++) {
            Line x = new Line(true, i * 50, anzahlZeilen * 50);
            this.add(x);
        }
        for (int i = 1; i < anzahlZeilen; i++) {
            Line x = new Line(false, i * 50, anzahlSpalten * 50);
            this.add(x);
        }


        
        ZeitMesser timer= new ZeitMesser();

        Thread thread1= new Thread(timer);

        thread1.start();

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {

        }


        timer.haloosSagen();



    }

    // speichert x und y als String im Speicher
    // und das Subtile in einem anderen Array, aber auf der selben position wie die
    // die dazugehörige koordinate
    public void speichern(Subtile subtile) {
        if (!(speicherKoords.contains(subtile.getX() + " " + subtile.getY())))
            ;
        speicherKoords.add(subtile.getX() + " " + subtile.getY());
        if (!(speicherTiles.contains(subtile))) {
            speicherTiles.add(subtile);
        }
    }

    // löscht den String, der x und y enthält aus dem Speicher
    public void loeschen(int x, int y) {
        speicherKoords.remove(x + " " + y);
    }

    // gibt true zurück, wenn
    public boolean vergleichen(int x, int y) {
        if (speicherKoords.contains(x + " " + y)) {
            return true;
        }
        return false;
    }

    // gibt den index zurück, auf dem das Subtile und die zugehörige koordinate
    // gespeichert sind
    public int getIndex(int x, int y) {
        int index;

        index = speicherKoords.indexOf(x + " " + y);
        return index;

    }

    // Überprüft jede reihe, ob sie voll ist
    public void reihePruefen() {

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
            
            System.out.println("Reihe "+ i+" voll: "+ reiheVoll);

            // Wenn ja wird die Entsprechende Reihe gelöscht
            if (reiheVoll == true) {
                reiheEntfernen(i * 50);
                aufrutschen(i * 50);

                //weil aufgerutscht wurde muss die gelöschte zeile erneut überprüft werden 
                i++;

                score += breite;
                //System.out.println("Score: " + score);
            }
        }

    }

    // entfernt die Reihe auf der Übergebenen Y Koordinate
    public void reiheEntfernen(int y) {
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

    // Versciebt Subtiles nach unten, wenn eine Reihe gelöscht wurde und ändert die
    // Koordinaten im String
    public void aufrutschen(int y) {

        for (int i = 0; i < speicherTiles.size(); i++) {

            if (speicherTiles.get(i).getY() < y) {
                speicherTiles.get(i).setLocation(speicherTiles.get(i).getX(), speicherTiles.get(i).getY() + 50);
                speicherKoords.set(i, speicherTiles.get(i).getX() + " " + speicherTiles.get(i).getY());
            }
        }
    }

    public void setTile(LTile tile) {
        lTile = tile;
    }

    public void deleteTile(boolean verloren) {

        lTile = null;
        spielfeld.deleteTile(verloren);
    }

    public ArrayList<String> getKoords() {
        return speicherKoords;
    }

    public int getBreite() {
        return breite;
    }

    public int getHoehe() {
        return hoehe;
    }

    public int getScore(){
        return score;
    }
}