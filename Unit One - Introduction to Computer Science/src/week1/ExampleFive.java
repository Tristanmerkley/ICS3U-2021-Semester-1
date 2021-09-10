package week1;

/**
 * More of the same Integer vs Double math
 * modulus operator - remainder
 */

public class ExampleFive {
    public static void main(String[] args) {
        int markOne = 75, markTwo = 80, markThree = 87; // declared and initialized on the same line

        double average = (markOne+markTwo+markThree)/3; // integer division 242/3=80 no decimal
        average = (markOne+markTwo+markThree)/3.0; // double division 242/3.0 = 80.66667
        System.out.println(average);

        System.out.println(4/3); // 1
        System.out.println(4/3.0); // 1.33333
        System.out.println(3/4); // 0
        System.out.println(3.0/4); // 0.75


    }
}
