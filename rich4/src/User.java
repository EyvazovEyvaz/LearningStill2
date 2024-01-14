import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class User extends Employeer implements Client{
   static Employeer[] accountEmployeerList = new Employeer[1];
    static int sum = 0;
    public User(int code, int id, String name, double salary, String profession) {
        super.setCode(code);
        super.setId(id);
        super.setName(name);
        super.setSalary(salary);
        super.setProfession(profession);
    }
    public User(){

    }

    @Override
    public void setEmployeerAccountToList(Employeer addAccounEmployeertToList) {
        Employeer[] accounEmployertList2 = new Employeer[accountEmployeerList.length+1];

        for (int i=0; i<accountEmployeerList.length; i++){
            accounEmployertList2[i]=accountEmployeerList[i];
        }
        accountEmployeerList = accounEmployertList2;

        if (!checkSameUserEmployeerAccounts(addAccounEmployeertToList) && !checkNullUserEmployeerAccounts(addAccounEmployeertToList)){
            accountEmployeerList[accountEmployeerList.length-1] = addAccounEmployeertToList;
            System.out.println("USER_Employeer--successfully added...");
        }else if (checkSameUserEmployeerAccounts(addAccounEmployeertToList)){
            System.out.println("already exist USER_Employeer ID or Code account!");
        } else if (checkNullUserEmployeerAccounts(addAccounEmployeertToList)){
            System.out.println("USER_Employeer can't be null");
        }
    }

    @Override
    public void getEmployeerAccountList() {
        for (Employeer emp: accountEmployeerList) {
            if (emp !=null){
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
    public boolean checkSameUserEmployeerAccounts(Employeer addAccountToList){

        for (Employeer emp: accountEmployeerList) {
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
    public boolean checkNullUserEmployeerAccounts(Employeer addAccountToList) {
        if (addAccountToList.getId()==0 || addAccountToList.getCode()==0 || addAccountToList.getSalary()==0 ||
            addAccountToList.getName()==null || addAccountToList.getProfession()==null){
            return true;
        }
        return false;
    }

    @Override
    public void setClientVariablesToFile(int clientCode, int clientId, String clientName) throws IOException {

        ++sum;
        File filee = new File("C:\\Users\\eyvaz\\OneDrive\\Desktop\\Projects\\LearningStill\\rich4\\clientfilesdirectory","clientsFileList"+sum+".txt");
        FileWriter file = new FileWriter(filee);
        BufferedWriter bufferedWriter = new BufferedWriter(file);

        String str1 = String.valueOf(clientCode);
        String str2 = String.valueOf(clientId);
        bufferedWriter.write("CCode "+str1+"\n");
        bufferedWriter.write("CCid "+str2+"\n");
        bufferedWriter.write("CCname "+clientName);
        bufferedWriter.close();
    }
    @Override
    public void getClientsAccountListFromFile() {


    }

    @Override
    public boolean checkSameUserClientsAccountsInFile() {
        return false;
    }
}