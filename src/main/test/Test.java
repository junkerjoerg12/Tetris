package main.test;

import main.java.Spielfeld;

public class Test {
    public static void main(String args[]){

        int spielfeldbreite =20;
        int spielfeldhoehe = 20;




        Spielfeld feld= new Spielfeld(spielfeldbreite, spielfeldhoehe);
        feld.spielen();
        

    }
}
