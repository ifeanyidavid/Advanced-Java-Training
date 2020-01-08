/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactored;

/**
 *
 * @author dkalu
 */
class ReversePrintThread implements Runnable{
    @Override
    public void run() {
        for(int i=20; i>0; i--){
            System.out.println("Number: "+i+" "+Thread.currentThread().getName());
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ReversePrintThreadRunnable{
    public static void main(String[] args) {
        Thread thread0 = new Thread(new ReversePrintThread());
        thread0.start();
        Thread thread1 = new Thread(new ReversePrintThread());
        thread1.start();
        Thread thread2 = new Thread(new ReversePrintThread());
        thread2.start();
    }
}