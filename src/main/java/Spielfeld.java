package main.java;


import java.awt.*;
import javax.swing.*;

public class Spielfeld extends JFrame{
    
    MyPanel panel;

    //Kostruktor
    public Spielfeld(){

        panel= new MyPanel();

        //this.setSize(500, 500);
        this.add(panel);
        this.pack();
        // this.setSize(1920, 1080);
        // this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); 
        this.setVisible(true);
    }


    
}
