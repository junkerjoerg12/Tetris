package main.java;

public class MyRunable implements Runnable{

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
