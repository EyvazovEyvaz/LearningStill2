import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Mythreads {

   static Queue<Integer> queue =new PriorityQueue<>();

   Object ob = new Object();
    public class Mythread extends Thread{

        public void run(){
            queue_thread();
        }

        public synchronized void queue_thread(){

            queue.add(6);

            System.out.println(queue);
            int i= queue.poll();
            System.out.println(i);
            System.out.println(queue);

            int chckSize = queue.size();

            System.out.println(chckSize);
            if (chckSize==0){
                try {
                    sleep(10);
                    //wait(); qayitmir bura
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else {
                System.out.println(queue.remove());
            }

            System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
            System.out.println(queue);
            System.out.println(queue.remove());
            //System.out.println(queue.remove());
        }
    }
     class Mythread2 extends Thread{

        public void run(){
            not();
        }

        public synchronized void not(){

            System.out.println("Dəyər daxil et: ");
            queue.add(890);
            System.out.println("dfs");
            notifyAll();
        }
    }
}
