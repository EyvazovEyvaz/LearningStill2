public abstract class Employeer {

    private int id;
    private int code;
    private String name;
    private String profession;
    private double salary;

    public abstract void setEmployeerUserToList(Employeer addAccountToList);
    public abstract boolean checkNullUserEmployeers(Employeer addAccountToList);
    public abstract void getEmployeerUserList();
    public abstract boolean checkSameUserEmployeers(Employeer addAccountToList);

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
