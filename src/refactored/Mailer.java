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
public class Mailer {
    public static void main(String[] args) {
        String smtpTypeFromProperties = "outlook";
        
        SmtpContext context1 = new SmtpContext(new SmtpFactory().getSmtpType(smtpTypeFromProperties));
        context1.executeStrategy("Subject 1","New message");
    }
}
