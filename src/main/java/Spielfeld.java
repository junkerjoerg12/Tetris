package main.java;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import java.util.Random;

public class Spielfeld extends JFrame implements KeyListener{

    
    Random random = new Random();

    MyPanel panel;

    LTile lTile;
    KreuzTile kreuz; 
    NoNameTile noNameTile;
    SquareTile square;
    StraightTile linie;
    DreieckTile dreieck;

    int x;

    int breite;
    int hoehe;





    //Kostruktor
    public Spielfeld(int breite, int hoehe){


        this.breite= breite; 
        this.hoehe= hoehe;

        this.addKeyListener(this);

        panel= new MyPanel(this, breite, hoehe);
        this.add(panel);

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); 
        this.setVisible(true);


    }


    public void spielen(){

        

        x=random.nextInt(5);

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



    }


    public void kreuzAdden(){
        
        kreuz= new KreuzTile(Color.GREEN, panel, breite);
        kreuz.addTile(panel);
        kreuz.drehpunkErrechnen();
        kreuz.zugBeendet();
    }
    public void dreieckAdden(){
        
        dreieck= new DreieckTile(Color.BLUE, panel, breite);
        dreieck.addTile(panel);
        dreieck.drehpunkErrechnen();
        dreieck.zugBeendet();
    }
    public void noNameAdden(){
        
        noNameTile= new NoNameTile(Color.YELLOW, panel, breite);
        noNameTile.addTile(panel);
        noNameTile.drehpunkErrechnen();
        noNameTile.zugBeendet();
    }
    public void squareAdden(){
        
        square= new SquareTile(Color.MAGENTA, panel, breite);
        square.addTile(panel);
        square.drehpunkErrechnen();
        square.zugBeendet();
    }
    public void linieAdden(){
        
        linie= new StraightTile(Color.ORANGE, panel, breite);
        linie.addTile(panel);
        linie.drehpunkErrechnen();
        linie.zugBeendet();
    }
    public void LTileAdden(){
        
        lTile= new LTile(Color.RED, panel, breite);
        lTile.addTile(panel);
        lTile.drehpunkErrechnen();
        lTile.zugBeendet();
    }




    //User Input
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {        //Pfeil nacch unten == 40, nach links ==37, nach rechts == 39
        

        
        if(e.getKeyCode()==40){             //Form wird eine Ziele nach unten versetzt
            
        if(x== 0){
            kreuz.changeLocation(0, 50);

        }else if(x==1){
            dreieck.changeLocation(0, 50);

        }else if(x==2) {
            noNameTile.changeLocation(0, 50);

        }else if(x==3){
            square.changeLocation(0, 50);

        }else if(x==4){
            linie.changeLocation(0, 50);

        }else if(x==5){
            lTile.changeLocation(0, 50);

        }

        
        }else if( e.getKeyCode()==37){      //Form wird nach links verschoben
            

            if(x== 0){
                if(kreuz.kollisionLinks()==false){
                    kreuz.changeLocation(-50, 0);
                }    

            }else if(x==1){
                if(dreieck.kollisionLinks()==false){
                    dreieck.changeLocation(-50, 0);
                }
            }else if(x==2) {
                if(noNameTile.kollisionLinks()==false){
                    noNameTile.changeLocation(-50, 0);
                }
            }else if(x==3){
                if(square.kollisionLinks()==false){
                    square.changeLocation(-50, 0);
                }

            }else if(x==4){
                if(linie.kollisionLinks()==false){
                    linie.changeLocation(-50, 0);
                }

            }else if(x==5){
                if(lTile.kollisionLinks()==false){
                    lTile.changeLocation(-50, 0);
                }

            }
            

        }else if(e.getKeyCode()==39){
            
            if(x== 0){
                if(kreuz.kollisionRechts() == false){
                    kreuz.changeLocation(+50, 0);
                }

            }else if(x==1){
                if(dreieck.kollisionRechts() == false){
                    dreieck.changeLocation(+50, 0);
                }

            }else if(x==2) {
                if(noNameTile.kollisionRechts() == false){
                    noNameTile.changeLocation(+50, 0);
                }

            }else if(x==3){
                if(square.kollisionRechts() == false){
                    square.changeLocation(+50, 0);
                }
            }else if(x==4){
                if(linie.kollisionRechts() == false){
                    linie.changeLocation(+50, 0);
                }
            }else if(x==5){
                if(lTile.kollisionRechts() == false){
                    lTile.changeLocation(+50, 0);
                }

            }


        }else if(e.getKeyCode()==38){
            if(x== 0){
                kreuz.mitUhrDrehen();

            }else if(x==1){
                dreieck.mitUhrDrehen();

            }else if(x==2) {
                noNameTile.mitUhrDrehen();

            }else if(x==3){
                square.mitUhrDrehen();

            }else if(x==4){
                linie.mitUhrDrehen();

            }else if(x==5){
                lTile.mitUhrDrehen();

            }
        }



        
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }


    public void deleteTile(){
        lTile= null;
        square= null;
        linie= null;
        kreuz= null; 
        noNameTile= null;
        dreieck= null;

        spielen();
    }
    
}
