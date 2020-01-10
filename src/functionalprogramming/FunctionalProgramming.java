/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionalprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        accounts.stream().filter((account) -> account.isDormant()).forEach(System.out::println);

        System.out.println("\nNon-Dormant Accounts \n");

        accounts.stream().filter((account) -> !account.isDormant()).forEach(System.out::println);
    }

    static List<Account> generateAccounts() {
        List<Account> accounts = new ArrayList<>();

        Account a = new Account();
        a.setAccountName("David Kalu_");
        a.setAccountNum("327306524");

//        List<Account> aList = IntStream.range(0, 100).mapToObj((index) -> {
//            
//            a.setAccountName(a.getAccountName() + index);
//            a.setAccountNum(a.getAccountNum() + index);
//            
//            if (index % 2 == 0) {
//                a.setDormant(true);
//            } else {
//                a.setDormant(false);
//            }
//            
//            return a;
//        }).collect(Collectors.toList());
//        
//        return aList;
//        System.out.println("A List: " + aList);
        for (int i = 0; i <= 100; i++) {
            Account account = new Account();
            account.setAccountName("David Kalu_" + i);
            account.setAccountNum("327306524" + i);

            if (i % 2 == 0) {
                account.setDormant(true);
            } else {
                account.setDormant(false);
            }
            accounts.add(account);
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

    @Override
    public String toString() {
        return "Account Name = " + accountName + ", Account Number = " + accountNum + ", Dormant status = " + dormant + "\n";
    }

}
