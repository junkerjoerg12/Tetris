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





    //Kostruktor
    public Spielfeld(){

        this.addKeyListener(this);

        panel= new MyPanel(this);
        this.add(panel);

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); 
        this.setVisible(true);


    }


    public void spielen(){

        int x;

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
        
        kreuz= new KreuzTile(Color.GREEN, panel);
        kreuz.addTile(panel);
        kreuz.drehpunkErrechnen();
    }
    public void dreieckAdden(){
        
        dreieck= new DreieckTile(Color.BLUE, panel);
        dreieck.addTile(panel);
        dreieck.drehpunkErrechnen();
    }
    public void noNameAdden(){
        
        noNameTile= new NoNameTile(Color.YELLOW, panel);
        noNameTile.addTile(panel);
        noNameTile.drehpunkErrechnen();
    }
    public void squareAdden(){
        
        square= new SquareTile(Color.MAGENTA, panel);
        square.addTile(panel);
        square.drehpunkErrechnen();
    }
    public void linieAdden(){
        
        linie= new StraightTile(Color.ORANGE, panel);
        linie.addTile(panel);
        linie.drehpunkErrechnen();
    }
    public void LTileAdden(){
        
        lTile= new LTile(Color.RED, panel);
        lTile.addTile(panel);
        lTile.drehpunkErrechnen();
    }




    //User Input
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {        //Pfeil nacch unten == 40, nach links ==37, nach rechts == 39
        

        
        if(e.getKeyCode()==40){             //Form wird eine Ziele nach unten versetzt
            lTile.changeLocation(0, 50);

        
        }else if( e.getKeyCode()==37){      //Form wird nach links verschoben
            if(lTile.kollisionLinks()==false){
                lTile.changeLocation(-50, 0);
            }

        }else if(e.getKeyCode()==39){
            if(lTile.kollisionRechts() == false){
                lTile.changeLocation(+50, 0);
            }


        }else if(e.getKeyCode()==38){
            lTile.mitUhrDrehen();
        }



        
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }


    public void deleteTile(){
        lTile= null;
        spielen();
    }
    
}
