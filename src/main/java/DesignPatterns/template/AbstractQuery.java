package DesignPatterns.template;

import Queue.Queue;

/**
 * Created by hakanmehmed on 05/07/2017.
 */
public abstract class AbstractQuery implements Query {
    public Result execute() {
        Connection c = new Connection();
        Result r = c.execute(getQueryString());
        c.close();
        return r;
    }

    abstract protected String getQueryString();
}
