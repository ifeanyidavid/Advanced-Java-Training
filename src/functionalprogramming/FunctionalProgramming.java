/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionalprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author dkalu
 */
public class FunctionalProgramming {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        List<Account> accounts = generateAccounts();

        System.out.println("Dormant Accounts \n");

        accounts.stream().filter((account) -> account.isDormant()).forEach(dormAccount -> {
            System.out.println("Account name " + dormAccount.getAccountName());
            System.out.println("Account number " + dormAccount.getAccountNum());
            System.out.println("Dormant status " + dormAccount.isDormant());
            System.out.println("============");
        });
        
        System.out.println("\n Non-Dormant Accounts \n");
        
        accounts.stream().filter((account) -> !account.isDormant()).forEach(dormAccount -> {
            System.out.println("Account name " + dormAccount.getAccountName());
            System.out.println("Account number " + dormAccount.getAccountNum());
            System.out.println("Dormant status " + dormAccount.isDormant());
            System.out.println("============");
        });
    }

    static List<Account> generateAccounts() {
        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Account newAccount = new Account();
            newAccount.setAccountName("David Kalu_" + i);
            newAccount.setAccountNum("327306524" + i);

            if (i % 2 == 0) {
                newAccount.setDormant(true);
            } else {
                newAccount.setDormant(false);
            }
            accounts.add(newAccount);
        }

        return accounts;
    }
}

class Account {

    private String accountName;
    private String accountNum;
    private boolean dormant;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public boolean isDormant() {
        return dormant;
    }

    public void setDormant(boolean dormant) {
        this.dormant = dormant;
    }

}
