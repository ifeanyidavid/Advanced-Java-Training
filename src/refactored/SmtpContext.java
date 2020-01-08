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
public class SmtpContext {
    private ISmtpStrategy iSmtpStrategy;
    
    public SmtpContext(ISmtpStrategy iSmtpStrategy){
        this.iSmtpStrategy = iSmtpStrategy;
    }
    
    public void executeStrategy(String subject, String message){
        this.iSmtpStrategy.sendMail(subject, message);
    }
}
