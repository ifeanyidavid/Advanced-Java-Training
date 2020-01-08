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
public class ErrorLogger implements Logger{

    @Override
    public void log(String error) {
        System.out.println("There is an error");
    }

}
