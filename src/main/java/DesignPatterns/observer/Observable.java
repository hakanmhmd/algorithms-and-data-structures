package DesignPatterns.observer;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by hakanmehmed on 05/07/2017.
 */
public abstract class Observable {
    private Set<Observer> observerList;

    public Observable() {
        observerList = new HashSet<Observer>();
    }

    public void addObservable(Observer o){
        observerList.add(o);
    }

    public void removebservable(Observer o){
        observerList.remove(o);
    }

    protected void notifyDependents(){
        for (Observer observer : observerList) {
            observer.update(this);
        }
    }
}
