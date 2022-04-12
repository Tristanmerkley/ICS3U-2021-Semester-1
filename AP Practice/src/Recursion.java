public class Recursion {
    public static void main(String[] args) {
        System.out.println(fibonacci(100));
    }

    // insolving a problem we will solve a smaller version of the same problem
    // obtain the solution to n factorial
    public static int factorial(int n) {
        // 7! = 7 * 6 * 5 * 4 * 3 * 2 * 1 = 7 * 6!
        int result = 0;
        if (n == 1 || n == 0)
            result = 1;
        else
            result = n * factorial(n - 1);

        System.out.println(result);
        return result;
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 2)
            return 1;
        else
            return fibonacci(n - 2) + fibonacci(n - 1);
    }


}
