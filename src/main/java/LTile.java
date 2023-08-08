package main.java;

import java.util.Random;
import java.awt.Color;

public class LTile extends Tile{

    public LTile(Color farbe, MyPanel panel){
        super(panel);

        Random random = new Random();


        //Spawn Koordinate wird random generiert
        einzelteile= new Subtile[4];
        int xKoord= random.nextInt(9)*50;
        System.out.println(xKoord);


        //4 Subtiles werden erstellt und ausgehend von der vorher 
        //generierten KOordinate zu einem L zusammen gebaut
        einzelteile[0]= new Subtile(farbe, xKoord, 0);
        einzelteile[1]= new Subtile(farbe, xKoord, 50);
        einzelteile[2]= new Subtile(farbe, xKoord, 100);
        einzelteile[3]= new Subtile(farbe, xKoord+50, 100);
    }



}
