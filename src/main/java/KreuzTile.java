package main.java;

import java.awt.Color;
import java.util.Random;

public class KreuzTile extends Tile{

    public KreuzTile(Color farbe, MyPanel panel, int breite){
        super(panel);

        Random random = new Random();


        //Spawn Koordinate wird random generiert
        einzelteile= new Subtile[6];
        int xKoord= random.nextInt(1, breite-1)*50;



        //4 Subtiles werden erstellt und ausgehend von der vorher 
        //generierten KOordinate zu einem 2x2 Quadrat zusammen gebaut
        einzelteile[0]= new Subtile(farbe, xKoord, 0);
        einzelteile[1]= new Subtile(farbe, xKoord, 50);
        einzelteile[2]= new Subtile(farbe, xKoord, 100);
        einzelteile[3]= new Subtile(farbe, xKoord, 150);
        einzelteile[4]= new Subtile(farbe, xKoord -50, 100);
        einzelteile[5]= new Subtile(farbe, xKoord +50, 100);

    }
}