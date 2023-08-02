package main.java;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel{

    int anzahlSpalten=10;
    int anzahlZeilen=20; 

    public MyPanel(){

        //kein Layout manager d.h. alee Koordinaten müssen absolut eingetragen werden
        this.setLayout(null);

        //Das Panel ist 500x 500 Pixel groß
        this.setPreferredSize(new Dimension(500,500 ));
        


        //Das Gitter im Hintergrund wird gezeichent
        for(int i=1; i<10; i++){
            Line x= new Line(true, i*50);
            this.add(x);
        }
        for(int i=1; i<10; i++){
            Line x= new Line(false, i*50);
            this.add(x);
        }


    }


    
}