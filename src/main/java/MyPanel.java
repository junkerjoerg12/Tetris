package main.java;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyPanel extends JPanel{

    int anzahlSpalten=10;
    int anzahlZeilen=20;

    ArrayList<String> speicherKoords= new ArrayList<String>(); 
    ArrayList<Subtile> speicherTiles = new ArrayList<Subtile>();

    LTile lTile;
    
    
    Spielfeld spielfeld;
    

    public MyPanel(Spielfeld spielfeld){

        this.spielfeld= spielfeld;

        //kein Layout manager d.h. alee Koordinaten müssen absolut eingetragen werden
        this.setLayout(null);

        //Das Panel ist 500x 500 Pixel groß
        this.setPreferredSize(new Dimension(500,500 ));
        
        


        //Das Gitter im Hintergrund wird gezeichent
        for(int i=1; i<10; i++){
            Line x= new Line(true, i*50);
            this.add(x);
        }
        for(int i=1; i<10; i++){
            Line x= new Line(false, i*50);
            this.add(x);
        }


    }

    //speichert x und y als String im Speicher
    //und das Subtile in einem anderen Array, aber auf der selben position wie die 
    //die dazugehörige koordinate
    public void speichern( Subtile subtile){
        if(!(speicherKoords.contains(subtile.getX()+ " "+ subtile.getY())));
        speicherKoords.add(subtile.getX()+ " "+ subtile.getY());
        if(!(speicherTiles.contains(subtile))){
            speicherTiles.add( subtile);
        }
    }

    //löscht den String, der x und y enthält aus dem Speicher
    public void loeschen(int x, int y){
        speicherKoords.remove(x+ " "+ y);
    }

    //gibt true zurück, wenn 
    public boolean vergleichen(int x, int y){
        if(speicherKoords.contains(x+ " "+ y)){
            return true;
        }
        return false;
    }

    //gibt den index zurück, auf dem das Subtile und die zugehörige koordinate gespeichert sind
    public int getIndex (int x, int y){
        int index; 

        index= speicherKoords.indexOf(x+ " " + y);
        return index;

    }



    //Überprüft jede reihe, ob sie voll ist
    public void reihePruefen(){

        boolean reiheVoll= true;
        System.out.println(speicherKoords);

        for(int i=10; i>0; i--){
            reiheVoll = true;
            for(int j=0; j<10; j++){
                if(vergleichen(j*50,i*50)== true && reiheVoll== true){
                    
                }else {
                    reiheVoll= false; 
                }

                
            }
            System.out.println("Reihe voll: "+ reiheVoll );
            if(reiheVoll==true){
                reiheEntfernen(i * 50);


                }
        }
        
        
    }

    public void reiheEntfernen( int y){
        int index; 

        
        for(int j=0; j< 10; j++){
            index= getIndex (j*50, y);
            System.out.println(index);
            speicherKoords.set(index , null);
            speicherKoords.remove(index);
            speicherTiles.remove(index);
            speicherTiles.set(index, null);
            System.out.println("reihe entfernt");
        }
        System.out.println(speicherKoords);
        System.out.println(speicherTiles);
    }



    public void setTile(LTile tile){
        lTile= tile; 
    }



    public void deleteTile(){
        lTile= null;
        spielfeld.deleteTile();
    }


    
}