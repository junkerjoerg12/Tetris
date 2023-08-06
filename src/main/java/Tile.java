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


    public void changeLocation(int x, int y){
        if(this.outOfBounds(x, y)==true){
            for(int i=0; i<einzelteile.length; i++){

                
                
                einzelteile[i].setLocation(einzelteile[i].getX()+x, einzelteile[i].getY()+y);
            }
            xMitte= xMitte+x;
            yMitte= yMitte+y;
            System.out.println("Drehpunkt: "+ xMitte+ " "+ yMitte);
        }
    }


    public void drehpunkErrechnen(){
        int xMax=einzelteile[0].getX(); 
        int xMin=einzelteile[0].getX();
        int yMax=einzelteile[0].getY(); 
        int yMin=einzelteile[0].getY();


        //Hüchste und niedrigste X und Y Koordinate der Figur wird herausgefunden
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

        System.out.println("Drehopunkt: "+ xMitte+" "+ yMitte);

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
        //Koordinate- KOordinate Drehpunkt

        //welche Koordinate als nächstes negativ gemacht werden muss


        boolean xnext= false;
        boolean ynext= false;


        int ram;

        for(int i=0; i< einzelteile.length; i++){
            einzelteile[i].setXRel(einzelteile[i].getX()-xMitte);

            

            einzelteile[i].setYRel(einzelteile[i].getY()-yMitte);

          


        }


        
        for(int i=0; i< einzelteile.length; i++){

            xnext= false;
            ynext= false;

            System.out.print("Abs vorn Drehnung: "+einzelteile[i].getX()+ " ");
            System.out.println(einzelteile[i].getY());


            //vorbereitungen herausfinden welches VZ zuerst getauscht wird

            //fehler in dieser bedingung vermutlich
            if((einzelteile[i].getXRel()==0) ){
                xnext=true;
            }else if(einzelteile[i].getXRel()<0 && einzelteile[i].getYRel()<0){
                xnext=true;  
            }else if(einzelteile[i].getXRel()>0 && einzelteile[i].getYRel()>0){
                xnext=true;
            }else{
                xnext= true;
            }
            

            System.out.println("Relative Korodinaten vor Tausch: "+ einzelteile[i].getXRel()+ " "+ einzelteile[i].getYRel());
            //drehen

            //1: X und Y Koordinaten Relativ zum Drehpunkt tauschen

            ram =einzelteile[i].getXRel();
            einzelteile[i].setXRel(einzelteile[i].getYRel());
            
            System.out.print("Relative Koordinaten nanch Tausch: "+einzelteile[i].getXRel()+" ");

            einzelteile[i].setYRel(ram);
            System.out.println(einzelteile[i].getYRel());
            
            
            //2: Vorzeichen von X oder Y ändern
            
            if(xnext==true){
                einzelteile[i].setXRel(einzelteile[i].getXRel()*-1);
                //xnext= false;
                //ynext = true; 
                System.out.println("test");
            }else if(ynext ==true){
                einzelteile[i].setYRel(einzelteile[i].getYRel()*-1);
                //xnext= true;
                //ynext = false; 
                System.out.println("test 2");
            }

            System.out.println("Nach Vorzeichen Tausch: "+einzelteile[i].getXRel()+ " "+ einzelteile[i].getYRel());

            //3: Umwandeln in Absolute Koordinaten


            System.out.println("Abs nach Drehung: "+ (einzelteile[i].getXRel()+xMitte)+ " "+(einzelteile[i].getYRel()+yMitte));
            System.out.println("\n");


            einzelteile[i].setLocation(einzelteile[i].getXRel()+xMitte, einzelteile[i].getYRel()+yMitte);

            
        }






    }

    
}
