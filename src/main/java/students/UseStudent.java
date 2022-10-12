package students;

public class UseStudent {
  public static void main(String[] args) {
    double gpa = 3.2;
//    Student s1 = (gpa > 3.0)
//        ? new VIPStudent("Fred", gpa)
//        : new Student("Fred", gpa);
//
//    // change for ALL other use cases!!
////    Student s2 = new Student("Fred", 3.2);
//    Student s2 = (gpa > 3.0)
//        ? new VIPStudent("Fred", gpa)
//        : new Student("Fred", gpa);
//
//    Student s3 = new Student("Fred", 3.2);
//
//    Student s4 = new Student("Fred", 3.2);

//    Student s1 = Student.of("Fred", gpa);
    StudyPerson s1 = StudyPerson.of("Fred", gpa);
    System.out.println("type of s1 is " + s1.getClass().getName());
  }
}
