package main.java;

public class ZeitMesser implements Runnable{

    Tile tile;
    int zeit;

    public ZeitMesser(Tile tile, int zeit){

        this.tile=tile;
        this.zeit=zeit;
    }



    @Override
    public void run() {

        //System.out.println("Thread 1 gestartet");
        zeitStoppen(zeit);
    }
    





        public void zeitStoppen(int zeit){
        
        try {
            Thread.sleep(zeit);
            tile.changeLocationDown(0, 50);
        }catch(InterruptedException e){
            //System.out.println("Timer unterbrochen");
        }
    }





    
        
}
