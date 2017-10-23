package DesignPatterns.observer;

/**
 * Created by hakanmehmed on 05/07/2017.
 */
public class Driver extends Thread {
    private Thermometer thermometer;
    private boolean shutdown = false;
    private long value = 30000;
    private int count = 0;

    public Driver(Thermometer t){
        this.thermometer = t;
    }

    @Override
    public void run() {
        try{
            while (!this.shutdown) {
                this.value += (long) (Math.random() * 100 - (5/2));
                this.count++;
                System.out.println("Update " + count + " : " + this.value);
                this.thermometer.driverUpdate(this.value);
                Thread.sleep((long)(Math.random() * 5000));
            }
        } catch (Exception e){

        }
    }

    public void shutdown() {
        this.shutdown = true;
    }
}
