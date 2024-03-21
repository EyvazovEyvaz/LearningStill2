import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Mydate {


    public void differ_inbetween_dates(){

        LocalDate localDate = LocalDate.of(1988, 10, 9);
        LocalDate now = LocalDate.now();

        Period differ = Period.between(localDate, now);

        System.out.println(differ.getYears());
        System.out.println(differ.getMonths());
        System.out.println(differ.getDays());


    }

    public void parseStringToDate(){

        String str = "01-05-1999 22:11:11";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        try {
            Date date = simpleDateFormat.parse(str);
            System.out.println(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

}
