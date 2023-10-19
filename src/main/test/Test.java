package main.test;


import main.java.MainWindow;

public class Test {
    public static void main(String args[]){

        int spielfeldbreite =15;
        int spielfeldhoehe = 15;


        
        MainWindow feld= new MainWindow(spielfeldbreite, spielfeldhoehe);
        feld.spielen();
        

    }
}
