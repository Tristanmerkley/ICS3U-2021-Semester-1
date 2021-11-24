package week11;

public class NumberCube {
    public int toss() {
        return 0;
    }

    public static int[] getCubeTosses(NumberCube cube, int numTosses) {
        int[] tosses = new int[numTosses];
        for (int i = 0; i < tosses.length; i++) {
            tosses[i] = cube.toss();
        }
        return tosses;
    }

    public static int getLongestRun(int[] values) {
        int run = 1;
        int current = 0;
        for (int i = 1; i < values.length; i++) {
            if (values[i] == values[i - 1])
                run++;
            else {
                if (current > run)
                    run = current;
                current = 1;
            }
        }
        if (run > 1)
            return run;
        return -1;
    }
}
