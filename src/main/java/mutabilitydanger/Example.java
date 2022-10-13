package mutabilitydanger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Example {
  public static void showLongNames(List<String> ls) {
//    ls = new ArrayList<>(ls);
    Iterator<String> si = ls.iterator();
    while (si.hasNext()){
      String s = si.next();
      if (s.length() < 4) {
        si.remove();
      }
    }
    for (String s : ls) {
      System.out.println("> " + s);
    }
  }
  public static void main(String[] args) {
    List<String> names = new ArrayList<>(List.of(
        "Fred", "Jim", "Sheila"
    ));

//    showLongNames(names);
    showLongNames(new ArrayList<>(names)); // defensive copy (wasteful!!!)
    System.out.println(names);
  }
}
