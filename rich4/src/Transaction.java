import java.io.IOException;

public class Transaction {

    Account account1;
    Account account2;
     double amount;
    public Transaction(Account account1, Account account2, double amount){
        this.account1 = account1;
        this.account2 = account2;
        this.amount = amount;
    }
    public static double calculateCommission(){
         double percentCommision = 0;
        if (Menu.chSameEmployee){
            percentCommision = 0.5;
        } else if (Menu.chSameClient) {
            percentCommision = 1.5;
        } else if (Menu.commonCondition) {
            percentCommision = 2;
        }
        return percentCommision;
    }
    public boolean checkLegalTransfer(){
        return account1.getBalance() >= amount + amount * calculateCommission() / 100 && account1.accountstatus == Accountstatus.OPEN;
    }
    public void transfer() throws IOException {
        if (checkLegalTransfer()){
            account1.setBalance(account1.getBalance()-amount+amount * calculateCommission()/ 100);
            account2.setBalance(account2.getBalance()+amount);
            System.out.println("the amount has been successfully added to the account number... "+account2.getAccount());
        }else{
            System.out.println("the balance amount is low or the account status is closed!");
        }
    }

}
