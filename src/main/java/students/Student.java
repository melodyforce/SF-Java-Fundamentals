package students;

interface StudyPerson {
  // elements of an interface are public or private (nothing else)
  // and if not marked are public by default
  String getName();
  double getGpa();

  static StudyPerson of(String name, double gpa) {
    if (gpa > 3.0) {
      return VIPStudent.of(name, gpa);
    } else {
      return Student.of(name, gpa);
    }
  }
}

interface Nameable {
  String getName();
//  String getHandle();
}

/*abstract */class VIPStudent implements StudyPerson, Nameable {
  private String name;
  private double gpa;

  private VIPStudent(String name, double gpa) {
    this.name = name;
    this.gpa = gpa;
  }

//  public abstract String getHandle();

  public static StudyPerson of(String name, double gpa) {
    return new VIPStudent(name, gpa);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getGpa() {
    return gpa;
  }
}

//class VIPStudent extends Student {
//  public VIPStudent(String name, double gpa) {
//    super(name, gpa);
//  }
//}
public class Student implements StudyPerson {
  private String name;
  private double gpa;

  private Student(String name, double gpa) {
    this.name = name;
    this.gpa = gpa;
  }

  public static StudyPerson of(String name, double gpa) {
      return new Student(name, gpa);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getGpa() {
    return gpa;
  }

//  public static Student of(String name, double gpa) {
//    if (gpa <= 3.0) {
//      return new Student(name, gpa);
//    } else {
//      return new VIPStudent(name, gpa);
//    }
//  }
}
