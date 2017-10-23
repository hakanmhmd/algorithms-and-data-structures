package DesignPatterns.adapter;

/**
 * Created by hakanmehmed on 03/07/2017.
 */
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.create();

        logger.debug("Debug message");
        logger.trace("Trace message");
        logger.log("Log message");
    }
}
