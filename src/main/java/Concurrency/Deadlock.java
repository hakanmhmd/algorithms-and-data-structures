package Concurrency;

/**
 * Created by hakanmehmed on 05/08/2018.
 */
public class Deadlock {
    static class A {
        private final Object key1 = new Object();
        private final Object key2 = new Object();

        public void a() {
            synchronized (key1) {

                System.out.println(Thread.currentThread().getName() + " in a()");
                b();
            }
        }

        public void b() {
            synchronized (key2) {

                System.out.println(Thread.currentThread().getName() + " in b()");
                c();
            }
        }

        public void c(){
            synchronized (key1){
                System.out.println(Thread.currentThread().getName() + " in c()");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        Runnable r1 = () -> a.a();
        Runnable r2 = () -> a.b();

        Thread t = new Thread(r1);
        Thread t2 = new Thread(r2);
        t.start();
        t2.start();
        t.join();
        t2.join();
    }
}
