package week9;

public class Beverage {

    private int numOunces;
    private static int numSold = 0;

    public Beverage(int numOz) {
        numOunces = numOz;
    }

    /* belongs to the class */
    // can do beverage.sell(6)
    // if it was non-static, you do (object name).sell(6)
    public static void sell(int n) {
        numSold += n;
        //numOunces++;
    }
}
