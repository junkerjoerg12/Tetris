package de.junkerjoerg12.Tetris;

import de.junkerjoerg12.Tetris.Background;

public class Main {

    public static void main(String args[]) {
        System.out.println("Halli ich bin die Main methode");
        /*
         * 
         * String[] spiele = new String[1];
                     * spiele[0] = "Tetris";
         * 
         * int[] highscores = new int[1];
         * highscores[0] = 200;
         * 
         * int spielfeldbreite = 5;
         * int spielfeldhoehe = 20;
         * 
         * MainWindow feld = new MainWindow(spielfeldbreite, spielfeldhoehe);
         * 
         * 
         */
        //System.out.println("Ich glaube ich habs!!!");
         //MainWindow mainWindow = new MainWindow(20, 20);
        new Background(20, 20);
    }
}
