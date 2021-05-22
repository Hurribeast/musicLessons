package Threads;

public class InactivityCommonZone {
    private int seconds;
    private boolean toCrush;

    public synchronized int getSeconds() {
        if(toCrush) {
            try {
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " lit la valeur " + seconds);
        toCrush = true;
        notify();
        return seconds;
    }

    public synchronized void setSeconds(int seconds) {
        if(!toCrush) {
            try {
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.seconds = seconds;
        System.out.println(Thread.currentThread().getName() + " écrit la valeur " + this.seconds);
        toCrush = false;
        notify();
    }
}
