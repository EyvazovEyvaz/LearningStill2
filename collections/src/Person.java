import java.util.Comparator;

public class Person implements Comparator<Person>{

    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Person(){

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int compare(Person o1, Person o2) {

        return Integer.compare(o1.getAge(), o2.getAge());
    }

    @Override
    public boolean equals(Object obj) {


        if (this == obj){
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }

        Person per = (Person) obj;
        return this.name.equals(per.name)
                && this.age == per.age;
    }
}
