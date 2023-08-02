package main.java;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel{

    int anzahlSpalten=10;
    int anzahlZeilen=20; 

    public MyPanel(){
        this.setLayout(null);
        this.setPreferredSize(new Dimension(500,500 ));
        

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