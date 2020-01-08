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
public class OutlookSmtpStrategy implements ISmtpStrategy{

    @Override
    public void sendMail(String subject, String message) {
        System.out.println("Sending mail with Outlook  with subject: "+subject+" Message: "+message);
    }
    
}
