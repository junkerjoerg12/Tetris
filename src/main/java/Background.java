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

    JLabel scoreFeld;
    JLabel highscoreFeld;


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

    public void addScoreFeld(){

        scoreFeld= new JLabel("Score: "+ mainWindow.getSpielfeld().getScore());

        int hoehe=100;
        int breite= (mainWindow.getHintergrund().getWidth())/2;
        int x= mainWindow.getSpielfeld().getX()+ mainWindow.getSpielfeld().getWidth();
        int y= mainWindow.getHintergrund().getHeight()/2- hoehe;

        System.out.println(x+ " " +y+ " " +breite+ " " + hoehe);

        scoreFeld.setBounds(x,y, breite, hoehe);
        
        

        this.add(scoreFeld);
    }





    public MainWindow getMainWindow(){
        return mainWindow;
    }





}
