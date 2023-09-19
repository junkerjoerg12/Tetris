package main.java;

public class ZeitMesser implements Runnable{

    Tile tile;

    public ZeitMesser(Tile tile){

        this.tile=tile;
    }



    @Override
    public void run() {

        System.out.println("Thread 1 gestartet");
        zeitStoppen();
    }
    

    public void zeitStoppen(){
        
        
                try {
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    System.out.println("Timer has failed");
        
                }
                tile.changeLocation(0, 50);

    }

    public void irgendwas(){
        System.out.println("Hallo irgendwas");
    }
        
}
