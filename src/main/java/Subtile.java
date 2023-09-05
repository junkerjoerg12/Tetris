package main.java;

import javax.swing.JPanel;
import java.awt.*;

public class Subtile extends JPanel{

    int xKoord;
    int yKoord;


    //Koordinaten relativ zum Drehpunkt
    int xRel; 
    int yRel;

    boolean drehpunkt= false;


    public Subtile(Color farbe, int xKoord, int yKoord){

        this.xKoord=xKoord;
        this.yKoord=yKoord;
        this.setBounds(xKoord, yKoord, 50, 50);
        this.setBackground(farbe);
        this.setVisible(true);



    }

    public void setDrehpunkt(boolean drehpunkt) {
        this.drehpunkt = drehpunkt;
        if(drehpunkt==true){
            this.setBackground(Color.BLACK);
        }
    }




    public void setXRel(int xRel){
        this.xRel= xRel;
    }

    
    public void setYRel(int yRel){
        this.yRel= yRel;
    }

    public int  getXRel(){
        return xRel;
    }

       public int getYRel(){
        return yRel;
    }




}
