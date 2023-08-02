package main.java;

import javax.swing.JPanel;
import java.awt.*;

public class Subtile extends JPanel{

    int xKoord;
    int yKoord;


    public Subtile(Color farbe, int xKoord, int yKoord){
        this.xKoord=xKoord;
        this.yKoord=yKoord;
        this.setSize(50, 50);
        this.setBackground(farbe);
        this.setVisible(true);


    }

}