package lambdas;

import java.util.ArrayList;
import java.util.List;

public class FourLabExercises {
  public static void main(String[] args) {
    List<String> names = new ArrayList<>(List.of("Fred", "Jim", "Sheila"));
    names.replaceAll( x -> x.toUpperCase() );
    System.out.println(names);

    List<Double> nums = new ArrayList<>(List.of(
        3.14, 2.97, 42.8, -100.0));
    nums.replaceAll( v -> v * 1.3 );
    System.out.println(nums);

    names.removeIf( n -> n.length() < 5 );
    System.out.println(names);

    nums.sort( (d1, d2) -> Double.compare(d2, d1) );
    System.out.println(nums);
  }
}
