package main.java;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Spielfeld extends JFrame implements KeyListener{

    
    MyPanel panel;

    //Kostruktor
    public Spielfeld(){

        this.addKeyListener(this);

        panel= new MyPanel();
        this.add(panel);

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); 
        this.setVisible(true);

        //Quadrat wird zu Testzwecken geaddet
        NoNameTile quadrat= new NoNameTile(Color.RED);
        quadrat.addTile(panel);
        
    }




    //User Input
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }


    
}
