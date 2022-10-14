package exceptions;

import java.net.SocketException;
import java.sql.SQLException;

class SemanticException extends Exception {
  public SemanticException() {
  }

  public SemanticException(String message) {
    super(message);
  }

  public SemanticException(String message, Throwable cause) {
    super(message, cause);
  }

  public SemanticException(Throwable cause) {
    super(cause);
  }

  public SemanticException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}

public class CheckedExceptionStuff {
  public static void mightBreakSilently() {
    try { // put the "happy path" in here
      if (Math.random() > 0.5) {
//      throw new RuntimeException("Aha, that broke");
        throw new SQLException("Aha, DB broke");
      }
      System.out.println("db operation successful!");
      if (Math.random() > 0.5) {
        throw new SocketException("network failure");
      }
//    } catch (SQLException sqle) {
//      System.out.println("Hmm, that broke: " + sqle.getMessage());
//    } catch (SocketException se) {
//      System.out.println("Hmm, that broke: " + se.getMessage());
//    } catch (Exception e) { // ouch! Catches our two,
//                               but also ANY other Exception type,
//                               including RUNTIME
//      System.out.println("Hmm, that broke " + e.getMessage());
    } catch (SQLException | SocketException e) { // better :)
      System.out.println("Hmm, that broke " + e.getMessage());
    }
  }

  public static void mightBreakNoisily() throws SQLException, SocketException {
    if (Math.random() > 0.5) {
      throw new SQLException("Aha, DB broke");
    }
    System.out.println("db operation successful!");
    if (Math.random() > 0.5) {
      throw new SocketException("network failure");
    }
  }

  public static void main(String[] args) throws SemanticException {
    mightBreakSilently();
    try {
      mightBreakNoisily();
    } catch (SQLException | SocketException e) {
      throw new SemanticException(e);
    }
  }
}
