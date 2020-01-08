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
public class GmailSmtpStrategy implements ISmtpStrategy{

    @Override
    public void sendMail(String subject, String message) {
        System.out.println("Sending mail with Gmail  with subject: "+subject+" Message: "+message);
    }
    
}
