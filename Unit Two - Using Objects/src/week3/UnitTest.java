package week3;

public class UnitTest {
    public static void main(String[] args) {
        System.out.println(threeCopies("Happy", 1));
        System.out.println(threeCopies("Computer", 3));
        System.out.println(removeChars("Computer Science", 3, 4));
        System.out.println(sqrtSum(9999));
    }

    /**
     * Write a function that accepts a String and an int that represents an index. Obtain 2 characters at that index and return 3 copies of that String.
     */
    public static String threeCopies(String str, int index) {
        String s = str.substring(index, index + 2); // gets 2 characters starting at index
        return s + s + s;
    }

    public static String removeChars(String str, int index, int n){
        String one = str.substring(0, index + 1);
        String two = str.substring(index + n);
        return one + two;
    }
    public static double sqrtSum(int number){
        int n1 = number / 1000;
        int n2 = (number % 1000) / 100;
        int n3 = (number % 100) / 10;
        int n4 = number % 10;
        
        int sum = n1 + n2 + n3 + n4;
        return Math.sqrt(sum);
    }
}
