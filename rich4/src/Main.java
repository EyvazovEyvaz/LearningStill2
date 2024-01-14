import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        User user1 = new User(2878, 13453000, "User1", 4000, "programming");
        User user2 = new User(2879, 13454000, "User2", 5000, "programming"); //same users
        User user3 = new User(2880, 13455000, "User3", 6000, "programming");  // with this
        User user4 = new User(2881, 13456000, "User4", 7000, "programming");

        user1.setEmployeerAccountToList(user1);
        user1.setEmployeerAccountToList(user2);
        user1.setEmployeerAccountToList(user3);
        user1.setEmployeerAccountToList(user4);

        user1.getEmployeerAccountList();


        User user = new User();
        user.setClientVariablesToFile(1,11,"EYVAZ");
        user.setClientVariablesToFile(2,22,"EYVAZ");
        user.setClientVariablesToFile(3,33,"EYVAZ");

    }

    public enum Test {
        OPEN,
        CLOSE,
        TEMPORARY;
    }


}
