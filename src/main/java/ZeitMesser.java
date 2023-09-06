package main.java;

public class ZeitMesser implements Runnable{

    Tile tile;

    public ZeitMesser(Tile tile){

        this.tile=tile;
    }



    @Override
    public void run() {
        for(int i=0; i<10; i++){
            try {
                Thread.sleep(1000);
                System.out.println("Ich bin 1 Thread");
            }catch(InterruptedException e){
                System.out.println("somethings wrong");

            }
            tile.changeLocation(0, 50);
    }
        }
        

    public void haloosSagen(){
        System.out.println("hallo");
    }
    
}
