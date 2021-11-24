package week11;

public class SelfDivisor {
    public static void main(String[] args) {
        isSelfDivisor(128);
    }

    public static boolean isSelfDivisor(int number) {
        int add = 10;
        boolean is = true;
        while (number > 0) {
            if (number % (number / add) != 0)
                is = false;
            number /= add;
        }
        return is;
    }

    public static int[] firstNumSelfDivisors(int start, int num) {
        int[] temp = new int[num];

        int count = 0;
        while (count < temp.length) {
            if (isSelfDivisor(start)) {
                temp[count] = start;
                count++;
            }
            start++;
        }
        return temp;
    }
}
