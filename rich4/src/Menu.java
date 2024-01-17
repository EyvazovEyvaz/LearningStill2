import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

    static boolean chSameEmployee = false;
    static boolean chSameClient = false;

    static boolean commonCondition = false;
     public static void menu() throws IOException {

        System.out.println("MENU");
        System.out.println("1-User əlavə et");
        System.out.println("2-User siyahısına bax");
        System.out.println("3-Account siyahısına bax");
        System.out.println("4-Transaksiya");
        System.out.println("5-Sistemdən çıxış");

        Scanner sc = new Scanner(System.in);

        int result = sc.nextInt();

        switch (result) {
            case 1 -> userAdd();
            case 2 -> viewUserList();
            case 3 -> viewAccountList();
            case 4 -> transAction();
            case 5 -> {
                System.exit(0);
                System.out.println("logged out...");
            }
            default -> {
                System.out.println("Belə secim yoxdur yenidən");
                iterateMenuchoose1();
            }
        }

    }

    public static void userAdd() throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("a-Client             b-Employee");
        String useradd = sc.nextLine();

        if (useradd.equals("a")){
            userAddClient();
        } else if (useradd.equals("b")) {
            userAddEmployee();
        }

    }

    public static void userAddEmployee() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Code ADD: ");
        int c = sc.nextInt();
        System.out.println("Id ADD: ");
        int id = sc.nextInt();
        System.out.println("User name ADD: ");
        String nam = sc.next();
        System.out.println("Salary ADD: ");
        double salary = sc.nextDouble();
        System.out.println("Profession ADD: ");
        String prof = sc.next();

        User example = new User(c, id,nam , salary, prof);

        example.setEmployeerUserToList(example);

        System.out.println("Employee User created and added to list");
        System.out.println("[][][][][][][][][][][][[][][][][][][][][]");
        System.out.println();
        System.out.println("    Add a account for User employee: ");
        System.out.println("account number (only greater than 0 and minimum 6 maximum 10 digits): ");
        int ac = sc.nextInt();
        System.out.println("balance: ");
        double bl = sc.nextDouble();
        example.addAccount(id,ac,example,bl, Accountstatus.OPEN);

        iterateMenuchoose();
    }
    public static void userAddClient() throws IOException {

        User user = new User();

        Scanner sc = new Scanner(System.in);

        System.out.println("Client Code ADD: ");
        int c = sc.nextInt();
        System.out.println("Client Id ADD: ");
        int id = sc.nextInt();
        System.out.println("Client User name ADD: ");
        String nam = sc.next();

        user.setClientVariablesToFile(c,id,nam);

        System.out.println("Client User created added in files and added to list");
        System.out.println("[][][][][][][][][][][][[][][][][][][][][]");
        System.out.println();
        System.out.println("    Add a account for User client: ");
        System.out.println("account number: ");
        int ac = sc.nextInt();
        System.out.println("balance: ");
        double bl = sc.nextDouble();
        user.addAccount(id,ac,user,bl, Accountstatus.OPEN);

        iterateMenuchoose();

    }

    public static void viewUserList() throws IOException {
        User u = new User();
        Scanner sc = new Scanner(System.in);

        System.out.println("1- view all user list      2- view Client user list        3- view Employee user list");
        int d = sc.nextInt();

        switch (d){
            case 1:
                u.getClientsUserListFromFile();
                u.getEmployeerUserList();
                break;
            case 2:
                u.getClientsUserListFromFile();
            case 3:
                u.getEmployeerUserList();
        }

        iterateMenuchoose1();

    }
    public static void viewAccountList() throws IOException {
        Account.getAccountList();
        iterateMenuchoose1();
    }

    public static void iterateMenuchoose1() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("return to menu");
        System.out.println("1-Yes return to menu             2-No log out");
        int res = sc.nextInt();
        if (res==1){
            System.out.println();
            menu();
        } else if (res==2) {
            System.out.println();
            System.exit(1);
        }
    }

    public static void iterateMenuchoose() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("add one more?");
        System.out.println("1-YES           2-NO return to menu             3-log out");
        int res = sc.nextInt();
        if (res==1){
            System.out.println();
            userAdd();
        } else if (res==2) {
            System.out.println();
            menu();
        } else{
            System.exit(1);
        }
    }

    public static void transAction() throws IOException {
        Account.getAccountList();
        Scanner sc = new Scanner(System.in);

        System.out.println("enter any User account from which you want to withdraw the amount : ");
        int t1wiz = sc.nextInt();
        System.out.println("enter any User account to which you want to transfer the amount: ");
        int t2trn = sc.nextInt();
        System.out.println("Enter the amount you want to transfer: ");
        double mount = sc.nextDouble();

        if (checkContainsInsertaccountForEmp1(t1wiz) !=null && checkContainsInsertaccountForEmp2(t2trn) !=null){
            // same employee between
            chSameEmployee = true;
            Transaction transaction = new Transaction(checkContainsInsertaccountForEmp1(t1wiz),checkContainsInsertaccountForEmp2(t2trn),mount);
             transaction.transfer();
        } else if (checkContainsInsertaccountForClnt1(t1wiz) !=null && checkContainsInsertaccountForClnt2(t2trn) !=null) {
            chSameClient = true;
            // same client between
            Transaction transaction = new Transaction(checkContainsInsertaccountForClnt1(t1wiz),checkContainsInsertaccountForClnt2(t2trn),mount);
            transaction.transfer();
        } else if (checkContainsInsertaccountForEmp1(t1wiz)!=null && checkContainsInsertaccountForClnt2(t2trn) !=null) {
            commonCondition = true;
            Transaction transaction = new Transaction(checkContainsInsertaccountForEmp1(t1wiz),checkContainsInsertaccountForClnt2(t2trn),mount);
            transaction.transfer();
        } else if (checkContainsInsertaccountForEmp2(t2trn)!=null && checkContainsInsertaccountForClnt1(t1wiz) !=null) {
            commonCondition = true;
            Transaction transaction = new Transaction(checkContainsInsertaccountForClnt1(t1wiz),checkContainsInsertaccountForEmp2(t2trn),mount);
            transaction.transfer();

        }else{////////////////
            System.out.println("wrong account");
        }


        iterateMenuchoose1();
    }

    public static Account checkContainsInsertaccountForEmp1(int ac1){

        Account em1 = null;
        for (Account accemp: User.employeerAccountlist1) {
            if (accemp !=null){
                if (accemp.getAccount()==ac1){
                    em1 = accemp;
                }
            }
        }

        return em1;
    }
    public static Account checkContainsInsertaccountForEmp2(int ac2){

        Account em2 = null;
        for (Account accemp: User.employeerAccountlist1) {
            if (accemp !=null){
                if (accemp.getAccount()==ac2){
                    em2 = accemp;
                }
            }
        }

        return em2;
    }
    public static Account checkContainsInsertaccountForClnt1(int ac1){

        Account cl1 = null;
        for (Account clnt1: User.ClientAccountlist1) {
            if (clnt1 !=null){
                if (clnt1.getAccount()==ac1){
                    cl1 = clnt1;
                }
            }
        }

        return cl1;
    }
    public static Account checkContainsInsertaccountForClnt2(int ac2){

        Account cl2 = null;
        for (Account clnt2: User.ClientAccountlist1) {
            if (clnt2 !=null){
                if (clnt2.getAccount()==ac2){
                    cl2 = clnt2;
                }
            }
        }

        return cl2;
    }
}
