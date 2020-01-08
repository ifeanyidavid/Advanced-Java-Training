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
public class TeslaCar extends Car implements ElectricCar{

    @Override
    public void turnOnBattery() {
        System.out.println("Turning on battery");
    }

    @Override
    void accelerate() {
        System.out.println("Accelerating Tesla");
    }
    
}
