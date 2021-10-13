package week7;

public class NestedLoops {
    public static void main(String[] args) {
        //exampleOne();
        //framingSquares(1, 2, 3, 4);
        //wordFrame("CANADA");
        diamonds("CANADA");
    }

    private static void diamonds(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(" ");
        }
        System.out.println(str.substring(0, 1));

        for (int i = 1; i < str.length() - 1; i++) {
            for (int j = 0; j < str.length() - i; j++) {
                System.out.print(" ");
            }
            System.out.print(str.substring(i, i + 1));
            for (int j = 0; j < i * 2 - 1; j++) {
                System.out.print(" ");
            }
            System.out.println(str.substring(i, i + 1));
        }

        for (int i = str.length() - 1; i > 0; i--) {
            for (int j = 0; j < str.length() - i; j++) {
                System.out.print(" ");
            }
            System.out.print(str.substring(i, i + 1));
            for (int j = 0; j < i * 2 - 1; j++) {
                System.out.print(" ");
            }
            System.out.println(str.substring(i, i + 1));
        }

        for (int i = 0; i < str.length(); i++) {
            System.out.print(" ");
        }
        System.out.println(str.substring(0, 1));
    }

    private static void wordFrame(String str) {
        System.out.println("*" + str + "*");
        for (int i = 0; i < str.length(); i++) {
            String start = str.substring(i, i + 1);
            String end = str.substring(str.length() - i - 1, str.length() - i);
            System.out.print(end);
            for (int j = 0; j < str.length(); j++) {
                System.out.print("*");
            }
            System.out.print(start);
            System.out.println();
        }
        System.out.print("*");
        for (int i = 0; i < str.length(); i++) {
            String end = str.substring(str.length() - i - 1, str.length() - i);
            System.out.print(end);
        }
        System.out.print("*");
    }

    private static void framingSquares(int m, int n, int p, int q) {
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 2 * p + 2 * q + n; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                System.out.print("#");
            }

            for (int j = 0; j < 2 * p + n; j++) {
                System.out.print("+");
            }

            for (int j = 0; j < q; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < q; j++) {
                System.out.print("#");
            }

            for (int j = 0; j < p; j++) {
                System.out.print("+");
            }

            for (int j = 0; j < n; j++) {
                System.out.print(".");
            }

            for (int j = 0; j < p; j++) {
                System.out.print("+");
            }

            for (int j = 0; j < q; j++) {
                System.out.print("#");
            }
            System.out.println();
        }


        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                System.out.print("#");
            }

            for (int j = 0; j < 2 * p + n; j++) {
                System.out.print("+");
            }

            for (int j = 0; j < q; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 2 * p + 2 * q + n; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    private static void exampleOne() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%5d", (i * j));
            }
            System.out.println();
        }
    }

}