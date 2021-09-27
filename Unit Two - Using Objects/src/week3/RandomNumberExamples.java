package week3;

public class RandomNumberExamples {
    public static void main(String[] args) {
        
        System.out.println(Math.random()); // [0.0, 0.9999999999]

        double r = Math.random();

        int lower = -5;
        int upper = 5;
        int numPossibilites = (upper - lower + 1);

        int rand = (int) ((upper - lower + 1 ) * r) - lower;

        String str = "Random Numbers";

        int index = (int) (Math.random() * str.length());
        str = str.substring(0, index) + "x" + str.substring(index + 1);
        System.out.println(str);

        System.out.println((int) (Math.random() * 4)*2);
    }
}
