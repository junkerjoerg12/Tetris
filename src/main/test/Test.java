package main.test;

import main.java.Spielfeld;

public class Test {
    public static void main(String args[]){

        int spielfeldbreite =17;
        int spielfeldhoehe = 13;




        Spielfeld feld= new Spielfeld(spielfeldbreite, spielfeldhoehe);
        feld.spielen();
        

    }
}
