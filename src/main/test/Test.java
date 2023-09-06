package main.test;

import java.util.Timer;

import main.java.MyRunable;
import main.java.Spielfeld;

public class Test {
    public static void main(String args[]){

        int spielfeldbreite =20;
        int spielfeldhoehe = 20;


        MyRunable timer= new MyRunable();

        Thread thread1= new Thread(timer);

        thread1.start();

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {

        }


        timer.haloosSagen();


       // Spielfeld feld= new Spielfeld(spielfeldbreite, spielfeldhoehe);
        //feld.spielen();
        

    }
}
