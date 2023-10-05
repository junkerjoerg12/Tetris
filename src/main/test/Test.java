package main.test;


import main.java.MainWindow;

public class Test {
    public static void main(String args[]){

        int spielfeldbreite =15;
        int spielfeldhoehe = 10;


        
        MainWindow feld= new MainWindow(spielfeldbreite, spielfeldhoehe);
        feld.spielen();
        

    }
}
