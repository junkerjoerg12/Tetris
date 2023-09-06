package main.java;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import java.util.Random;

public class Spielfeld extends JFrame implements KeyListener{

    
    Random random = new Random();

    MyPanel panel;

   

    int x;

    int breite;
    int hoehe;
    Tile tile;





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

        
        //wieder auf 6 zurückändern
        x=random.nextInt(6);

        //tests
        //x=4;
        tile =  new Tile(panel, x);

        repaint();



    }



    //User Input
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {        //Pfeil nacch unten == 40, nach links ==37, nach rechts == 39
        

        try{
            if(e.getKeyCode()==40){             //Form wird eine Zeile nach unten versetzt
             
                tile.changeLocation(0,50);
                

            
            }else if( e.getKeyCode()==37){      //Form wird nach links verschoben
                

                if(tile.kollisionLinks()==false){
                        tile.changeLocation(-50, 0);
                    }

 

            }else if(e.getKeyCode()==39){

                if(tile.kollisionRechts() == false){
                        tile.changeLocation(+50, 0);
                    }
  


            }else if(e.getKeyCode()==38){

                tile.mitUhrDrehen();
                
                
 
            }

        }catch(NullPointerException exception){
            System.out.println("Du hast schon längst verloren");
        }



        
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }


    public void deleteTile(boolean verloren){
        tile= null;


        //darf nur aufgerufen werden, wenn das Spiel noch nicht beendet ist
        if(verloren == false){
            spielen();
        }else{
            System.out.println("hier kommt nichts mehr");
        }
    }
    
}
