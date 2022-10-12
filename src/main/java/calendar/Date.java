package calendar;

import java.util.List;

//enum Month {
//  JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE,
//  JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
//}
//
// "new" allocates and zeroes all memory
// then the constructor (better described as "initializer" receives the
// new object as "this" and should initialize it.
public class Date {
  /*static IMPLICITLY STATIC for inner enums*/ enum Month {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE,
    JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
  }

  public static int MONTH_COUNT = 12;

  private int day;
//  private int month;
  private Month month;
  private int year;

//  public Date(int day, int month, int year) {
  public Date(int day, Month month, int year) {
    // validate?
    this.day = day;
    this.month = month;
    this.year = year;
  }

  // Date someDate = new Date(1, 1, 1970);
  // String s = Date.asText(someDate); // like verb, object
//  public static String asText(Date d) {
//    return "Date: day=" + d.day + ", month=" + d.month
//        + ", year=" + d.year;
//  }

// Date someDate = new Date(1, 1, 1970);
// String s = someDate.toString(); // like subject, verb
  public /*static*/ String toString() { // IMPLICITLY has first argument called this.
//  public /*static*/ String asText(Date this) {
    return "Date: day=" + this.day + ", month=" + this.month
        + ", year=" + this.year;
  }

  public static boolean isLeapYear(int year) {
    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
  }

//  public static int daysInMonth(int month, int year) {
//    if (month < 1 || month > 12) throw new IllegalArgumentException("Bad Month");
//    if (month == 9 || month == 4 || month == 6 || month == 11) {
//      return 30;
//    } else if (month == 2) {
//      return isLeapYear(year) ? 29 : 28;
//    } else {
//      return 31;
//    }
//  }

  // List.of creates an unmodifiable list (since Java 9)
  public static final List<Integer> daysInMonth =
      List.of(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

  public static int daysInMonth(Month month, int year) {
    int index = month.ordinal();
    return month == Month.FEBRUARY && isLeapYear(year)
        ? 29
        : daysInMonth.get(index);
  }

//  public static boolean validate(int day, int month, int year) {
  public static boolean validate(int day, Month month, int year) {
    return day > 0 && day <= daysInMonth(month, year);
  }
}
