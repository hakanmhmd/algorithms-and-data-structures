public class FibbonacciSequence {
    public static void main(String[] args) {
        System.out.println(fibbonacci(6));
    }

    static long fibbonacci(long n){
        if(n <= 1){
            return n;
        }
        return fibbonacci(n-1) + fibbonacci(n-2);
    }
}
