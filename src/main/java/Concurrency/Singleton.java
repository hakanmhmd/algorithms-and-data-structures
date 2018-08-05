package Concurrency;

/**
 * Typical race conditions example - if two threads enter the if statement at the same time
 */
public class Singleton {
    private static Singleton instance = null;
    private Singleton() {}

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    // synchronized prevents two or more threads executing the same code at the same time
    public static synchronized Singleton getInstance2() {
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
