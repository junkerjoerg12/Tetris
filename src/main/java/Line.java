package main.java;

import javax.swing.*;
import java.awt.*;


public class Line extends JPanel{
    
    public Line(boolean vertical, int start){
        if (vertical== true){
            this.setBounds(start, 0, 1, 500);
        }else{
            this.setBounds(0, start, 500, 1);
        }
    }
}
