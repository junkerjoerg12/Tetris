package main.java;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ExitButton extends JButton{

    int breite= 50; 
    int hoehe= 50; 
    

    public ExitButton(Background hintergrund){

        ImageIcon icon = new  ImageIcon("ExitSymbol.png");
        
        this.setBounds( 0, hintergrund.getHeight()-hoehe, breite, hoehe);
        this.addActionListener(e -> System.exit(0));
        this.setFont(new Font("Arial", Font.PLAIN, 7));
        this.setIcon(icon);
        this.setBackground(Color.WHITE);
        this.setText("EXIT");
    }
}
