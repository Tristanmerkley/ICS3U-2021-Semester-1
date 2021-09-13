package week2;

/**
 * Final modifier, modifies the variable so that it is a constant
 */

public class ExampleSeven {
    public static void main(String[] args) {
        final int x = 7;
        //x = 8; // cannot change a final variable


        final int y;
        y = 8;
        // y = 2; // cannot change a final variable

        final int NUMBER_OF_STUDENTS = 13; // naming convention for constants is UPPER_CASE _ for spaces
    }
}
