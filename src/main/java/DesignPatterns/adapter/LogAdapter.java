package DesignPatterns.adapter;



/**
 * Created by hakanmehmed on 03/07/2017.
 */
public class LogAdapter extends Logger {
    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LogAdapter.class.getName());

    @Override
    public void debug(String s) {
        logger.trace(s);
    }

    @Override
    public void trace(String s) {
        logger.trace(s);
    }

    @Override
    public void log(String s) {
        logger.info(s);
    }
}
