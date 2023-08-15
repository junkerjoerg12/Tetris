package main.java;

import java.awt.Color;
import java.util.Random;

public class SquareTile extends Tile{
    

    public SquareTile(Color farbe, MyPanel panel, int breite){
        super(panel);

        Random random = new Random();


        //Spawn Koordinate wird random generiert
        einzelteile= new Subtile[4];
        int xKoord= random.nextInt(breite- 1)*50;
        


        //4 Subtiles werden erstellt und ausgehend von der vorher 
        //generierten KOordinate zu einem 2x2 Quadrat zusammen gebaut
        einzelteile[0]= new Subtile(farbe, xKoord, 0);
        einzelteile[1]= new Subtile(farbe, xKoord+50, 0);
        einzelteile[2]= new Subtile(farbe, xKoord, 50);
        einzelteile[3]= new Subtile(farbe, xKoord+50, 50);
    
        
    }
  
}
