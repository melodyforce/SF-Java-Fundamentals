package calendar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UseDates {
//  public static void showAll(List<Date> ld) {
//    int index = 0;
//    while (index < ld.size()) {
//      System.out.println("> " + ld.get(index));
////      index = index + 1;
////      index += 1;
//      index++;
//    }
//  }
//  public static void showAll(List<Date> ld) {
//    // C-style for loop.
//    for (int index = 0; index < ld.size(); index++) {
//      System.out.println("> " + ld.get(index));
//    }
//  }

  public static void showAll(List<Date> ld) {
    // "enhanced-for loop, works with any subtype of "Iterable" (e.g. List, Set)
    // and any array
    for (Date d : ld) {
      System.out.println("> " + d);
    }
  }

  public static void main(String [] args) {
//    ArrayList<Date> dates = new ArrayList(List.of("Alfred", "Bert",
//        new Date(12, Date.Month.OCTOBER, 2022)
//        ));
//    ArrayList<Date> dates = new ArrayList<Date>(List.of("Alfred", "Bert",
//        new Date(12, Date.Month.OCTOBER, 2022)
//        ));
    List<Date> dates =
//        new LinkedList<>(List.of(
        new ArrayList<>(List.of(
//    ArrayList<Date> dates = new ArrayList<>(List.of(
//    LinkedList<Date> dates = new LinkedList<>(List.of(
        new Date(13, Date.Month.OCTOBER, 2022),
        new Date(9, Date.Month.JANUARY, 2021),
        new Date(22, Date.Month.APRIL, 2020),
        new Date(2, Date.Month.NOVEMBER, 2020)
        ));
    dates.add(new Date(1, Date.Month.JANUARY, 1970));
//    dates.add("Albert");
    Date d1 = dates.get(0);
    System.out.println("Date at index 0 is " + d1);
//    Object d2 = dates.get(1);
//    Date d2 = (Date)dates.get(1);
    Date d2 = dates.get(1);
    System.out.println("Date at index 1 is " + d2);

    showAll(dates);
  }
}
