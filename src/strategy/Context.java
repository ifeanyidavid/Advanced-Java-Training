/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

/**
 *
 * @author dkalu
 */
public class Context {
    private IStrategy iStrategy;
    
    public Context(IStrategy iStrategy){
        this.iStrategy = iStrategy;
    }
    
    public void executeStrategy(){
        this.iStrategy.doSomething();
    }
}
