package main.test;

import main.java.Spielfeld;

public class Test {
    public static void main(String args[]){

        int spielfeldbreite =15;
        int spielfeldhoehe = 17;




        Spielfeld feld= new Spielfeld(spielfeldbreite, spielfeldhoehe);
        feld.spielen();
        

    }
}
