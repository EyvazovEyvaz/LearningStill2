import java.io.FileNotFoundException;
import java.io.IOException;

public interface Client {

     void setClientVariablesToFile(int clientCode, int clientId, String clientName) throws IOException;
     void getClientsUserListFromFile() throws FileNotFoundException;
     boolean checkSameUserClientsInFile(String strcheckID) throws FileNotFoundException;


}
