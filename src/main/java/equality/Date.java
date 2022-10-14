package equality;

// a final class prohibits subclasses.
// I STRONGLY recommend that you start making ALL your new
// classes final by default.
public/* final */class Date /*extends Object*/ {
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

  public Date withDayOfMonth(int day) {
    // VALIDATE!!!! throw exception if necessary
    return new Date(day, this.month, this.year);
  }

//  @Override
////  public boolean equals(Date obj) {
//  public boolean equals(Object obj) {
////    Object cl = Date.class; // this is a java.lang.Class object instance
//    if (obj instanceof Date) { // Date is a source-code thing, not runtime!
//      Date other = (Date)obj;
//      return this.day == other.day && this.month == other.month
//          && this.year == other.year;
//    }
//    return false;
//  }

//  @Override
//  public boolean equals(Object obj) {
//    if (obj instanceof Date other) {
//      return this.day == other.day && this.month == other.month
//          && this.year == other.year;
//    }
//    return false;
//  }

  @Override
  public /*final*/ boolean equals(Object obj) {
    // better to insist on identical types
    // but this violates Liskov substitution!!!
    if (obj.getClass() == this.getClass()) {
    return obj instanceof Date other
        && this.day == other.day
        && this.month == other.month
        && this.year == other.year;
    }
    return false;

    // instanceof means "is assignment compatible with"
//    return obj instanceof Date other
//        && this.day == other.day
//        && this.month == other.month
//        && this.year == other.year;
  }

  @Override
  public int hashCode() {
    int result = day;
    result = 31 * result + month;
    result = 31 * result + year;
    return result;
  }

  @Override
  public String toString() {
    return "Date{" +
        "day=" + day +
        ", month=" + month +
        ", year=" + year +
        '}';
  }
}

class Holiday extends Date {
  private String name;

  public Holiday(int day, int month, int year, String name) {
    super(day, month, year);
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj.getClass() == this.getClass()) {
      return super.equals(obj)
          && obj instanceof Holiday other
          && other.name.equals(this.name);
    }
    return false;
  }

  @Override
  public String toString() {
    return "Holiday{" +
        "name='" + name + '\'' +
        '}';
  }

}