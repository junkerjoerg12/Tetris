package main.java;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Spielfeld extends JFrame implements KeyListener{

    
    MyPanel panel;
    LTile lTile;

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

    public void lTileAdden(){
        
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
            lTile.changeLocation(-50, 0);


        }else if(e.getKeyCode()==39){
            lTile.changeLocation(+50, 0);


        }else if(e.getKeyCode()==38){
            lTile.mitUhrDrehen();
        }



        
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }


    public void deleteTile(){
        lTile= null;
        lTileAdden();
    }
    
}
