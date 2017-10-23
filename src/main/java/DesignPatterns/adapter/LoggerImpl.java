package DesignPatterns.adapter;

/**
 * Created by hakanmehmed on 03/07/2017.
 */
public class LoggerImpl extends Logger {
    @Override
    public void debug(String s) {
        System.out.println("DEBUG: " + s);
    }

    @Override
    public void trace(String s) {
        System.out.println("TRACE: " + s);
    }

    @Override
    public void log(String s) {
        System.out.println("LOG: " + s);
    }
}
