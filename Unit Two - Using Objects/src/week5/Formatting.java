package week5;

public class Formatting {
    public static void main(String[] args) {
       // 5:3.272       => 5 : 3.272
       // 5:03.272

       int minutes = 5;
       double seconds = 3.272;
       double seconds1 = 3.2;

       
       // what i want is this: 5:03.272

       // placeholders
       // %d -> for ints
       // %f -> floating point numbers (double)
       // %06.3f -> pad the left side with 0 width of 6 and 3 decimal places

       //System.out.printf("blah%dtest %f", minutes, seconds);
       System.out.printf("%d:%06.3f", minutes, seconds1);
    }

}
