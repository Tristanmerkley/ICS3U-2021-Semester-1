package week2;

public class StudentExample {
  public static void main(String[] args) {
    Student shohei;

    shohei = new Student("Shohei", "123456", 11);
    // shohei is a Student (object variable)

    Student samantha = new Student("Samantha", "654321", 11);

    Student alan = shohei;

    // called (activated) the method increaseGrade
    // because alan and shohei reference the same Student Object both of their
    // grades increase (there is only 1 object)
    alan.increaseGrade();

    // we activate methods(functions) through the object (variable name)
    samantha.displayName();
    samantha.displayStudentNumber();
    samantha.increaseGrade();

    samantha = null;
    alan = new Student("Alan", "555555", 11);
    // samantha.displayGrade(); // null pointer exception cannot call a method from
    // a null reference

    alan.addTest(87);
    alan.displayAverage();
    alan.addTest(92);
    alan.displayAverage();
    alan.addTest(96);
    alan.displayAverage();
    alan.addTest(67);
    alan.displayAverage();

    // alan.numMarks = 7; don't have access to primate members (not visible)

  }
}