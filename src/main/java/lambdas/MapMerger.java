package lambdas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapMerger {
  public static void main(String[] args) {
    LocalDate today = LocalDate.now();
    LocalDate tomorrow = today.plusDays(1);

    Map<LocalDate, String> homeCalendar = Map.of(
        today, "Tidy up",
        tomorrow, "Have party"
    );

    Map<LocalDate, String> workCalendar = Map.of(
        today, "finish work",
        tomorrow, "leave early"
    );

    Map<LocalDate, String> combinedCalendar = new HashMap<>();
    System.out.println("combined contains: " + combinedCalendar);

    System.out.println("about to 'merge' home entries into combined calendar");
//    Set<Map.Entry<LocalDate, String>> entries = homeCalendar.entrySet();
    var entries = homeCalendar.entrySet();

    for (Map.Entry<LocalDate, String> e : entries) {
      combinedCalendar.merge(e.getKey(), e.getValue(),
          (v1, v2) -> {
            System.out.println("surprise! merge function called on empty map");
            return null;
          }
          );
    }
    System.out.println("combined contains: " + combinedCalendar);

    for (var e : workCalendar.entrySet()) {
      combinedCalendar.merge(e.getKey(), e.getValue(),
          (v1, v2) -> v2 + " and then " + v1);
    }
    System.out.println("combined contains: " + combinedCalendar);

    var al = new ArrayList<>(combinedCalendar.entrySet());
    al.sort((e1, e2) -> e1.getKey().compareTo(e2.getKey()));
    al.forEach(e -> System.out.println("Todo on " + e.getKey() + ": " + e.getValue()));
  }
}
