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
    if (!validate(day, month, year)) {
      throw new IllegalArgumentException("Bad date values");
    }
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

  // much nicer than setDayOfMonth... (but incomplete)
  public void setLastOfMonth() {
    this.day = daysInMonth(this.month, this.year);
  }

  // also, caller cannot fail (if implemented correctly)
//  public void addDays(int days) {
//    int newDay = this.day + days;
//    // wrap end of month(s) and years!!!!
//
//  }

  // this method is nasty (but almost always provided!!)
  public void setDayOfMonth(int day) {
    if (!validate(day, month, year)) {
      throw new IllegalArgumentException("Bad date values");
    }
    this.day = day;
  }

  public void setMonth(Month month) {
    // must validate! what if we're setting month to FEBRUARY
    // and day is already 30??
    if (!validate(day, month, year)) {
      throw new IllegalArgumentException("Bad date values");
    }
    this.month = month;
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
//  public static final List<Integer> daysInMonth =
//      List.of(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
//
//  public static int daysInMonth(Month month, int year) {
//    int index = month.ordinal();
//    return month == Month.FEBRUARY && isLeapYear(year)
//        ? 29
//        : daysInMonth.get(index);
//  }
//

//  private static final int[] daysInMonth =
//      { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
//
//  public static int daysInMonth(Month month, int year) {
//    int index = month.ordinal();
//    return month == Month.FEBRUARY && isLeapYear(year)
//        ? 29
//        : daysInMonth[index];
//  }
//

//  public static int daysInMonth(Month month, int year) {
//    // most Java permits switch on int and smaller numerics
//    // String, and enum
//    switch (month) {
////      case Month.APRIL:
//// standard case requires "short form" of enum constants
//      case SEPTEMBER: // falls through if no break, allows "alternation"
//      case APRIL:
//      case JUNE:
//      case NOVEMBER:
//        return 30; // return avoids need for break!!!
//      case FEBRUARY:
//        return isLeapYear(year) ? 29 : 28;
//      default:
//        return 31;
//    }
//  }

//  public static int daysInMonth(Month month, int year) {
//    // most Java permits switch on int and smaller numerics
//    // String, and enum
//    int dayCount;
//    switch (month) {
////      case Month.APRIL:
//// standard case requires "short form" of enum constants
//      case SEPTEMBER: // falls through if no break, allows "alternation"
//      case APRIL:
//      case JUNE:
//      case NOVEMBER:
//        dayCount = 30;
//        break; // nasty, but necessary, very error-prone
////        return 30; // return avoids need for break!!!
//      case FEBRUARY:
//        dayCount = isLeapYear(year) ? 29 : 28;
//        break;
////        return isLeapYear(year) ? 29 : 28;
//      default:
//        dayCount = 31;
//        break;
////        return 31;
//    }
//    return dayCount;
//  }

//  public static int daysInMonth(Month month, int year) {
//    int dayCount;
//    switch (month) {
//      // single statement / expression required on RHS of -> use {} to group
//      case SEPTEMBER, APRIL, JUNE, NOVEMBER -> {
//        System.out.println("it's 30 days");
//        dayCount = 30;
//      }
//      case FEBRUARY -> dayCount = isLeapYear(year) ? 29 : 28;
//      default -> dayCount = 31;
//    }
//    return dayCount;
//  }

  public static int daysInMonth(Month month, int year) {
    return switch (month) {
      case SEPTEMBER, APRIL, JUNE, NOVEMBER -> {
        System.out.println("It's thirty");
        yield 30;
      }
      case FEBRUARY -> isLeapYear(year) ? 29 : 28;
      default -> 31;
    };
  }

  //  public static boolean validate(int day, int month, int year) {
  public static boolean validate(int day, Month month, int year) {
    return day > 0 && day <= daysInMonth(month, year);
  }
}
