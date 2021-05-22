package userInterface;

import Threads.InactivityCommonZone;
import Threads.InactivityConsumer;
import Threads.InactivityProducer;

import javax.swing.*;
import java.awt.*;

public class InactivityTimePanel extends JPanel {
    private InactivityCommonZone commonZone;
    private InactivityConsumer consumer;
    private InactivityProducer producer;

    public InactivityTimePanel() {
        this.commonZone = new InactivityCommonZone();
        this.producer = new InactivityProducer(commonZone, this);
        this.consumer = new InactivityConsumer(commonZone);
        producer.start();
        consumer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        String secondsInText;
        String minutesInText;
        int seconds = this.commonZone.getSeconds();
        int minutes = seconds / 60;
        seconds %= 60;
        if(minutes < 10) {
            minutesInText = "0" + minutes;
        } else {
            minutesInText = String.valueOf(minutes);
        }
        if(seconds < 10) {
            secondsInText = "0" + seconds;
        } else {
            secondsInText = String.valueOf(seconds);
        }
        String output = minutesInText + ":" + secondsInText;
        g.drawString(output ,50, 50);
    }

    public void setSeconds(int seconds) {
        this.commonZone.setSeconds(seconds);
    }
    public void setProducerSeconds(int seconds) {
        this.producer.setSeconds(seconds);
    }

}
