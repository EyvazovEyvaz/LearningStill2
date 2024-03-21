import java.util.ArrayList;
import java.util.function.Function;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {


        Integer[] arr1 = {7,2,6,4,5,3,0,5,7,2,4};
        /*double[] arr2 = {1,2,3,4,5};
        String[] arr3 = {"1","2","3","4","5"};

        System.out.println(arr2[2]);


        Testgeneric<Integer> tes = new Testgeneric();
        tes.gh(5);
        tes.gh("5");*/

        // sort
        for (int i=0; i<arr1.length; i++){
            for (int j=i+1; j< arr1.length; j++){
                if (arr1[i]>arr1[j]){
                    int a = arr1[i];
                    arr1[i]=arr1[j];
                    arr1[j]=a;
                }
            }
        }
        // min max
        System.out.println("min "+ arr1[0]);
        System.out.println("max "+ arr1[arr1.length-1]);

        // unic
        for (int i=0; i<arr1.length; i++){
             for (int j=i+1; j<arr1.length; j++){
                if (arr1[i]==arr1[j]){
                    break;
                }else if (j== arr1.length-1){
                        System.out.println(arr1[i]);
                }
            }
        }

        //pol
        int pol = 12321;
        int polCon = pol;
        int qal = 0;

        String a = "";
        while (pol!=0){
            qal = pol%10;
            pol = pol/10;
            a +=qal;
        }

        if (polCon==Integer.parseInt(a)){
            System.out.println(polCon+" number is polindrom");
        }

    }

    public static  <T> void genTest(T arr[]){
        for (int i=0; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static  <T> T genFirst(T arr[]){

        return arr[0];
    }
}