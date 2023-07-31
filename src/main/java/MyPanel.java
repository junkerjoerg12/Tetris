package main.java;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel{

    int anzahlSpalten=10;
    int anzahlZeilen=20; 

    public MyPanel(){
        this.setPreferredSize(new Dimension(500,500 ));

    }

    public void paint (Graphics g){
        Graphics2D g2D =(Graphics2D) g;
        g2D.setStroke(new BasicStroke(2));
        g2D.setPaint(Color.BLACK);


        //Zeichent vertikate linien des Gitters
        for(int i=1; i<anzahlSpalten; i++){
            g2D.drawLine(i*50, 0, i*50, 500);
        }
        
        //Zeichnet horizontale Linien des GItters
        for(int i=1; i<anzahlZeilen; i++){
            g2D.drawLine(0,i*50,500,i*50);

        }


    }

}