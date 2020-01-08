/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactored;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author dkalu
 */
public class FibonacciForkPool extends RecursiveTask<Integer>{

    final int n;
    
    public FibonacciForkPool(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if(n<=1) return n;
        
        FibonacciForkPool f1 = new FibonacciForkPool(n-1);
        f1.fork();
        FibonacciForkPool f2 = new FibonacciForkPool(n-1);
        f2.fork();
        return f2.join() + f2.join();
    }
    
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        FibonacciForkPool fibonacciRecursiveAction = new FibonacciForkPool(2);
        int result = forkJoinPool.invoke(fibonacciRecursiveAction);
        System.out.println("Result: "+result);
    }
}
