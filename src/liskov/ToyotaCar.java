/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liskov;

/**
 *
 * @author dkalu
 */
public class ToyotaCar extends Car implements MotorCar{

    @Override
    public void turnOnEngine() {
        System.out.println("Turning on engine");
    }

    @Override
    void accelerate() {
        System.out.println("Accelerating Toyota");
    }
    
}
