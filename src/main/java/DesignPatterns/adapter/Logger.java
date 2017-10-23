package DesignPatterns.adapter;

/**
 * Created by hakanmehmed on 03/07/2017.
 */
public abstract class Logger {

    public static Logger create() {
        return new LogAdapter();
    }

    public abstract void debug(String s);

    public abstract void trace(String s);

    public abstract void log(String s);
}
