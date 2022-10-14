package ordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MonthOrder implements Comparator<Date> {
  @Override
  public int compare(Date o1, Date o2) {
    return o1.getMonth() - o2.getMonth();
  }
}

class ReverseMontOrder implements Comparator<Date> {
  @Override
  public int compare(Date o1, Date o2) {
    return o2.getMonth() - o1.getMonth();
  }
}

public class SimpleExample {
  public static void compareFirstTwo(List<Date> ld, Comparator<Date> cd) {
    int order = cd.compare(ld.get(0), ld.get(1));
    System.out.println("order is " + order);
  }

  public static void showAllDates(List<Date> ld) {
    for (Date d : ld) {
      System.out.println("> " + d);
    }
    System.out.println("-------------------------");
  }
  public static void main(String[] args) {
    Integer i1 = 9;
    Integer i2 = 6;
    System.out.println("9 compareTo 6 " + i1.compareTo(i2));
    System.out.println("6 compareTo 9 " + i2.compareTo(i1));

    String s1 = "Fred";
    String s2 = "Jim";
    int result = s1.compareTo(s2);
    System.out.println(result);

    List<String> names = new ArrayList<>(List.of(
        "Fred", "Alice", "Jim", "Bert", "Sheila", "Tony", "Mary"));

    System.out.println(names);
    Collections.sort(names);
    System.out.println(names);

    List<Date> ld = new ArrayList<>(List.of(
        new Date(1, 2, 2022),
        new Date(1, 1, 2022),
        new Date(1, 3, 2020),
        new Date(1, 7, 2024),
        new Date(1, 5, 2019)
    ));

    showAllDates(ld);
    Collections.sort(ld);
    showAllDates(ld);
    compareFirstTwo(ld, new MonthOrder());

    // prior to Java 8, use this:
//    Collections.sort(ld, new MonthOrder());
    // newer Java allows
    ld.sort(new MonthOrder());
    showAllDates(ld);

    // OO calls this "pass an argument primarily for the BEHAVIOR
    // that it contains" a "Command" pattern
    // FP it's simply one example of a "Higher Order Function"
    ld.sort(new ReverseMontOrder());
    showAllDates(ld);

//    ld.sort(new
//     Comparator<Date>(/* any necessary constructor args go here */) {
//      @Override
//      public int compare(Date o1, Date o2) {
//        return o1.getMonth() - o2.getMonth();
//      }
//    }
//        );
//    showAllDates(ld);

    // the argument to List<Date>.sort MUST BE Comparator<Date>
    // (or it couldn't compile :)
    // ALSO: Comparator is an INTERFACE (the syntax we are building to REQUIRES)
    // therefore no constructor arguments are possible!!!
    // arguments have to be objects! (so we must need to "new something")
    // IF (but only if) the interface has EXACTLY ONE abstract method
    // AND we only care to implement that ONE abstract method
    // AND we're not trying to create any fields or member classes
    // THEN we don't need to group multiple class elements
    // AND we know the method that we are implementing
    ld.sort(/*new
     Comparator<Date>(-- any necessary constructor args go here ) */ /*{*/
      /*@Override
      public int compare*/(Date o1, Date o2) -> {
        return o1.getMonth() - o2.getMonth();
      }
    /*}*/
        );
    showAllDates(ld);


  }
}
