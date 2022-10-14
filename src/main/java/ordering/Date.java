package ordering;

public class Date /*extends Object*/ implements Comparable<Date> {
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
  public boolean equals(Object obj) {
    if (obj.getClass() == this.getClass()) {
      return obj instanceof Date other
          && this.day == other.day
          && this.month == other.month
          && this.year == other.year;
    }
    return false;
  }

  @Override
  public int compareTo(Date d) {
    // WARNING: as a general rule DO NOT do subtraction
    int result = this.year - d.year;
    if (result != 0) return result;
    result = this.month - d.month;
    if (result != 0) return result;
    return this.day - d.day;

    // this is the RIGHT way to compare ints,
    // does not overflow :)
//    int result = Integer.compare(this.year, d.year);
  }
  // automatically creates a "Bridge" method
//  public int compareTo(Object o) {
//    return compareTo((Date) o);
//  }

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
