import javax.lang.model.util.ElementScanner6;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {4, 7, 9, 10, 12, 12, 56, 78, 100};

        int index = binarySearchLoop(arr, 7);

    }

    public static int binarySearchLoop(int[] arr, int findMe) {
        int start = 0;
        int end = arr.length - 1;

        int mid = (start + end) / 2;

        while (start < end) {
            if (arr[mid] == findMe)
                return mid;
            else if (findMe < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
            mid = (start + end) / 2;
        }
        return -1;
    }

    public static int binarySearchRecursion(int[] arr, int findMe, int start, int end) {
        if (start > end)
            return -1;
        else {
            int mid = (start + end) / 2;
            if (arr[mid] == findMe)
                return mid;
            else if (findMe < arr[mid])
                return binarySearchRecursion(arr, findMe, start, mid - 1);
            else
                return binarySearchRecursion(arr, findMe, mid + 1, end);
        }
    }
}
