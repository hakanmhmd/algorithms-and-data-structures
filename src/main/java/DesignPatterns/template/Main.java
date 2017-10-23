package DesignPatterns.template;

/**
 * Created by hakanmehmed on 05/07/2017.
 */
public class Main {
    public static void main(String[] args) {
        Query q = new QueryPeople();
        executeQuery(q);
    }

    private static void executeQuery(Query q) {
        Result r = q.execute();
        r.printOutput();
    }
}
