import java.io.*;
import java.util.Scanner;

public class User extends Employeer implements Client{
   static Employeer[] userEmployeerList = new Employeer[1];
   static File[] arrClientVariableFiles1 = new File[1];
   static int sum = 0;

   static Account[] employeerAccountlist1 = new Account[1];
   static Account[] ClientAccountlist1 = new Account[1];

    int idEmp;
    int idClient;
    public User(int code, int id, String name, double salary, String profession) {
        super.setCode(code);
        super.setId(id);
        super.setName(name);
        super.setSalary(salary);
        super.setProfession(profession);
        this.idEmp = id;
    }
    public User(){

    }

    @Override
    public void setEmployeerUserToList(Employeer addAccounEmployeertToList) {

        Employeer[] accounEmployertList2 = new Employeer[userEmployeerList.length+1];

        for (int i=0; i<userEmployeerList.length; i++){
            accounEmployertList2[i]=userEmployeerList[i];
        }
        userEmployeerList = accounEmployertList2;

        if (!checkSameUserEmployeers(addAccounEmployeertToList) && !checkNullUserEmployeers(addAccounEmployeertToList)){
            userEmployeerList[userEmployeerList.length-1] = addAccounEmployeertToList;
            System.out.println("USER_Employeer--successfully added...");
        }else if (checkSameUserEmployeers(addAccounEmployeertToList)){
            System.out.println("already exist USER_Employeer ID or Code account!");
        } else if (checkNullUserEmployeers(addAccounEmployeertToList)){
            System.out.println("USER_Employeer can't be null");
        }
    }

    @Override
    public void getEmployeerUserList() {
        int sumIndexEmp = 0;
        for (Employeer emp: userEmployeerList) {
            if (emp !=null){
                sumIndexEmp++;
                System.out.println("       EMPLOYEER: "+sumIndexEmp);
                System.out.println("USER_Employeer CODE: "+emp.getCode());
                System.out.println("USER_Employeer NAME: "+emp.getName());
                System.out.println("USER_Employeer ID: "+emp.getId());
                System.out.println("USER_Employeer PROFESSION"+emp.getProfession());
                System.out.println("USER_Employeer SALARY"+emp.getSalary());

                System.out.println("---------------------------------------");
            }
        }
    }

    @Override
    public boolean checkSameUserEmployeers(Employeer addAccountToList){

        for (Employeer emp: userEmployeerList) {
            if (emp !=null){
                if (emp.getId() !=0 && emp.getCode() !=0 || emp.getName() !=null || emp.getProfession() !=null ||
                   emp.getSalary() !=0){
                    if (emp.getCode()==addAccountToList.getCode()){
                        return true;
                    } else if (emp.getId()==addAccountToList.getId()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean checkNullUserEmployeers(Employeer addAccountToList) {
        if (addAccountToList.getId()==0 || addAccountToList.getCode()==0 || addAccountToList.getSalary()==0 ||
            addAccountToList.getName()==null || addAccountToList.getProfession()==null){
            return true;
        }
        return false;
    }

    @Override
    public void setClientVariablesToFile(int clientCode, int clientId, String clientName) throws IOException {
        idClient = clientId;
        String str1 = String.valueOf(clientCode);
        String str2 = String.valueOf(clientId);
        ++sum;
        if (sum==1 || ! checkSameUserClientsInFile(str2)){
            File[] arrClientVariableFiles2 = new File[arrClientVariableFiles1.length+1];

            for (int i=0; i<arrClientVariableFiles1.length; i++){
                arrClientVariableFiles2[i]=arrClientVariableFiles1[i];
            }
            arrClientVariableFiles1 = arrClientVariableFiles2;

            File filee = new File("C:\\Users\\eyvaz\\OneDrive\\Desktop\\Projects\\LearningStill\\rich4\\clientfilesdirectory","clientsFileList"+sum+".txt");
            FileWriter file = new FileWriter(filee);
            BufferedWriter bufferedWriter = new BufferedWriter(file);

            bufferedWriter.write("CCode "+str1+"\n");
            bufferedWriter.write("CCid "+str2+"\n");
            bufferedWriter.write("CCname "+clientName);
            bufferedWriter.close();

            arrClientVariableFiles1[arrClientVariableFiles1.length-1] = filee;
            System.out.println("USER_Client added successfully.");
        }else {
            System.out.println("already exist USER_Client ID!");
        }

    }
    @Override
    public void getClientsUserListFromFile() throws FileNotFoundException {

        for (int i=0; i< arrClientVariableFiles1.length; i++){
            if (arrClientVariableFiles1[i] !=null){
                System.out.println("       CLIENT: "+(i));
                Scanner read = new Scanner(arrClientVariableFiles1[i]);
                while (read.hasNextLine()){
                    System.out.println(read.nextLine());
                }
                System.out.println("---------------------------------------");
            }
        }
    }

    @Override
    public boolean checkSameUserClientsInFile(String strcheckID) throws FileNotFoundException {


        for (int i=0; i< arrClientVariableFiles1.length; i++){
            if (arrClientVariableFiles1[i] !=null){
                Scanner read = new Scanner(arrClientVariableFiles1[i]);
                while (read.hasNextLine()){
                    String strVariables = read.nextLine();
                    if (strVariables.contains(strcheckID)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public void addAccount(int id, int account, User obj, double balance, Accountstatus accountstatus){

        if (id == obj.idEmp){
            Account acc = new Account(id,account, obj, balance, Accountstatus.OPEN);

            Account[] empoyeerAccountList2 = new Account[employeerAccountlist1.length+1];

            for (int i=0; i<employeerAccountlist1.length; i++){
                empoyeerAccountList2[i]=employeerAccountlist1[i];
            }
            employeerAccountlist1 = empoyeerAccountList2;

            employeerAccountlist1[employeerAccountlist1.length-1] = acc;
            System.out.println("ACCOUNT added for EMPLOYEER User");
        }else if (id == obj.idClient){
            Account acc = new Account(id,account, obj, balance,Accountstatus.OPEN);

            Account[] ClientAccountlist2 = new Account[ClientAccountlist1.length+1];

            for (int i=0; i<ClientAccountlist1.length; i++){
                ClientAccountlist2[i]=ClientAccountlist1[i];
            }
            ClientAccountlist1 = ClientAccountlist2;

            ClientAccountlist1[ClientAccountlist1.length-1] = acc;
            System.out.println("ACCOUNT added for CLIENT User");
        }else{
            System.out.println("This Id don't match with any User! browse the list");
        }
    }


}