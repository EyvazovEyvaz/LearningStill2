import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Findspecificwordfromfile {

    public static void find_specific_words(){


        File file = new File("find.txt");

        FileOutputStream fileOutputStream;

        String str1 = " TODO \nTODO TODO TODO \nTODO TODO TODO TODO TODO TODO TODO";

        String str2 = "\nTOGO TOFO ";

        int i = 89;

        double j = 8.9;

        char c = 'y';

        String ch1 = String.valueOf(i);
        String ch2 = String.valueOf(j);
        String ch3 = String.valueOf(c);
        byte[] arr1, arr2, arr3, arr4, arr5;
        try {
            fileOutputStream = new FileOutputStream(file,false);
            arr1 = str1.getBytes();
            arr2 = str2.getBytes();
            arr3 = ch1.getBytes();
            arr4 = ch2.getBytes();
            arr5 = ch3.getBytes();

            fileOutputStream.write(arr1);
            fileOutputStream.write(arr2);
            fileOutputStream.write(arr3);
            fileOutputStream.write(arr4);
            fileOutputStream.write(arr5);
            fileOutputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int sum = 0;
        String todo = "TODO";
        ArrayList<String> arrayList = new ArrayList<>();
        String[] sty;
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                System.out.println(line);
                 sty = line.split(" ");
                arrayList.addAll(Arrays.asList(sty));
                if (line.contains(todo)){
                    sum++;
                    System.out.println("word finded: "+sum+"-rd line");
                }else{
                    System.out.println("word don't find it line");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int count = 0;
        for (String st: arrayList){
            if (st.equals(todo)){
                count++;
            }
        }

        System.out.println(todo+": "+count+" time used in text file.");
    }
}
