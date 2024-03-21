import java.time.*;
import java.time.temporal.ChronoField;
import java.util.*;

public class Main {
    public static void main(String[] args) {


       // Tarix t = new Tarix();

       // t.calculateAge();

        /*Collection collection = new Collection();

        collection.groupingObjectsByPropertys();
        collection.listFindCommonElemets();
        collection.mergeTwoListAndSortThem();
        collection.checkListIsPalindrome();

        Tarix tarix = new Tarix();

        tarix.differenceBetweenTwoDates();
        tarix.countOfDaysUntilTheEndOfTheYear();
        tarix.calculateAge();
        tarix.theNextOccurrenceDateOfTheWeekDay();*/



           /* TestJoinMethod2 t1=new TestJoinMethod2();
            TestJoinMethod2 t2=new TestJoinMethod2();
            TestJoinMethod2 t3=new TestJoinMethod2();

        System.out.println("bir");
            t1.start();
            try{
               //t1.join();
            }catch(Exception e){System.out.println(e);}

        System.out.println("iki");
            t2.start();
            try{//t2.join();
            }catch(Exception e){System.out.println(e);}

        System.out.println("uc");
            t3.start();
            try{
                //t3.join();
            }catch(Exception e){System.out.println(e);}*/





        Table obj1 = new Table();//only one object
        Table obj2 = new Table();
        MyThread1 t21=new MyThread1(obj1);
        MyThread2 t22=new MyThread2(obj2);
        t21.start();
        t22.start();


    }
}
class TestJoinMethod2 extends Thread{
    public synchronized void run(){
            for(int i=1;i<=50;i++){
                try{
                    Thread.sleep(1);
                }catch(Exception e){System.out.println(e);}
                System.out.println(i+" "+Thread.currentThread().getName());
            }
    }
}



class Table{
    synchronized void printTable(int n){//synchronized method
        for(int i=1;i<=5;i++){
            System.out.println(n*i+" "+Thread.currentThread().getName());
            try{
                Thread.sleep(400);
            }catch(Exception e){System.out.println(e);}
        }

    }
}

class MyThread1 extends Thread{
    Table t;
    MyThread1(Table t){
        this.t=t;
    }
    public void run(){
        t.printTable(5);
    }

}
class MyThread2 extends Thread{
    Table t;
    MyThread2(Table t){
        this.t=t;
    }
    public void run(){
        t.printTable(100);
    }
}