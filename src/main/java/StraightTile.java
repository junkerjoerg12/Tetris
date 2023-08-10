package main.java;

import java.awt.Color;
import java.util.Random;

public class StraightTile extends Tile{


    Random random = new Random();

    public StraightTile(Color farbe, MyPanel panel){
        super(panel);

        //Spawn Koordinate wird random generiert
        einzelteile= new Subtile[4];
        int xKoord= random.nextInt(9)*50;
        


        //4 Subtiles werden erstellt und ausgehend von der vorher 
        //generierten KOordinate zu einer 1x4 Linie zusammen gebaut
        einzelteile[0]= new Subtile(farbe, xKoord, 0);
        einzelteile[1]= new Subtile(farbe, xKoord, 50);
        einzelteile[2]= new Subtile(farbe, xKoord, 100);
        einzelteile[3]= new Subtile(farbe, xKoord, 150);

    }
    
}
