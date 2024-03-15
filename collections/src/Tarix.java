import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

public class Tarix {

    public void differenceBetweenTwoDates(){

        /// WITH SIMPLEDATEFORMAT

        String start = "11-01-2018 02:11:20";

        String end = "11-06-2020 07:31:50";

        SimpleDateFormat smpl = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        Date ds;
        Date de;
        try {
             ds = smpl.parse(start);
             de = smpl.parse(end);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        long diffe = ds.getTime()-de.getTime();

        long sec = (diffe/1000) % 60;
        long min = (diffe/(1000 * 60)) % 60;
        long hour = (diffe/(1000 * 60 * 60)) % 24;
        long day = (diffe/(1000 * 60 * 60 * 24)) % 365;
        long month = ((diffe/(1000 * 60 * 60 * 24)) % 365)/30;
        long years = diffe/(1000L * 60 * 60 * 24 * 365);

        System.out.println(day);


        // WITH LOCALDATE
        LocalDate st = LocalDate.of(2018, 01, 10);

        LocalDate en = LocalDate.of(2020, 04, 10);

        Period perdif = Period.between(st, en);

        System.out.println(perdif.getDays()+" day, "+perdif.getMonths()+" month, "+perdif.getYears()+" year");


    }
    public void theNextOccurrenceDateOfTheWeekDay(){

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,7);
        System.out.println(calendar.getTime());


        LocalDate localDate = LocalDate.now();

        DayOfWeek dayOfWeek = DayOfWeek.from(localDate);
        System.out.println(dayOfWeek.get(ChronoField.DAY_OF_WEEK));

        dayOfWeek = dayOfWeek.plus(7);
        System.out.println(dayOfWeek);
    }
    public void countOfDaysUntilTheEndOfTheYear(){

        String yearNow = "22-02-2024 23:25:10";
        String yearEnd = "31-12-2024 23:59:59";

        SimpleDateFormat simpd = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        Date now,end;
        try {
             now = simpd.parse(yearNow);
             end = simpd.parse(yearEnd);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        long restPeriod = end.getTime()-now.getTime();

        long secs = (restPeriod / 1000 ) % 60;
        long mins = (restPeriod / (1000 * 60 )) % 60;
        long hours = (restPeriod / (1000 * 60 * 60)) % 24;
        long days = (long) ((restPeriod / (1000 * 60 * 60 * 24)) % 30.5);
        long months = ((restPeriod / (1000 * 60 * 60 * 24)) % 365)/30;

        System.out.println("sec: "+secs+"\n"+" mins: "+mins+"\n"+" hours: "+hours+"\n"+" days: "+days+"\n"+" months: "+months);

    }
    public void calculateAge(){

        LocalDate birthDate = LocalDate.of(1997,03,9);

        LocalDate nowDate = LocalDate.now();

        Period differ = Period.between(nowDate, birthDate);

        System.out.println("age: "+differ.getYears());

    }

}
