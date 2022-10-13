package wrappers;

public class Example {
  public static void main(String[] args) {
//    Integer x = 99; // equivalent to below!
    Integer x = Integer.valueOf(99);
//    int y = x; // equivalent to:
    int y = x.intValue();
    // wrappers are all IMMUTABLE
    Integer z = x;
    System.out.println("Integer x is: " + x);
    x++; // equivalent to x = Integer.valueOf(x.intValue() + 1);
    System.out.println("Integer x is: " + x);
    System.out.println("x == z " + (x == z)); // false! DIFFERENT OBJECTS
  }
}
