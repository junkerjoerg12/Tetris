package main.java;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyPanel extends JPanel{

    int anzahlSpalten=10;
    int anzahlZeilen=20;
    int score;

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

        //jede Reieh wird geprüft 
        for(int i=10; i>0; i--){
            reiheVoll = true;

            //und jede Spalte in der betreffenden Reihe
            for(int j=0; j<10; j++){
                if(vergleichen(j*50,i*50)== true && reiheVoll== true){
                    
                }else {
                    reiheVoll= false; 
                }
                
            }

            //Wenn ja wird die Entsprechende Reihe gelöscht
            if(reiheVoll==true){
                reiheEntfernen(i * 50);
                aufrutschen(i*50);

                score=+10;
                System.out.println("Score: "+score);
            }
        }
        
        
    }


    //entfernt die Reihe auf der Übergebenen Y Koordinate
    public void reiheEntfernen( int y){
        int index;

        
        for(int j=0; j< 10; j++){
            
            //setz jedes Subtile der Reihe unsichtbar und löscht dannach sowohl sie koordinate als auch das Subtile
            index= getIndex (j*50, y);
            System.out.println(index);
            speicherKoords.remove(index);
            speicherTiles.get(index).setVisible(false);
            speicherTiles.remove(index);
            
            
        }
    }


    //Versciebt Subtiles nach unten, wenn eine Reihe gelöscht wurde und ändert die Koordinaten im String
    public void aufrutschen(int y){
        
        int index;
       
        
        for(int i=y; i>0; i-=50){
            
            for(int j=0; j<10; j++){
                if(speicherKoords.contains((j*50)+" "+ i)){
                    index= getIndex(j*50, i);
                    System.out.println("Koordinate " +speicherKoords);
                    System.out.println("angekommen"+ j*50 +"  "+i + " index: "+ index + "\n");
                    
                    speicherKoords.set(index, (j*50)+ " "+ (i-50));
                    speicherTiles.get(index).setLocation(j*50, (i-50));
                }
            }
        }

    }



    public void setTile(LTile tile){
        lTile= tile; 
    }



    public void deleteTile(){
        lTile= null;
        spielfeld.deleteTile();
    }


    
}