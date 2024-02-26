import java.time.*;
import java.time.temporal.ChronoField;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Collection collection = new Collection();

        collection.groupingObjectsByPropertys();
        collection.listFindCommonElemets();
        collection.mergeTwoListAndSortThem();
        collection.checkListIsPalindrome();

        Tarix tarix = new Tarix();

        tarix.differenceBetweenTwoDates();
        tarix.countOfDaysUntilTheEndOfTheYear();
        tarix.calculateAge();
        tarix.theNextOccurrenceDateOfTheWeekDay();
    }
}