package DesignPatterns.observer;

/**
 * Created by hakanmehmed on 05/07/2017.
 */
public class ThermometerClient implements Observer {
    private Setup setup;

    public ThermometerClient(Setup s) {
        this.setup = s;
    }
    public void update(Observable observable) {
        Thermometer t = (Thermometer) observable;

        System.out.println("Temp: " + t.getTemp());
    }

    public static void main(String[] args) {
        Setup s = new Setup();
        ThermometerClient client = new ThermometerClient(s);
        s.getThermometer().addObservable(client);

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        s.shutdown();
    }
}
