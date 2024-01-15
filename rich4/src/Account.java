public class Account {

    int id;
    int account;
    User obj;
    double balance;

    public Account(int id, int account, User obj, double balance){
        this.id = id;
        this.account = account;
        this.obj = obj;
        this.balance = balance;
    }

    public int getAccount() {
        return account;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getObj() {
        return obj;
    }

    public int getId() {
        return id;
    }

    public static void getAccountList(){

        System.out.println("                EMPLOYEERS ACCOUNTS");
        for (Account accemp: User.employeerAccountlist1) {
            if (accemp !=null){
                System.out.println("        ACCOUNTS "+accemp.getId());
                System.out.println("USER_Employeer_Account ID: "+accemp.getId());
                System.out.println("USER_Employeer_Account account: "+accemp.getAccount());
                System.out.println("USER_Employeer_Account User: "+accemp.getObj());
                System.out.println("USER_Employeer_Account balance"+accemp.getBalance());
                System.out.println("---------------------------------------");
            }
        }

        System.out.println("                CLIENTS ACCOUNTS");
        for (Account accclnt: User.ClientAccountlist1) {
            if (accclnt !=null){
                System.out.println("        ACCOUNTS "+accclnt.getId());
                System.out.println("USER_Client_Account ID: "+accclnt.getId());
                System.out.println("USER_Client_Account account: "+accclnt.getAccount());
                System.out.println("USER_Client_Account User: "+accclnt.getObj());
                System.out.println("USER_Client_Account balance"+accclnt.getBalance());
                System.out.println("---------------------------------------");
            }
        }
    }
}
