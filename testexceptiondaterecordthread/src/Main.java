import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        /*try {
            Myfile.testfile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }*/


        //Findspecificwordfromfile.find_specific_words();

        /*Book book = new Book("space","unknown",9094445, "19-10-2020");
        System.out.println(book);*/

        Mythreads mythreads = new Mythreads();
        Mythreads.Mythread mythread = mythreads.new Mythread();
        mythread.start();
        /*try {
            mythread.start();
            mythread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        Mythreads.Mythread2 mythread2 =mythreads.new Mythread2();
        mythread2.start();

        Mydate mydate = new Mydate();

        mydate.differ_inbetween_dates();
        mydate.parseStringToDate();


    }
}