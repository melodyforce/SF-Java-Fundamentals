package exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ClosingResources {
  public static void main(String[] args) throws Throwable {
// Old form try/finally really doesn't work well for closing resources
//    try {
//      FileReader fr = new FileReader("data.txt");
//      FileWriter fw = new FileWriter("output.txt");
//      System.out.println("more processing");
//    } catch (FileNotFoundException fnfe) {
//      System.out.println("file not found");
//    } catch (IOException ioe) {
//      System.out.println("io problem ");
//    } finally {
//      // close all resources (at least all those that opened...
//      fw.close();
//    }

    // resources declared in parens after try will definitely be
    // closed, in reverse order from opening, by a auto-generated
    // finally block (we can add our own finally, which runs after
    // the auto-generated one)
    // resources must be final (or "effectively final")
    FileReader fr = new FileReader("data.txt"); // legal since Java 9, but a bit odd
    try (/*final*/ fr;
         /*final */FileWriter fw = new FileWriter("output.txt");) { // legal since Java 8, definitely good :)
      System.out.println("more processing");
//      fr = null;
    } catch (FileNotFoundException fnfe) {
      System.out.println("file not found");
    } catch (IOException ioe) {
      System.out.println("io problem ");
    }
    System.out.println("fr is " + fr);
  }
}
