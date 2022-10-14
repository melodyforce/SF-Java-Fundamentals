package equality;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashingStructures {
  public static void main(String[] args) {
    Set<Date> sd = new HashSet<>();
    boolean added = sd.add(new Date(1, 2, 2023));
    System.out.println("added? " + added);
    System.out.println(sd);
    added = sd.add(new Date(1, 2, 2023));
    System.out.println("added? " + added);
    System.out.println(sd);
    added = sd.add(new Date(2, 2, 2023));
    System.out.println("added? " + added);
    System.out.println(sd);

    Map<Date, String> mds = new HashMap<>();
    mds.put(new Date(1, 1, 2023), "Have a new years day party");
    mds.put(new Date(2, 1, 2023), "Have a Burns day party");
    System.out.println(mds);
    mds.put(new Date(1, 1, 2023), "Have a really big party");
    System.out.println(mds);

    System.out.println("todo on 1,1,2023 " + mds.get(new Date(1, 1, 2023)));

  }
}
