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
                    //System.out.println("location changed by timer");
                    tile.changeLocation(0, 50);
                }catch(InterruptedException e){
                    System.out.println("Timer unterbrochen");
        
                }
                

    }

    public void irgendwas(){
        System.out.println("Hallo irgendwas");
    }
        
}
