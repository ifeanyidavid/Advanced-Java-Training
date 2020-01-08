/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assessment;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author dkalu
 */
public class ProducerConsumer2 {

    public static void main(String[] args) {
        System.out.println("Starting ...");
        long start = System.currentTimeMillis();

        Data data = new Data();
        Thread producerThread = new Thread(new Producer(data));
        Thread consumerThread = new Thread(new Consumer(data));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(ProducerConsumer2.class.getName()).log(Level.SEVERE, null, ex);
        }

        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start));
    }
}

class Data {

//    private List<Integer> tableB = new ArrayList<>();
    private String data;

    // True if receiver should wait
    // False if sender should wait
    private boolean transfer = true;

    public synchronized void produce(String data) {
        while (!transfer) {
            try {
//                System.out.println("Send: Don't send yet, consumer is still busy");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        transfer = false;

        this.data = data;
        notifyAll();
    }

    public synchronized String consume() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        transfer = true;

        notifyAll();
        return data;
    }
}

class Consumer implements Runnable {

    private Data payload;

    // standard constructors
    public Consumer() {
    }

    public Consumer(Data payload) {
        this.payload = payload;
    }

    public void run() {
        for (int i = 0; i <= 1000000; i++) {

            System.out.println("Consuming "+ payload.consume());

            // ...
//            try {
//                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                e.printStackTrace();
//            }
        }
    }
}

class Producer implements Runnable {

    private Data data;

    // standard constructors
    public Producer() {
    }

    public Producer(Data data) {
        this.data = data;
    }

    public void run() {
        List<String> tableA = new ArrayList<>();

        for (int i = 0; i <= 1000000; i++) {
            tableA.add("Data" + i);
            data.produce("Data " + i);

//            try {
//                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                e.printStackTrace();
//            }
        }
    }
}
