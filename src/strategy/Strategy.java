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
public class Strategy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Context context1 = new Context(new StrategyA());
        context1.executeStrategy();
        Context context2 = new Context(new StrategyB());
        context2.executeStrategy();
    }
    
}
