package builder;

public class Thing {
  private String name;
  private String address;
  private int count;

  private Thing() {} // uninitialized!! INVALID!!

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder { // "template" for a Thing
    private String name;
    private String address;
    private int count;

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder address(String address) {
      this.address = address;
      return this;
    }

    public Builder count(int count) {
      this.count = count;
      return this;
    }

    public Thing build() {
      if (isValid(name, address, count)) {
        Thing returnValue = new Thing();
        returnValue.name = name;
        returnValue.address = address;
        returnValue.count = count;
        return returnValue;
      } else {
        throw new IllegalArgumentException("Bad Thing configuration");
      }
    }

    private Builder() {}
  }

  @Override
  public String toString() {
    return "Thing{" +
        "name='" + name + '\'' +
        ", address='" + address + '\'' +
        ", count=" + count +
        '}';
  }

  private static boolean isValid(String name, String address, int count) {
    return count > 0;
  }
}

class UseBuilder {
  public static void doStuff(Thing t) {
    System.out.println("Got: " + t);
  }

  public static void main(String[] args) {
    Thing.Builder b = Thing.builder()
        .address("Over here")
        .count(99)
        .name("Fred");

    Thing t = b.build();
    doStuff(t);
//    doStuff(b);

    b.name("Alfred");
    Thing t2 = b.build();
    doStuff(t2);
    System.out.println("t == t2 " + (t == t2));
  }
}

/*
// named vs positional argument passing (JAVA DOES NOT DO THIS)
function f(a, b, c) {
  console.log(`a is ${a}`);
}
f(1, 2, 3); // a is 1
f("x"); // a is x
f(b=99, a=100, c=2); // a is 100

// English argument order!!!
function dayOfWeek(day, month, year) {}

dayOfWeek(12, 31, 2022); // oops, US argument order
// Java would benefit from being able to say:
dayOfWeek(month=12, day=31, year=2022);

Modify the builder pattern to "invocation builder"
dayOfWeek.builder().day(31).month(12).year(2022).invoke();
or...
dayOfWeek.builder().year(2022).month(12).day(31).invoke();

just works, arguments "passed by name"
*/
