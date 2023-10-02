package main.java;

import java.awt.Color;
import java.util.Random;

public class Tile{
    Subtile[]einzelteile;

    //Koordinaten des Drehpunkts
    int xMitte; 
    int yMitte;

    int breite;
    int hoehe;

    MyPanel panel;  


    Random random= new Random();

    ZeitMesser timer;
    Thread thread1;


    public Tile( MyPanel panel, int x){
        this.panel= panel;
        breite= panel.getBreite();
        hoehe= panel.getHoehe();

        if(x== 0){
            kreuzAdden();
            
        }else if(x==1){
            dreieckAdden();

        }else if(x==2) {
            noNameAdden();

        }else if(x==3){
            squareAdden();

        }else if(x==4){
            linieAdden();

        }else if(x==5){
            LTileAdden();

        }

        timerStarten();

    }

    public void timerStarten(){

        timer= new ZeitMesser(this);

        thread1= new Thread(timer);

        thread1.start();
    }

    


    public void kreuzAdden(){

        Color farbe = Color.GREEN;

        //Spawn Koordinate wird random generiert
        einzelteile= new Subtile[6];
        int xKoord= random.nextInt(1, breite-1)*50;



        //4 Subtiles werden erstellt und ausgehend von der vorher 
        //generierten KOordinate zu einem 2x2 Quadrat zusammen gebaut
        einzelteile[0]= new Subtile(farbe, xKoord, 0);
        einzelteile[1]= new Subtile(farbe, xKoord, 50);
        einzelteile[2]= new Subtile(farbe, xKoord, 100);
        einzelteile[3]= new Subtile(farbe, xKoord, 150);
        einzelteile[4]= new Subtile(farbe, xKoord -50, 100);
        einzelteile[5]= new Subtile(farbe, xKoord +50, 100);

        
        addTile(panel);
        drehpunkErrechnen();
        zugBeendet();
    }
    public void dreieckAdden(){

        Color farbe = Color.BLUE;

        //Spawn Koordinate wird random generiert
        einzelteile= new Subtile[3];
        int xKoord= random.nextInt(breite -1)*50;
        


        //4 Subtiles werden erstellt und ausgehend von der vorher 
        //generierten KOordinate zu einem 2x2 Quadrat zusammen gebaut
        einzelteile[0]= new Subtile(farbe, xKoord, 0);
        einzelteile[1]= new Subtile(farbe, xKoord, 50);
        einzelteile[2]= new Subtile(farbe, xKoord+50, 50);
        
        addTile(panel);
        drehpunkErrechnen();
        zugBeendet();
    }
    public void noNameAdden(){

        Color farbe = Color.YELLOW;

        //Spawn Koordinate wird random generiert
        einzelteile= new Subtile[4];
        int xKoord= random.nextInt(breite-1)*50;
        


        //4 Subtiles werden erstellt und ausgehend von der vorher 
        //generierten KOordinate zu einer 1x4 Linie zusammen gebaut
        einzelteile[0]= new Subtile(farbe, xKoord, 0);
        einzelteile[1]= new Subtile(farbe, xKoord, 50);
        einzelteile[2]= new Subtile(farbe, xKoord+50, 50);
        einzelteile[3]= new Subtile(farbe, xKoord+50, 100);

        
        addTile(panel);
        drehpunkErrechnen();
        zugBeendet();
    }
    public void squareAdden(){

        Color farbe = Color.MAGENTA;

        //Spawn Koordinate wird random generiert
        einzelteile= new Subtile[4];
        int xKoord= random.nextInt(breite- 1)*50;
        


        //4 Subtiles werden erstellt und ausgehend von der vorher 
        //generierten KOordinate zu einem 2x2 Quadrat zusammen gebaut
        einzelteile[0]= new Subtile(farbe, xKoord, 0);
        einzelteile[1]= new Subtile(farbe, xKoord+50, 0);
        einzelteile[2]= new Subtile(farbe, xKoord, 50);
        einzelteile[3]= new Subtile(farbe, xKoord+50, 50);

        
        addTile(panel);
        drehpunkErrechnen();
        zugBeendet();
    }
    public void linieAdden(){
        


        Color farbe = Color.ORANGE;

        //Spawn Koordinate wird random generiert
        einzelteile= new Subtile[4];
        int xKoord= random.nextInt(breite-1)*50;
        

        
        //4 Subtiles werden erstellt und ausgehend von der vorher 
        //generierten KOordinate zu einer 1x4 Linie zusammen gebaut
        einzelteile[0]= new Subtile(farbe, xKoord, 0);
        einzelteile[1]= new Subtile(farbe, xKoord, 50);
        einzelteile[2]= new Subtile(farbe, xKoord, 100);
        einzelteile[3]= new Subtile(farbe, xKoord, 150);

        addTile(panel);
        drehpunkErrechnen();
        zugBeendet();
    }
    public void LTileAdden(){

        Color farbe = Color.RED;

        //Spawn Koordinate wird random generiert
        einzelteile= new Subtile[4];
        int xKoord= random.nextInt(breite- 1)*50;
        


        //4 Subtiles werden erstellt und ausgehend von der vorher 
        //generierten KOordinate zu einem L zusammen gebaut
        einzelteile[0]= new Subtile(farbe, xKoord, 0);
        einzelteile[1]= new Subtile(farbe, xKoord, 50);
        einzelteile[2]= new Subtile(farbe, xKoord, 100);
        einzelteile[3]= new Subtile(farbe, xKoord+50, 100);
        
        
        addTile(panel);
        drehpunkErrechnen();
        zugBeendet();
    }



    //fügt die Subsquares zu panel hinzu
    public void addTile(MyPanel panel){
        for(int i=0; i<einzelteile.length; i++){
            panel.add(einzelteile[i]);
        }

    }


    //Position des Tiles ändern
    public void changeLocation(int x, int y){
        //System.out.println("Location changed");
        if(outOfBounds(x, y)==true){



            //System.out.println("Timer Status: am Leben: " + thread1.isInterrupted());
            
            
            for(int i=0; i<einzelteile.length; i++){
                
                
                
                einzelteile[i].setLocation(einzelteile[i].getX()+x, einzelteile[i].getY()+y);
            }
            
            xMitte= xMitte+x;
            yMitte= yMitte+y;
        }
        
        zugBeendet();

        
        
        try {
            timer.zeitStoppen();
        } catch (IllegalThreadStateException e) {
            System.out.println("Illigal THread State Exception");
            //thread1.interrupt();
            //thread1.start();
        } catch(NullPointerException e){
            System.out.println("Irgendwie falschrum");
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

           // System.out.println("hoehe_ 50: " + (hoehe-50));
            //System.out.println("breite- 50: "+ (breite-50));

            if(einzelteile[i].getY()+y > hoehe*50-50 || einzelteile[i].getX()+x < 0 || einzelteile[i].getX() + x >breite*50-50 ){
                valid= false;
                 
            }
        }
        return valid;
    }


    public void mitUhrDrehen(){

        boolean valid=true; 
        
        int ram;

        //Vergibt Koordinaten Relativ zum Drehpunkt
        for(int i=0; i< einzelteile.length; i++){
            einzelteile[i].setXRel(einzelteile[i].getX()-xMitte);
            einzelteile[i].setYRel(einzelteile[i].getY()-yMitte);
        }

        for(int i=0; i< einzelteile.length; i++){


            //drehen

            //1: X und Y Koordinaten Relativ zum Drehpunkt tauschen
            ram =einzelteile[i].getXRel();
            einzelteile[i].setXRel(einzelteile[i].getYRel());
            einzelteile[i].setYRel(ram);
            
            //2: Vorzeichen von X umkehren
            einzelteile[i].setXRel(einzelteile[i].getXRel()*-1);



            //3: Überprüfen, ob keines der Felder außerhalb des Spielfelds ist
            if(!(einzelteile[i].getXRel()+xMitte< (breite*50) && einzelteile[i].getXRel()+xMitte >=  0 && einzelteile[i].getYRel()+yMitte >=0 && einzelteile[i].getYRel()+yMitte < (hoehe*50) && valid==true)){
                valid=false;
            }

            
            //4: überprüfen, ob keines der felder ein anderes Tile überlapt

            //System.out.println("tatsächliche KOordinaten: x:"+ (einzelteile[i].getXRel()+xMitte)+ "  y:"+ (einzelteile[i].getYRel()+yMitte) + "  Koordinatensammlung: "+ panel.getKoords());

            if((panel.getKoords().contains((einzelteile[i].getXRel()+xMitte)+ " "+ (einzelteile[i].getYRel()+yMitte)))){
                System.out.println("überlappung");
                valid = false;
            }
            
 
        }

        //Position der Felder aus dem spielfeld ändern, wenn keines der Felder außerhalb des spielfelds ist
        if(valid==true){
           for(int i=0; i< einzelteile.length; i++){
                einzelteile[i].setLocation(einzelteile[i].getXRel()+xMitte, einzelteile[i].getYRel()+yMitte);
           }
        }

        changeLocation(0, 0);

    }


   
    public void zugBeendet(){

        boolean beendet= false;


        //der Zug ist beedet, wenn ein teil auf einem anderen aufliegt
        if(kollisionUnten() == true){
            beendet = true;
        }

        for(int i=0; i<einzelteile.length; i++){

            if(einzelteile[i].getY()==hoehe* 50- 50){
                beendet= true;
                
            }
        }
        //Speichert die Subtiles aufs panel
        if(beendet== true){

            //wird geprüft, ob reihe entfernt werden muss
            

            //es wird geprüft, ob ein Subtile oben anstößt
            if(verlorenPruefen() == true){
                

                System.out.println("Sie haben verloren!!");
                System.out.println("Ihr Highscore : " + panel.getScore());
 

                //löscht hoffentlich den Timer und führt so zu keinem crash
                deletTimer();
                
                //Subtiles werden aufs panel gespeicehrt
                umspeichern();

                //Subtiles werden aus this gelöscht
                deletSubtiles();

                //this wird gelöscht
                panel.deleteTile(true);
                
                //panel.add(new TextArea("Verloren"));
            }else{
                //löscht hoffentlich den Timer und führt so zu keinem crash
                deletTimer();

                //Subtiles werden aufs panel gespeicehrt
                umspeichern();
                
                //Subtiles werden aus this gelöscht
                deletSubtiles();
    
                //this wird gelöscht
                panel.deleteTile(false);

            }

            panel.reihePruefen();



        }
        
        
    }

    //löscht den timer
    public void deletTimer(){
        timer=null;
        thread1=null;
    }

    public boolean kollisionUnten(){

        boolean kollision= false;

        //Kollision nach unten wird geprüft
        for(int i=0; i<einzelteile.length; i++){
            if(panel.getKoords().contains((einzelteile[i].getX()) + " " + (einzelteile[i].getY()+50))){
                kollision= true;
            }
        }
        return kollision;
    }



    //Überprüft, ob das Teil ein anderes nach recht berührt
    public boolean kollisionRechts(){

        boolean kollision =false;

        for(int i=0; i<einzelteile.length; i++){
            if(panel.getKoords().contains((einzelteile[i].getX()+50) + " " + (einzelteile[i].getY()))){
                kollision= true;
            }
        }
        return kollision;
    }



    //Überprüft, ob das Teil ein anderes nach links berührt

    public boolean kollisionLinks(){

        boolean kollision =false;

        for(int i=0; i<einzelteile.length; i++){
            if(panel.getKoords().contains((einzelteile[i].getX()-50) + " " + (einzelteile[i].getY()))){
                kollision= true;
            }
        }
        return kollision;
    }




    //Speichert die subtiles im Panel 
    public void umspeichern(){
        for(int i=0; i<einzelteile.length; i++){
            panel.speichern(einzelteile[i]);
        }
    }


    //ist glaube ich unnötig
    public void deletSubtiles(){
        for (int i=0; i<einzelteile.length; i++){
            einzelteile[i]= null;
        }
    }

    public boolean verlorenPruefen(){
        boolean verloren= false;

        for(int i=0; i< einzelteile.length; i++){

            if(einzelteile[i].getY()==0){
                verloren = true;
            }
        }
        
        //System.out.println("verloren: " + verloren);
        return verloren;
    }


    public Thread getTimerThread(){
        return thread1;
    }
}
