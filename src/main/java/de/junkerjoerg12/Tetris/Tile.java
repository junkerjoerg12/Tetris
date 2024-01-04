package de.junkerjoerg12.Tetris;

import java.awt.Color;
import java.util.Random;

public class Tile {
    Subtile[] einzelteile;

    // Koordinaten des Drehpunkts
    int xMitte;
    int yMitte;

    int breite;
    int hoehe;

    Spielfeld spielfeld;

    Random random = new Random();

    ZeitMesser timer;
    Thread thread1;

    private final int timerZeit = 1000;

    public Tile(Spielfeld spielfeld, int x) {
        this.spielfeld = spielfeld;
        breite = spielfeld.getBreite();
        hoehe = spielfeld.getHoehe();

        // x = 5;

        if (x == 0) {
            kreuzAdden();

        } else if (x == 1) {
            dreieckAdden();

        } else if (x == 2) {
            noNameAdden();

        } else if (x == 3) {
            squareAdden();

        } else if (x == 4) {
            linieAdden();

        } else if (x == 5) {
            LTileAdden();

        }

        if (timer == null) {
            timerErstellen(timerZeit);
        }

    }

    public void timerErstellen(int zeit) {
        if (timer == null) {
            this.timer = new ZeitMesser(this, zeit);
            thread1 = new Thread(timer);
            thread1.start();
        }
    }

    public void timerStarten() {
        thread1.start();
    }

    public void kreuzAdden() {

        Color farbe = Color.GREEN;

        // Spawn Koordinate wird random generiert
        einzelteile = new Subtile[6];
        int xKoord = random.nextInt(breite - 2) * 50;

        einzelteile[0] = new Subtile(farbe, xKoord + 50, 0);
        einzelteile[1] = new Subtile(farbe, xKoord + 50, 50);
        einzelteile[2] = new Subtile(farbe, xKoord + 50, 100);
        einzelteile[3] = new Subtile(farbe, xKoord + 50, 150);
        einzelteile[4] = new Subtile(farbe, xKoord, 100);
        einzelteile[5] = new Subtile(farbe, xKoord + 100, 100);

        addTile();
        drehpunkErrechnen();
        zugBeendet();
    }

    public void dreieckAdden() {

        Color farbe = Color.BLUE;

        // Spawn Koordinate wird random generiert
        einzelteile = new Subtile[3];
        int xKoord = random.nextInt(breite - 1) * 50;

        einzelteile[0] = new Subtile(farbe, xKoord, 0);
        einzelteile[1] = new Subtile(farbe, xKoord, 50);
        einzelteile[2] = new Subtile(farbe, xKoord + 50, 50);

        addTile();
        drehpunkErrechnen();
        zugBeendet();
    }

    public void noNameAdden() {

        Color farbe = Color.YELLOW;

        // Spawn Koordinate wird random generiert
        einzelteile = new Subtile[4];
        int xKoord = random.nextInt(breite) * 50;

        einzelteile[0] = new Subtile(farbe, xKoord, 0);
        einzelteile[1] = new Subtile(farbe, xKoord, 50);
        einzelteile[2] = new Subtile(farbe, xKoord + 50, 50);
        einzelteile[3] = new Subtile(farbe, xKoord + 50, 100);

        addTile();
        drehpunkErrechnen();
        zugBeendet();
    }

    public void squareAdden() {

        Color farbe = Color.MAGENTA;

        // Spawn Koordinate wird random generiert
        einzelteile = new Subtile[4];
        int xKoord = random.nextInt(breite - 1) * 50;

        einzelteile[0] = new Subtile(farbe, xKoord, 0);
        einzelteile[1] = new Subtile(farbe, xKoord + 50, 0);
        einzelteile[2] = new Subtile(farbe, xKoord, 50);
        einzelteile[3] = new Subtile(farbe, xKoord + 50, 50);

        addTile();
        drehpunkErrechnen();
        zugBeendet();
    }

    public void linieAdden() {

        Color farbe = Color.ORANGE;

        // Spawn Koordinate wird random generiert
        einzelteile = new Subtile[4];
        int xKoord = random.nextInt(breite) * 50;

        einzelteile[0] = new Subtile(farbe, xKoord, 0);
        einzelteile[1] = new Subtile(farbe, xKoord, 50);
        einzelteile[2] = new Subtile(farbe, xKoord, 100);
        einzelteile[3] = new Subtile(farbe, xKoord, 150);

        addTile();
        drehpunkErrechnen();
        zugBeendet();
    }

    public void LTileAdden() {
        Color farbe = Color.RED;

        // Spawn Koordinate wird random generiert
        einzelteile = new Subtile[4];
        int xKoord = random.nextInt(breite - 1) * 50;

        einzelteile[0] = new Subtile(farbe, xKoord, 0);
        einzelteile[1] = new Subtile(farbe, xKoord, 50);
        einzelteile[2] = new Subtile(farbe, xKoord, 100);
        einzelteile[3] = new Subtile(farbe, xKoord + 50, 100);

        addTile();
        drehpunkErrechnen();
        zugBeendet();
    }

    // fügt die Subsquares zu panel hinzu
    public void addTile() {
        for (int i = 0; i < einzelteile.length; i++) {
            spielfeld.add(einzelteile[i]);
        }
    }

    // Position des Tiles ändern
    public void changeLocation(int x, int y) {
        if (outOfBounds(x, y) == true) {

            for (int i = 0; i < einzelteile.length; i++) {
                einzelteile[i].setLocation(einzelteile[i].getX() + x, einzelteile[i].getY() + y);
            }

            xMitte = xMitte + x;
            yMitte = yMitte + y;
        }

        zugBeendet();

        if (y == 50) { // wenn nach unten bewegt wurde wird der Timer neugestartet
            try {
                timer.zeitStoppen(timerZeit);
            } catch (IllegalThreadStateException e) {
            } catch (NullPointerException e) {
            }
        }
    }

    // Rechnet das Feld aus, um das sich das Tile dehen soll
    public void drehpunkErrechnen() {
        int xMax = einzelteile[0].getX();
        int xMin = einzelteile[0].getX();
        int yMax = einzelteile[0].getY();
        int yMin = einzelteile[0].getY();

        // Höchste und niedrigste X und Y Koordinate der Figur wird herausgefunden
        for (int i = 0; i < einzelteile.length; i++) {
            if (einzelteile[i].getX() > xMax) {
                xMax = einzelteile[i].getX();
            } else if (einzelteile[i].getX() < xMin) {
                xMin = einzelteile[i].getX();
            }
            if (einzelteile[i].getY() > yMax) {
                yMax = einzelteile[i].getY();
            } else if (einzelteile[i].getY() < yMin) {
                yMin = einzelteile[i].getY();
            }
        }

        // Drehpunkt wird berechnet:
        // Mittelpunt der Figur wird errechnet, wenn dieser kein Subtile ist,
        // wird das Subtile mit den nächst kleineren werten als Drehpunt festgelegt

        xMitte = (xMax + xMin) / 2;

        if (xMitte % 50 != 0) {
            xMitte = xMitte - 25;
        }
        yMitte = (yMax + yMin) / 2;
        if (yMitte % 50 != 0) {
            yMitte = yMitte - 25;
        }
        for (int i = 0; i < einzelteile.length; i++) {
            if (einzelteile[i].getX() == xMitte && einzelteile[i].getY() == yMitte) {
                einzelteile[i].setDrehpunkt(true);
            }
        }
    }

    // testet, ob nach dem Bewegen des Teils eines der Subtiles außerhalb des
    // Spielfelds ist
    public boolean outOfBounds(int x, int y) {
        boolean valid = true;

        for (int i = 0; i < einzelteile.length; i++) {
            if (einzelteile[i].getY() + y > hoehe * 50 - 50 || einzelteile[i].getX() + x < 0
                    || einzelteile[i].getX() + x > breite * 50 - 50) {
                valid = false;
            }
        }
        return valid;
    }

    public void mitUhrDrehen() {

        boolean valid = true;

        // Vergibt Koordinaten Relativ zum Drehpunkt
        for (int i = 0; i < einzelteile.length; i++) {
            einzelteile[i].setXRel(einzelteile[i].getX() - xMitte);
            einzelteile[i].setYRel(einzelteile[i].getY() - yMitte);
        }

        for (int i = 0; i < einzelteile.length; i++) {

            // 1: X und Y Koordinaten Relativ zum Drehpunkt tauschen
            int zwischenspeicher;
            zwischenspeicher = einzelteile[i].getXRel();
            einzelteile[i].setXRel(einzelteile[i].getYRel());
            einzelteile[i].setYRel(zwischenspeicher);

            // 2: Vorzeichen von X umkehren
            einzelteile[i].setXRel(einzelteile[i].getXRel() * -1);

            // 3: Überprüfen, ob keines der Felder außerhalb des Spielfelds ist
            if (!(einzelteile[i].getXRel() + xMitte < (breite * 50) && einzelteile[i].getXRel() + xMitte >= 0
                    && einzelteile[i].getYRel() + yMitte >= 0 && einzelteile[i].getYRel() + yMitte < (hoehe * 50)
                    && valid == true)) {
                valid = false;
            }
            // 4: überprüfen, ob keines der felder ein anderes Tile überlapt
            if ((spielfeld.getKoords()
                    .contains((einzelteile[i].getXRel() + xMitte) + " " + (einzelteile[i].getYRel() + yMitte)))) {
                valid = false;
            }
        }

        // Position der Felder aus dem spielfeld ändern, wenn keines der Felder
        // außerhalb des spielfelds ist
        if (valid == true) {
            for (int i = 0; i < einzelteile.length; i++) {
                einzelteile[i].setLocation(einzelteile[i].getXRel() + xMitte, einzelteile[i].getYRel() + yMitte);
            }
        }
    }

    public void zugBeendet() {

        boolean beendet = false;

        // der Zug ist beedet, wenn ein teil auf einem anderen aufliegt
        if (kollisionUnten() == true) {
            beendet = true;
        }

        for (int i = 0; i < einzelteile.length; i++) {

            if (einzelteile[i].getY() == hoehe - 50) {
                beendet = true;

            }
        }
        if (beendet == true) {

            // es wird geprüft, ob ein Subtile oben anstößt
            if (verlorenPruefen() == true) {

                spielfeld.verloren.showVerloren();
                System.out.println("Sie haben verloren!!");
                System.out.println("Ihr Highscore : " + spielfeld.getScore());

                // Subtiles werden aufs panel gespeicehrt
                umspeichern();

                // Subtiles werden aus this gelöscht
                deletSubtiles();

                // löscht hoffentlich den Timer und führt so zu keinem crash
                deleteTimer();

                // this wird gelöscht
                spielfeld.deleteTile(true);
            } else {
                // Subtiles werden aufs panel gespeicehrt
                umspeichern();

                // Subtiles werden aus this gelöscht
                deletSubtiles();

                // löscht hoffentlich den Timer und führt so zu keinem crash
                deleteTimer();

                // this wird gelöscht
                spielfeld.deleteTile(false);
            }
            spielfeld.reihePruefen();
        }
    }

    // löscht den timer
    public void deleteTimer() {
        if (timer != null) {
            timer = null;
            thread1 = null;
        }
    }

    public boolean kollisionUnten() {
        // Kollision nach unten wird geprüft
        for (int i = 0; i < einzelteile.length; i++) {
            if (spielfeld.getKoords().contains((einzelteile[i].getX()) + " " + (einzelteile[i].getY() + 50))) {
                return true;
            }
        }
        return false;
    }

    // Überprüft, ob das Teil ein anderes nach recht berührt
    public boolean kollisionRechts() {
        for (int i = 0; i < einzelteile.length; i++) {
            if (spielfeld.getKoords().contains((einzelteile[i].getX() + 50) + " " + (einzelteile[i].getY()))) {
                return true;
            }
        }
        return false;
    }

    // Überprüft, ob das Teil ein anderes nach links berührt
    public boolean kollisionLinks() {
        for (int i = 0; i < einzelteile.length; i++) {
            if (spielfeld.getKoords().contains((einzelteile[i].getX() - 50) + " " + (einzelteile[i].getY()))) {
                return true;
            }
        }
        return false;
    }

    // Speichert die subtiles im Panel
    public void umspeichern() {
        for (int i = 0; i < einzelteile.length; i++) {
            spielfeld.speichern(einzelteile[i]);
        }
    }

    // ist glaube ich unnötig
    public void deletSubtiles() {
        for (int i = 0; i < einzelteile.length; i++) {
            einzelteile[i] = null;
        }
    }

    public boolean verlorenPruefen() {
        for (int i = 0; i < einzelteile.length; i++) {
            if (einzelteile[i].getY() == 0) {
                return true;
            }
        }
        return false;
    }

    public Thread getTimerThread() {
        return thread1;
    }
}
