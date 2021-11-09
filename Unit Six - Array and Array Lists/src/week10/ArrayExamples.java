package week10;

public class ArrayExamples {
    public static void main(String[] args) {
        primitiveArray();
        arrayObjectExample();
        iterateArrayExample();
    }

    private static void iterateArrayExample() {
        int[] arr = {5, 3, 2, 6, 3, 3};
    }

    private static void arrayObjectExample() {
        Animal[] animals = new Animal[3];
        animals[0] = new Animal(); // sets index 0 = to a new Animal
    }

    private static void primitiveArray() {
        int[] arr = new int[5]; // arr.length == 5

        arr[0] = 2;
        arr[1] = 6;
        arr[2] = 12;
        arr[3] = -3;
        arr[4] = 0;

        System.out.println(arr[2]); // prints value at index 2 (0)
    }


}
