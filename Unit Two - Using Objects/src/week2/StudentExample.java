package week2;

public class StudentExample {
    public static void main(String[] args) {
        // ritchie is a variable to an instance of the class student
        // ritchie is an object (instances of a class)
        Student ritchie = new Student("Ritchie", "45646", 10);
        Student yola = new Student("Yola", "123456", 10);

        // ritchie and yola are references to 2 different students

        Student rastin = ritchie;


        rastin.increaseGrade();

        ritchie = null;
        //Student tristan; tristan is currently the null reference

        //ritchie.increaseGrade(); // throws a java.lang.NullPointerException because ritchie is null


    }
}
