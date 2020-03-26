package myio;

import java.util.Formatter;
import java.util.Timer;

public class MyTimerTask extends java.util.TimerTask {
    @Override
    public void run() {
        System.out.println("Do it Task");
    }

    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        formatter.format("dad ya %s lublu %f", "vas", 98.76);
        String string = formatter.toString();
        System.out.println(formatter);
        System.out.println(string);
        MyTimerTask task = new MyTimerTask();
        Timer myTimer = new Timer();
        myTimer.schedule(task, 1000, 1000);
        try {
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        myTimer.cancel();

    }
}
