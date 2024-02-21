import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collection {

    public void listFindCommonElemets(){

        List<Person> list1 = new ArrayList<>();
        List<Person> list2 = new ArrayList<>();

        list1.add(new Person("Common1", 1));
        list1.add(new Person("Common2", 2));
        list1.add(new Person("Common3", 3));
        list1.add(new Person("Common4", 4));
        list1.add(new Person("Common5", 5));

        list2.add(new Person("Common1", 1));
        list2.add(new Person("Common2", 2));
        list2.add(new Person("CommonList3", 33));
        list2.add(new Person("Common4", 4));
        list2.add(new Person("CommonList5", 55));

        list2.retainAll(list1);

        System.out.println("Common elements: "+list2);

    }
    public void mergeTwoListAndSortThem(){

        List<Person> list1 = new ArrayList<>();
        List<Person> list2 = new ArrayList<>();

        list1.add(new Person("mergeList1_1", 2));
        list1.add(new Person("mergeList1_2", 3));
        list1.add(new Person("mergeList1_3", 1));
        list1.add(new Person("mergeList1_4", 5));
        list1.add(new Person("mergeList1_5", 4));

        list2.add(new Person("mergeList2_1", 6));
        list2.add(new Person("mergeList2_2", 10));
        list2.add(new Person("mergeList2_3", 8));
        list2.add(new Person("mergeList2_4", 7));
        list2.add(new Person("mergeList2_5", 9));

        List<Person> listMerge = new ArrayList<>();

        listMerge.addAll(list1);
        listMerge.addAll(list2);

        System.out.println("list1: "+list1);
        System.out.println("list2: "+list2);
        System.out.println("listMergeWithoutSort: "+listMerge);


        Collections.sort(listMerge, new Person());

        System.out.println("list Merge Aftern from Sort: "+listMerge);

    }
    public void checkListIsPalindrome(){

        List<Person> list = new ArrayList<>();

        list.add(new Person("list1", 1));
        list.add(new Person("list2", 2));
        list.add(new Person("list3", 3));
        list.add(new Person("list2", 2));
        list.add(new Person("list1", 1));

        boolean chcPal = false;

        for (int i=0; i<list.size()/2; i++){
            if (list.get(i).equals(list.get(list.size()-1-i))){
                chcPal = true;
            }else{
                chcPal = false;
                break;
            }
        }

        if (chcPal){
            System.out.println("list is palindrom");
        }else {
            System.out.println("list is not palindrom");
        }
    }

    public void groupingObjectsByPropertys(){
        List<Person> list = new ArrayList<>();

        Person person1 = new Person("Java", 18);
        Person person2 = new Person("C++", 19);
        Person person3 = new Person("Java", 20);
        Person person4 = new Person("C", 21);
        Person person5 = new Person("C#", 22);
        Person person6 = new Person("Java", 23);
        Person person7 = new Person("C#", 24);
        Person person8 = new Person("C++", 25);
        Person person9 = new Person("Javascript", 26);
        Person person10 = new Person("Php", 27);

        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);
        list.add(person6);
        list.add(person7);
        list.add(person8);
        list.add(person9);
        list.add(person10);

        Map<Integer, List<Person>> map = list.stream().collect(Collectors.groupingBy(Person::getAge));

        map.forEach((k,v) -> System.out.println(k+"---"+v));


        // COMPARE TWO OBJECTS WITH EQUALS METOD OVERRIDE
        //System.out.println(person1.equals(person1));
    }
}
