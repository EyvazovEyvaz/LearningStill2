import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

       // Menu.menu();

        Vehicle car = new Car();
        Vehicle moto = new Motorcycle();

        Vehicle[] vehicle = {car, moto};

        for (Vehicle vh: vehicle) {
            System.out.println(vh.startEngine());
        }

    }

}
