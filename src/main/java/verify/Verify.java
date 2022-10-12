package verify;

public class Verify {
  public static void main(String[] args) {
    Object obj = "Hello";
    switch (obj) {
      case String s when s.length() > 4 -> System.out.println(s + " Java 19 World!");
      default -> throw new RuntimeException("That can't happen!");
    }
  }
}
