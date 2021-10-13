package week7;

public class NestedLoops {
    public static void main(String[] args) {
        exampleOne();
        framingSquares(1, 2, 3, 4);
    }

    private static void framingSquares(int m, int n, int p, int q) {
        for (int i = 0; i < q; i++){
            for(int j = 0; j < 2 * p + 2 * q + n; j++){
                System.out.print("#");
            }
            System.out.println();
        }

        for (int i = 0; i < p; i++){
            for(int j = 0; j < q; j++){
                System.out.print("#");
            }

            for (int j = 0; j < 2 * p + n; j++){
                System.out.print("+");
            }

            for(int j = 0; j < q; j++){
                System.out.print("#");
            }
            System.out.println();
        }

        for (int i = 0; i < m; i++){
            for(int j = 0; j < q; j++){
                System.out.print("#");
            }

            for(int j = 0; j < p; j++){
                System.out.print("+");
            }

            for(int j = 0; j < n; j++){
                System.out.print(".");
            }

            for(int j = 0; j < p; j++){
                System.out.print("+");
            }

            for(int j = 0; j < q; j++){
                System.out.print("#");
            }
            System.out.println();
        }


        for (int i = 0; i < p; i++){
            for(int j = 0; j < q; j++){
                System.out.print("#");
            }

            for (int j = 0; j < 2 * p + n; j++){
                System.out.print("+");
            }

            for(int j = 0; j < q; j++){
                System.out.print("#");
            }
            System.out.println();
        }

        for (int i = 0; i < q; i++){
            for(int j = 0; j < 2 * p + 2 * q + n; j++){
                System.out.print("#");
            }
            System.out.println();
        }
    }

    private static void exampleOne() {
        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= 10; j++){
                System.out.printf("%5d", (i*j));
            }
            System.out.println();
        }
    }
}
