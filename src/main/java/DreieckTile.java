package main.java;

import java.util.Random;
import java.awt.Color;

public class DreieckTile extends Tile{
    public DreieckTile(Color farbe){
        super();

        Random random = new Random();


        //Spawn Koordinate wird random generiert
        einzelteile= new Subtile[3];
        int xKoord= random.nextInt(9)*50;
        


        //4 Subtiles werden erstellt und ausgehend von der vorher 
        //generierten KOordinate zu einem 2x2 Quadrat zusammen gebaut
        einzelteile[0]= new Subtile(farbe, xKoord, 0);
        einzelteile[1]= new Subtile(farbe, xKoord, 50);
        einzelteile[2]= new Subtile(farbe, xKoord+50, 50);

    }
    
}
