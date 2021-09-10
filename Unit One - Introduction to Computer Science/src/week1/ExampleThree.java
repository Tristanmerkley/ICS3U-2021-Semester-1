package week1;


/**
 * Escape Sequences
 */
public class ExampleThree {
    public static void main(String[] args) {
        //System.out.println("This is "very" important!"); // compile error because double quotes encapsualte a string literal and we added extra quotes

        System.out.println("This is \"very\" important!"); // escape the quote by creating an escape sequence

        //System.out.println("This is \very important!"); // AP cares about \" \n \\

        System.out.println("This is \\very important!");

        System.out.println("This\nis\nvery\nimportant!"); // \n is a newline
        }
}
