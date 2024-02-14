import javax.swing.*;
import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

   static Cataloc cataloc = new Cataloc();
    public static void main(String[] args) throws IOException, ClassNotFoundException {

       // Menu.menu()

        menuForCollectionTask();
        frequent();
        sort();
        unic();
    }
    public static void chooseForMenu(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("1-Menuya qayıt   2-Çıxış?");

        int choose = scanner.nextInt();

        if (choose==1){
            menuForCollectionTask();
        }else{
            System.exit(1);
        }
        menuForCollectionTask();
    }

    public static void menuForCollectionTask(){

        System.out.println("1-Kataloq əlavə et");
        System.out.println("2-Kataloq siyahısına bax");
        System.out.println("3-Kataloqu siyahıdan sil");
        System.out.println("4-Kataloq statusa bax");

        Scanner scanner = new Scanner(System.in);

        int sc = scanner.nextInt();

        Book def = new Book();
        switch (sc){
            case 1:
                System.out.println("Müəllif: ");
                String aut = scanner.next();
                System.out.println("Status: ");
                boolean stat = scanner.nextBoolean();
                System.out.println("Isbn: ");
                String isbnn = scanner.next();
                System.out.println("Başlıq: ");
                String title = scanner.next();
                def.setAuthor(aut);
                def.setAvailable(stat);
                def.setIsbn(isbnn);
                def.setTitle(title);

                cataloc.addBook(def);
                chooseForMenu();
                break;
            case 2:
                System.out.println(cataloc.listBooks());
                chooseForMenu();
                break;
            case 3:
                System.out.println("Isbn nömrəsini yazın: ");
                String isbRemove = scanner.next();
                cataloc.removeBook(isbRemove);
                chooseForMenu();
                break;
            case 4:
                System.out.println("1-ChecForout     2-CheckForin");
                int chc = scanner.nextInt();
                if (chc==1){
                    System.out.println("Isbn nömrəsini yazın: ");
                    String isbForStatus1 = scanner.next();
                    cataloc.checkOutBook(isbForStatus1);
                } else if (chc==2) {
                    System.out.println("Isbn nömrəsini yazın: ");
                    String isbForStatus2 = scanner.next();
                    cataloc.checkOutBook(isbForStatus2);
                }
                chooseForMenu();
                break;

        }
    }

    public static void sort(){
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(9);
        arrayList.add(3);
        arrayList.add(8);
        arrayList.add(5);
        arrayList.add(5);

        ArrayList<ArrayList<Integer>> arrayList2 = new ArrayList<>();

        for (int i=0; i<arrayList.size(); i++){
            ArrayList<Integer> child = new ArrayList<>();
            for (int j=i+1; j<arrayList.size(); j++){
                if (arrayList.get(i)==arrayList.get(j)){
                    arrayList.remove(j);
                }
            }
            child.add(arrayList.get(i));

            arrayList2.add(child);
        }

        for (int i = 0; i<arrayList.size(); i++){
            int a = 0;
            for (int j=i+1; j<arrayList.size(); j++){
                if (arrayList.get(i)>arrayList.get(j)){
                    a = arrayList.get(j);
                    arrayList.set(j,arrayList.get(i));
                    arrayList.set(i,a);
                }
            }
        }

        for (Integer arr: arrayList){
            System.out.println(arr);
        }

    }


    public static void frequent(){

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(5);

        ArrayList<ArrayList<Integer>> arrayList2 = new ArrayList<>();

        for (int i=0; i<arrayList.size(); i++){
            int sum = 1;
            ArrayList<Integer> child = new ArrayList<>();
            for (int j=i+1; j<arrayList.size(); j++){
                if (arrayList.get(i)==arrayList.get(j)){
                    sum++;
                    arrayList.remove(j);
                }
            }
            child.add(arrayList.get(i));
            child.add(sum);

            arrayList2.add(child);
        }

        for (ArrayList<Integer> arr: arrayList2){
            System.out.println(arr);
        }

    }

    public static void unic(){

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(5);


        for (int i=0; i<arrayList.size(); i++){
            ArrayList<Integer> child = new ArrayList<>();
            for (int j=i+1; j<arrayList.size(); j++){
                if (arrayList.get(i)==arrayList.get(j)){
                    arrayList.remove(j);
                }
            }

        }

        for (Integer arr: arrayList){
            System.out.println(arr);
        }

    }

}
