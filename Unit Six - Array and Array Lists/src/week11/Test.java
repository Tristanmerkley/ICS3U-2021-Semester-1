package week11;

public class Test {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        for (int x = 1; x < arr.length - 1; x++)

        {

            arr[x + 1] = arr[x] + arr[x + 1];

        }
    }
}
