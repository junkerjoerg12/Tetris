package main.java;

import java.awt.Color;
import java.util.Random;

public class NoNameTile extends Tile{


    Random random = new Random();

    public NoNameTile(Color farbe){
        super();


        //Spawn Koordinate wird random generiert
        einzelteile= new Subtile[4];
        int xKoord= random.nextInt(9)*50;
        System.out.println(xKoord);


        //4 Subtiles werden erstellt und ausgehend von der vorher 
        //generierten KOordinate zu einer 1x4 Linie zusammen gebaut
        einzelteile[0]= new Subtile(farbe, xKoord, 0);
        einzelteile[1]= new Subtile(farbe, xKoord, 50);
        einzelteile[2]= new Subtile(farbe, xKoord+50, 50);
        einzelteile[3]= new Subtile(farbe, xKoord+50, 100);

    }
    
}