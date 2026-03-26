//Problem Statement:
//Find Prime Numbers using Multithreading
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrimeTask implements Runnable {
    int start, end;

    public PrimeTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    private boolean isPrime(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " checking range " + start + " to " + end);

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.println(threadName + " found prime: " + i);
            }
        }

        System.out.println(threadName + " finished.");
    }
}

public class PrimeThreadDemo {
    public static void main(String[] args) {

        System.out.println("=== Prime Number Finder using Multithreading ===");

        // Method 1: Threads
        Thread t1 = new Thread(new PrimeTask(1, 10), "Thread-1");
        Thread t2 = new Thread(new PrimeTask(11, 20), "Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        // Method 2: Executor
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(new PrimeTask(51, 60));
        executor.execute(new PrimeTask(61, 70));

        executor.shutdown();
    }
}
