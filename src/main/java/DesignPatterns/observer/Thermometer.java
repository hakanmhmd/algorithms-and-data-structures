package DesignPatterns.observer;


/**
 * Created by hakanmehmed on 05/07/2017.
 */
public class Thermometer extends Observable {
    private double temperature;


    public String getTemp(){
        return String.format("%,.1fC", this.temperature);
    }
    public void driverUpdate(double temperature){
        this.temperature = temperature/100.0;
        super.notifyDependents();
    }
}
