// Problem Statement:
// Producer–Consumer Problem Synchronization and Inter-thread Communication
import java.util.Random;

class SharedBuffer {
    private int data;
    private boolean available = false;

    public synchronized void produce(int value) {
        while (available) {
            try { wait(); } catch (Exception e) {}
        }

        data = value;
        System.out.println("Produced: " + data);
        available = true;

        notify();
    }

    public synchronized int consume() {
        while (!available) {
            try { wait(); } catch (Exception e) {}
        }

        System.out.println("Consumed: " + data);
        available = false;

        notify();
        return data;
    }
}

class Producer extends Thread {
    SharedBuffer buffer;
    Random r = new Random();

    Producer(SharedBuffer b) {
        buffer = b;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            int value = r.nextInt(100);   // RANDOM number (0–99)
            buffer.produce(value);

            try { sleep(500); } catch (Exception e) {}
        }
    }
}

class Consumer extends Thread {
    SharedBuffer buffer;

    Consumer(SharedBuffer b) {
        buffer = b;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.consume();

            try { sleep(800); } catch (Exception e) {}
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        new Producer(buffer).start();
        new Consumer(buffer).start();
    }
}
