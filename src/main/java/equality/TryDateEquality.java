package equality;

public class TryDateEquality {
  public static void main(String[] args) {
    Date d1 = new Date(1, 2, 2022);
    Date d2 = new Date(1, 2, 2022);
    Date d3 = new Date(3, 2, 2022);

    System.out.println("d1 == d2? " + (d1 == d2));
    System.out.println("d1.equals(d2)? " + (d1.equals(d2)));
    System.out.println("d1.equals(d3)? " + (d1.equals(d3)));

    Holiday h1 = new Holiday(1, 2, 2022, "Festive");
    Holiday h2 = new Holiday(1, 2, 2022, "Festive");
    Holiday h3 = new Holiday(1, 2, 2022, "Very Festive");

    System.out.println("h1 == h2? " + (h1 == h2));
    System.out.println("h1.equals(h2)? " + (h1.equals(h2)));
    System.out.println("h1.equals(h3)? " + (h1.equals(h3)));

    System.out.println("h1.equals(d1)? " + h1.equals(d1));
    System.out.println("d1.equals(h1)? " + d1.equals(h1));
  }
}
