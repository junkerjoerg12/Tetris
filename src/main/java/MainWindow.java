package main.java;

import java.awt.Dimension;
//import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import java.util.Random;

public class MainWindow extends JFrame implements KeyListener{

    
    Random random = new Random();

    Spielfeld spielfeld;
    Background hintergrund;


    int x;

    int breite;
    int hoehe;
    Tile tile;





    //Kostruktor
    public MainWindow(int breite, int hoehe){

        this.breite= breite; 
        this.hoehe= hoehe;

        this.addKeyListener(this);
        this.setLayout(null);
        this.setUndecorated(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); 
        this.setResizable(false);
        this.setVisible(true);
        





        hintergrund= new Background(this, breite, hoehe);
        this.add(hintergrund);

        spielfeld= new Spielfeld(this, breite, hoehe);
        hintergrund.add(spielfeld);






    }


    public void spielen(){

        
        //wieder auf 6 zurückändern
        x=random.nextInt(6);

        //tests
        //x=4;
        tile =  new Tile(spielfeld, x);

        repaint();



    }



    //User Input
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {        //Pfeil nacch unten == 40, nach links ==37, nach rechts == 39
        

        //try{
            if(e.getKeyCode()==40){             //Form wird eine Zeile nach unten versetzt
                System.out.println("Koordinaten bei Tastendruck X: " + spielfeld.getX()+ " Y: "+ spielfeld.getY());



                tile.getTimerThread().interrupt();
                tile.deleteTimer();

                tile.changeLocationDown(0,50);
                
                if(tile.getTimerThread()== null){
                    tile.timerErstellen(1000);
                }

                spielfeld.repaint();
                
                

            
            }else if( e.getKeyCode()==37){      //Form wird nach links verschoben

                if(tile.kollisionLinks()==false){
                    tile.changeLocation(-50, 0);
                
                }
                spielfeld.repaint();

            }else if(e.getKeyCode()==39){       //Form wird nach rechts verschoben
                            
                if(tile.kollisionRechts()==false){
                    tile.changeLocation(50, 0);
                
                }
                spielfeld.repaint();

            }else if(e.getKeyCode()==38){       //Form wird um 90°im Uhrzeigersinn gedreht
                tile.mitUhrDrehen();


                spielfeld.repaint();
            }

        //}catch(NullPointerException exception){
          //  System.out.println("Du hast schon längst verloren");
        //}
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    public void deleteTile(boolean verloren){
        tile= null;


        //darf nur aufgerufen werden, wenn das Spiel noch nicht beendet ist
        if(verloren == false){
            spielen();
        }else{
            System.out.println("hier kommt nichts mehr");
        }
    }


    public Tile getTile(){
        return tile;
    }

    public Background getHintergrund(){
        return hintergrund;
    }
}
