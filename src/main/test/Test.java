package main.test;

import main.java.Spielfeld;

public class Test {
    public static void main(String args[]){

        int spielfeldbreite =12;
        int spielfeldhoehe = 15;




        Spielfeld feld= new Spielfeld(spielfeldbreite, spielfeldhoehe);
        feld.spielen();
        

    }
}
