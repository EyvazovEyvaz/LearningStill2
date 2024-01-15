import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // createEmployeer users
        User user1 = new User(2878, 13453000, "User1", 4000, "programming");
        User user2 = new User(2879, 13454000, "User2", 5000, "programming");
        User user3 = new User(2880, 13455000, "User3", 6000, "programming");
        User user4 = new User(2881, 13456000, "User4", 7000, "programming");

        // addEmployeersUsersToList
        user1.setEmployeerUserToList(user1);
        user2.setEmployeerUserToList(user2);
        user3.setEmployeerUserToList(user3);
        user4.setEmployeerUserToList(user4);

        // getEmployeerUsersfromList
        user1.getEmployeerUserList();

        // Add an account for any Employeeruser
        user4.addAccount(13456000,3434,user4, 445.00);

        // create ClientUsers and fill variables withSetMetod
        User us = new User();
        us.setClientVariablesToFile(1,11,"EYVAZ");
        User us1 = new User();
        us1.setClientVariablesToFile(2,22,"EYVAZ");
        User us2 = new User();
        us2.setClientVariablesToFile(3,33,"EYVAZ");
        User us3 = new User();
        us3.setClientVariablesToFile(3,33,"EYVAZ");
        User us4 = new User();
        us4.setClientVariablesToFile(3,33,"EYVAZ");
        User us5 = new User();
        us5.setClientVariablesToFile(4,44,"EYVAZ");

        // get Clients Users List From created Files
        us.getClientsUserListFromFile();

        // Add an account for any Clientuser
        us5.addAccount(44,3434,us5, 4455.00);

        // View all Client and employee accounts
        Account.getAccountList();

    }

    public enum Test {
        OPEN,
        CLOSE,
        TEMPORARY;
    }


}
