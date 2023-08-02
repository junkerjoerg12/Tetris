package main.java;


import java.awt.*;
import javax.swing.*;

public class Spielfeld extends JFrame{
    
    MyPanel panel;

    //Kostruktor
    public Spielfeld(){

        panel= new MyPanel();
        this.add(panel);

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); 
        this.setVisible(true);

        //Quadrat wird zu Testzwecken geaddet
        LTile quadrat= new LTile(Color.RED);
        quadrat.addL(panel);
        
    }


    
}
