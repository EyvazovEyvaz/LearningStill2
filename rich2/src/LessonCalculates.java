import java.util.Scanner;

public class LessonCalculates extends AbstractLessons {
    public LessonCalculates(){
        secim();
    }

    public void secim(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Əməliyyatı seçin: (nomrə ilə)");
        System.out.println("1-M Hərfi ulduz ilə");
        System.out.println("2-N Hərfi ulduz ilə");
        System.out.println("3-A Hərfi ulduz ilə");
        System.out.println("4-S Hərfi ulduz ilə");
        System.out.println("5-İkiolculu array vurulmasi");

        int d = sc.nextInt();

        switch (d){
            case 1:
                System.out.println("Ölçü daxil edin 10-və daha böyük: ");
                writeMletter();
                break;
            case 2:
                System.out.println("Ölçü daxil edin 10-və daha böyük: ");
                writeNletter();
                break;
            case 3:
                System.out.println("Ölçü daxil edin 10-və daha böyük: ");
                writeAletter();
                break;
            case 4:
                System.out.println("Ölçü daxil edin 10-və daha böyük: ");
                writeSletter();
                break;
            case 5:
                multipleTwoDimensionalArray();
                break;
            default:
                System.out.println("Belə seçim yoxdur!");
        }
    }
    @Override
    public void writeMletter() {

            Scanner sc = new Scanner(System.in);
            int m = sc.nextInt();

            for (int i=1; i<=m; i++){
                for (int j=1; j<=m; j++){
                    if (j==1 || j==m || i!=1 && i<=m/2 && j==m-i){
                        System.out.print("*");
                    } else if (i!=1 && i<=m/2 && j==i) {
                        System.out.print("*");
                    } else{
                        System.out.print(" ");
                    }
                }
                System.out.println();

            }

    }

    @Override
    public void writeNletter() {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){
                if (j==1 || j==n || i!=1 && j==i){
                    System.out.print("*");
                } else{
                    System.out.print(" ");
                }
            }
            System.out.println();

        }
    }

    @Override
    public void writeAletter() {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        for (int i=0; i<=a; i++){
            for (int j=0; j<=a; j++){
                if (i<=a/2 && j==a/2-i || j==a/2+i){
                    System.out.print("*");
                } else if (i==a/2-a/4 && j>1 && j<a-1) {
                    System.out.print("*");
                } else{
                    System.out.print(" ");
                }
            }
            System.out.println();

        }

    }

    @Override
    public void writeSletter() {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();

        for (int i=0; i<=s; i++){
            for (int j=0; j<=s; j++){
                if (i<=s/2 && j==s/2 || i>=s/2 && j==s){
                    System.out.print("*");
                } else if (i==0&& j>=s/2 || i==s/2 && j>=s/2|| i==s && j>=s/2) {
                    System.out.print("*");
                } else{
                    System.out.print(" ");
                }
            }
            System.out.println();

        }

    }

    @Override
    public void multipleTwoDimensionalArray() {
        int a[][]={{2,5,6}, {3,2,8}, {2,9,3}};

        int b[][]={{1,1,7}, {2,4,2}, {3,1,3}};

        int c[][]=new int[a.length][3];

        int[][] result = new int[3][3];
        for(int i=0; i<a.length; i++){
            for (int j=0; j<b.length; j++){
                for (int v=0; v<b[0].length; v++){
                    result[i][j] += a[i][v]*b[v][j];
                }
            }
        }

        for (int i=0; i< result.length; i++){
            for (int j=0; j<result[0].length; j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
