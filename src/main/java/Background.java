package main.java;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Background extends JPanel {
    
    MainWindow mainWindow;
    ExitButton extiButton;

    int breite;
    int hoehe;


    public Background(MainWindow mainWindow, int breite, int hoehe){

        this.mainWindow= mainWindow;

        JLabel ueberschrift= new JLabel("Tetris by Jakob Engel");
        ueberschrift.setBounds(0, 0, 200, 200);
        this.add(ueberschrift);
        
        this.setSize(1920, 1080);
        this.setVisible(true);
        this.setLayout(null);


        extiButton= new ExitButton(this);

        this.add(extiButton);
        
        
    }




    public MainWindow getMainWindow(){
        return mainWindow;
    }





}
