package main.test;


import main.java.MainWindow;

public class Test {
    public static void main(String args[]){

        int spielfeldbreite =20;
        int spielfeldhoehe = 20;


        
        MainWindow feld= new MainWindow(spielfeldbreite, spielfeldhoehe);
        feld.spielen();
        

    }
}
