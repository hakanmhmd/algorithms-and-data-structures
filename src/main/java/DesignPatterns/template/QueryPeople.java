package DesignPatterns.template;

/**
 * Created by hakanmehmed on 05/07/2017.
 */
public class QueryPeople extends AbstractQuery {

    protected String getQueryString() {
        return "SELECT * FROM PEOPLE";
    }
}
