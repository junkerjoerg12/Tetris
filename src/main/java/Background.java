package main.java;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Background extends JPanel{
    
    MainWindow mainWindow;


    public Background(MainWindow mainWindow, int breite, int hoehe){

        this.mainWindow= mainWindow;

        JLabel ueberschrift= new JLabel("Tetris by Jakob Engel");
        ueberschrift.setBounds(0, 0, 200, 200);
        this.add(ueberschrift);

        
        
        this.setSize(1920, 1080);
        this.setVisible(true);
        
        
    }




    public MainWindow getMainWindow(){
        return mainWindow;
    }
}
