public class Main {
    public static void main(String[] args) {

        User user1 = new User(2878, 13453000, "User1", 4000, "programming");
        User user2 = new User(2879, 13454000, "User2", 5000, "programming"); //same users
        User user3 = new User(2879, 13455000, "User3", 6000, "programming");  // with this
        User user4 = new User(2881, 13456000, "User4", 7000, "programming");

        user1.setAccountToList(user1);
        user1.setAccountToList(user2);
        user1.setAccountToList(user3);
        user1.setAccountToList(user4);

        User.getAccountList();

    }
}