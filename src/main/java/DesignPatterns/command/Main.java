package DesignPatterns.command;


/**
 * Created by hakanmehmed on 05/07/2017.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Sum 1 to 100: " + sum(1, 100, new Function() {
            public int apply(int i) {
                return i;
            }
        }));

        System.out.println("Sum of squares 1 to 10: " + sum(1, 10, new Function() {
            public int apply(int i) {
                return i*i;
            }
        }));
    }

    public static int sum(int lower, int upper, Function f){
        int sum=0;
        for(int i=lower; i<=upper; i++){
            sum += f.apply(i);
        }
        return sum;
    }
}
