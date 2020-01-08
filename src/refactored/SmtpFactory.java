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
public class SmtpFactory {
    public ISmtpStrategy getSmtpType(String smtpType){
        if(smtpType == null){
            return null;
        }
        if(smtpType.equalsIgnoreCase("gmail")){
            return new GmailSmtpStrategy();
        }else if(smtpType.equalsIgnoreCase("outlook")){
            return new OutlookSmtpStrategy();
        }
        return null;
    }
}
