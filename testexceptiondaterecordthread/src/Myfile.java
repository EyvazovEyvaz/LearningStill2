import java.io.*;
import java.util.ArrayList;
public class Myfile {
   static ArrayList<String> arrayList = new ArrayList<>();
    static int sum_numbertypes = 0;
    static int index = 0;
    public static void testfile() throws FileNotFoundException {

        File file = new File("data.txt");

        FileOutputStream fileOutputStream;

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        double dab = 7.7;
        Integer big = 100;
        String str = "\nedfvsd\n";
        String spc = "\n";
        byte[] bytes, bytestr, spcbyte, bigbytesint;

        try {
            fileOutputStream = new FileOutputStream(file, false);
            for (Integer i : arr) {
                bytes = i.toString().getBytes();
                spcbyte = spc.getBytes();
                fileOutputStream.write(bytes);
                fileOutputStream.write(spcbyte);
            }
            bytes = String.valueOf(dab).getBytes();
            bytestr = str.getBytes();
            fileOutputStream.write(bytes);
            fileOutputStream.write(bytestr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.write("\neyvaz eyvazov Mehdi oğlu");
            bigbytesint = big.toString().getBytes();
            fileOutputStream.write(bigbytesint);
            fileOutputStream.close();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int sum;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String i;
        try {
            while ((i=bufferedReader.readLine()) !=null){
                System.out.println(i);
                arrayList.add(i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(arrayList);

        recursive_metod(0);
    }

    public static void recursive_metod(int in) {

        try {
            for (int i=in; i<arrayList.size(); i++){
                index = i;
                int j = Integer.parseInt(arrayList.get(i));
                sum_numbertypes +=j;
            }
        } catch (java.lang.Exception e) {
            throw new RuntimeException();
        }finally {
            if (index !=arrayList.size()-1){
                recursive_metod(index+1);
            }else{
                System.out.println(sum_numbertypes);
            }
        }
    }

    }

class InvaliDataException extends java.lang.Exception {

    public InvaliDataException(String mymessage) {
        super(mymessage);
    }
}

