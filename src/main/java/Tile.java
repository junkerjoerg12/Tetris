package main.java;

import java.awt.Color;
import java.awt.event.*;

 abstract class Tile{
    Subtile[]einzelteile;



    public Tile(){
        

    }





    //fügt die Subsquares zu panel hinzu
    public void addTile(MyPanel panel){
        for(int i=0; i<einzelteile.length; i++){
            panel.add(einzelteile[i]);
        }

    }


   

    
}
