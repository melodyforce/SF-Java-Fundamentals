package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Date {
  private int day;
  private int month;
  private int year;

  public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public int getDay() {
    return day;
  }

  public int getMonth() {
    return month;
  }

  public int getYear() {
    return year;
  }

  @Override
  public String toString() {
    return "Date{" +
        "day=" + day +
        ", month=" + month +
        ", year=" + year +
        '}';
  }
  public static void showYourName() {
    System.out.println("This is Date.showYourName()");
  }
}

// Holiday!!! -- oh, that's a Date with a name, right?

class Holiday extends Date {
  private String name;
  // in the absence of any constructor code, compiler
  // generates a "default"
  // access is same as class (unless it's an enum, which must be private)
  // (usually) takes zero arguments -- exception is instance inner classes
  // equivalent to an empty method body
  Holiday(int day, int month, int year, String name) {
    // if you do not have super(...) nor this(...) as the first
    // line of any constructor, the compiler adds
    super(day, month, year);
//    this.updateYear(year); must not refer to "this" in any way before
    // completion of the call to super().
    this.name = name;
  }
  public int updateYear(int year) {
    return year + 2000;
  }

//  @Override
//  public String toString() {
//    return "Holiday{" +
//        "day=" + this.getDay() +
//        ", month=" + this.getMonth() +
//        ", year=" + this.getYear() +
//        ", name=" + name +
//        '}';
//  }
  @Override
  public String toString() {
    return "Holiday{" +
        // gives the behavior we would have had if we
        // had not overridden it in this class
        // can be used in other methods of this class,
        // not restricted to use in the same method as
        // we are calling
        super.toString() +
        ", name=" + name +
        '}';
  }
  public static void showYourName() {
    System.out.println("This is Holiday.showYourName()");
  }
}

class UseDates {
  public static void showMeTheDate(Date d) {
    System.out.println("This is a date in month number " + d.getMonth());
  }

  public static void main(String[] args) {
    List<Date> startingDates = List.of(
        new Date(28, 3, 2022),
        new Date(2, 10, 2022),
        new Date(12, 8, 2022)
    );
//    startingDates.add(new Date(12, 8, 2022));

    List<Date> dates = new ArrayList<>(startingDates);
    showMeTheDate(dates.get(0));

    Date d = new Holiday(1, 1, 2023, "New Year's Day");
    System.out.println("the holiday referred to by Date d is " + d.toString());
    dates.add(d);
//    dates.add(new Holiday(1, 1, 2023, "New Year's Day"));

    Holiday h = new Holiday(1, 1, 2023, "New Year's Day");
    System.out.println("the holiday referred to by Holiday h is " + h.toString());
    showMeTheDate(h);

    System.out.println("Date is " + dates.get(0));
    System.out.println("Date at sub-3 is " + dates.get(3).toString());
    Date.showYourName();
    Holiday.showYourName();
    d.showYourName();
    h.showYourName();

  }
}
