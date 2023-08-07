package main.java;

import java.awt.Color;
import java.awt.event.*;

 abstract class Tile{
    Subtile[]einzelteile;

    //Koordinaten des Drehpunkts
    int xMitte; 
    int yMitte; 


    public Tile(){
        

    }


    //fügt die Subsquares zu panel hinzu
    public void addTile(MyPanel panel){
        for(int i=0; i<einzelteile.length; i++){
            panel.add(einzelteile[i]);
        }

    }


    //Position des Tiles ändern
    public void changeLocation(int x, int y){
        if(this.outOfBounds(x, y)==true){
            for(int i=0; i<einzelteile.length; i++){

                
                
                einzelteile[i].setLocation(einzelteile[i].getX()+x, einzelteile[i].getY()+y);
            }
            xMitte= xMitte+x;
            yMitte= yMitte+y;
        }
    }


    //Rechnet das Feld aus, um das sich das Tile dehen soll
    public void drehpunkErrechnen(){
        int xMax=einzelteile[0].getX(); 
        int xMin=einzelteile[0].getX();
        int yMax=einzelteile[0].getY(); 
        int yMin=einzelteile[0].getY();


        //Höchste und niedrigste X und Y Koordinate der Figur wird herausgefunden
        for(int i=0; i<einzelteile.length; i++){
            if(einzelteile[i].getX()>xMax){
                xMax=einzelteile[i].getX();
            }else if(einzelteile[i].getX()<xMin){
                xMin= einzelteile[i].getX();
            }
            if(einzelteile[i].getY()>yMax){
                yMax= einzelteile[i].getY();
            }else if(einzelteile[i].getY()<yMin){
                yMin= einzelteile[i].getY();
            }
        }

        //Drehpunkt wird berechnet: 
        //Mittelpunt der Figur wird errechnet, wenn dieser kein Subtile ist,
        //wird das Subtile mit den nächst kleineren werten als Drehpunt festgelegt

        xMitte= (xMax+xMin)/2;

        if(xMitte%50!=0){
            xMitte=xMitte-25;
        }


        yMitte= (yMax+yMin)/2;

        if(yMitte%50!=0){
            yMitte=yMitte-25;
        }

        for(int i=0; i<einzelteile.length; i++){
            if(einzelteile[i].getX()==xMitte && einzelteile[i].getY()==yMitte){
                einzelteile[i].setDrehpunkt(true);
            }
        }
    } 



    //testet, ob nach dem Bewegen des Teils eines der Subtiles außerhalb des Spielfelds ist 
    public boolean outOfBounds(int x, int y){
        boolean valid= true;


        for(int i=0; i<einzelteile.length; i++){
            if(einzelteile[i].getY()+y > 450 || einzelteile[i].getX()+x < 0 || einzelteile[i].getX() + x >450 ){
                valid= false;
                 
            }
        }
        return valid;
    }


    public void mitUhrDrehen(){
        int xNeu; 
        int yNeu;
        boolean valid=true; 
        
        int ram;

        //Vergibt Koordinaten Relativ zum Drehpunkt
        for(int i=0; i< einzelteile.length; i++){
            einzelteile[i].setXRel(einzelteile[i].getX()-xMitte);
            einzelteile[i].setYRel(einzelteile[i].getY()-yMitte);
        }

        for(int i=0; i< einzelteile.length; i++){

            System.out.println(einzelteile[i].getY());

            //drehen

            //1: X und Y Koordinaten Relativ zum Drehpunkt tauschen
            ram =einzelteile[i].getXRel();
            einzelteile[i].setXRel(einzelteile[i].getYRel());
            einzelteile[i].setYRel(ram);
            
            //2: Vorzeichen von X umkehren
            einzelteile[i].setXRel(einzelteile[i].getXRel()*-1);



            //3: Überprüfen, ob keines der Felder außerhalb des Spielfelds ist
            if(!(einzelteile[i].getXRel()+xMitte<500 && einzelteile[i].getXRel()+xMitte >=  0 && einzelteile[i].getYRel()+yMitte >=0 && einzelteile[i].getYRel()+yMitte <450 && valid==true)){
                valid=false;
                } 
            
 
        }

        //Position der Felder aus dem spielfeld ändern, wenn keines der Felder außerhalb des spielfelds ist
        if(valid==true){
           for(int i=0; i< einzelteile.length; i++){
                einzelteile[i].setLocation(einzelteile[i].getXRel()+xMitte, einzelteile[i].getYRel()+yMitte);
           }
        }

    }

    
}
