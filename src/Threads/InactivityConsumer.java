package Threads;

public class InactivityConsumer extends Thread {

    private InactivityCommonZone commonZone;

    public InactivityConsumer(InactivityCommonZone commonZone) {
        super("consumer");
        this.commonZone = commonZone;
    }

    public void run(){
        int seconds;
        while(true) {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            seconds = commonZone.getSeconds();
        }
    }
}
