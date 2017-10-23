package DesignPatterns.template;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hakanmehmed on 05/07/2017.
 */
public class Connection {
    public Result execute(String queryString) {
        Set<String> result = new HashSet<String>();
        if(queryString.contains("PEOPLE")){
            result.add("Hakan");
            result.add("Mehmed");
        }
        return new Result(result);
    }

    public void close() {

    }
}
