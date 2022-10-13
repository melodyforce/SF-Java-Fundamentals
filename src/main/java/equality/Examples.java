package equality;

public class Examples {
  public static void main(String[] args) {
    int x = 1;
    int y = 1;
    System.out.println("x == y? " + (x == y));
    String s1 = new String("Hello");
    String s2 = new String("Hello");
    System.out.println("s1 == s2? " + (s1 == s2));
    System.out.println("s1.equals(s2)? " + s1.equals(s2));

    String s3 = s1.toUpperCase();
//    s1 = s1.toUpperCase();
    System.out.println("after uppercase, s1 is " + s1);
    System.out.println("after uppercase, s3 is " + s3);

    StringBuilder sb1 = new StringBuilder("Hello World!");
    StringBuilder sb2 = new StringBuilder("Hello");
    System.out.println("sb1 is " + sb1);
    System.out.println("sb2 is " + sb2);
    sb2.append(" World!");
    System.out.println("sb2 is " + sb2);

    System.out.println("sb1 == sb2?  " + (sb1 == sb2));
    System.out.println("sb1.equals(sb2)?  " + (sb1.equals(sb2)));
  }
}

// Euler project
