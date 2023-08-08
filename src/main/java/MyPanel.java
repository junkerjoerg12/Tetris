package main.java;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyPanel extends JPanel{

    int anzahlSpalten=10;
    int anzahlZeilen=20;
    ArrayList<String> speicher= new ArrayList<String>(); 

    public MyPanel(){

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
    public void speichern(int x, int y){
        speicher.add(x+ " "+ y);
    }

    //löscht den String, der x und y enthält aus dem Speicher
    public void loeschen(int x, int y){
        speicher.remove(x+ " "+ y);
    }

    //gibt true zurück, wenn 
    public boolean vergleichen(int x, int y){
        if(speicher.contains(x+ " "+ y)){
            return true;
        }
        return false;
    }



    //Überprüft jede reihe, ob sie voll ist
    public boolean reihePruefen(){

        boolean reiheVoll= true;

        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(!(vergleichen(j*50, i* 50)== true && reiheVoll== true)){
                    reiheVoll= false; 
                }
            }
        }
        System.out.println("Die Reihe ist voll: "+ reiheVoll);
        return reiheVoll;
    }









    
}