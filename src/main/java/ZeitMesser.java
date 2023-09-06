package main.java;

public class ZeitMesser implements Runnable{

    public ZeitMesser(){

    }



    @Override
    public void run() {

        try {
            Thread.sleep(1000);
            System.out.println("Ich bin 1 Thread");
        }catch(InterruptedException e){
            System.out.println("somethings wrong");

        }
    }

    public void haloosSagen(){
        System.out.println("hallo");
    }
    
}
