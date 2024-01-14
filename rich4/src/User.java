
public class User extends Employeer{


   static Employeer[] accountList = new Employeer[1];

    public User(int code, int id, String name, double salary, String profession) {
        super.setCode(code);
        super.setId(id);
        super.setName(name);
        super.setSalary(salary);
        super.setProfession(profession);
    }

    public static void getAccountList() {

        for (Employeer emp: accountList) {
            if (emp !=null){
                System.out.println("USER CODE: "+emp.getCode());
                System.out.println("USER NAME: "+emp.getName());
                System.out.println("USER ID: "+emp.getId());
                System.out.println("USER PROFESSION"+emp.getProfession());
                System.out.println("USER SALARY"+emp.getSalary());

                System.out.println("---------------------------------------");
            }
        }
    }
    public void setAccountToList(Employeer addAccountToList) {


        Employeer[] accountList2 = new Employeer[accountList.length+1];

        for (int i=0; i<accountList.length; i++){
            accountList2[i]=accountList[i];
        }
        accountList = accountList2;

        if (checkSameUserAccounts(addAccountToList)){
            System.out.println("already exist User ID or Code account!");
        }else{
            accountList[accountList.length-1] = addAccountToList;
            System.out.println("User--successfully added...");
        }

    }

    public boolean checkSameUserAccounts(Employeer addAccountToList){

        for (Employeer emp: accountList) {
            if (emp !=null){
               if (emp.getCode()==addAccountToList.getCode()){
                   return true;
               } else if (emp.getId()==addAccountToList.getId()) {
                   return true;
               }
            }
        }
        return false;
    }
}