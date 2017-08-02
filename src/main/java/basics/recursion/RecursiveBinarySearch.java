package basics.recursion;

import java.util.List;

/**
 * Created by rajani.maski on 6/15/17.
 */
public class RecursiveBinarySearch {
    public static void main(String[] args) {
        binarySearch( new int[10] , 2);
    }

    public static int binarySearch(int[] list, int k) {

        int low = 0;
        int high = list.length - 1;
        return recBinarySearch(list, k, low, high);
    }

    private static int recBinarySearch(int[] list, int key, int low, int high) {

        if (low > high) {
            return -low - 1;
        }
        int mid = (low + high) / 2;
        if (key < list[mid]) {
            return recBinarySearch(list, key, low, mid - 1);
        } else if (key == list[mid])
            return mid;
        else {
            return recBinarySearch(list, key, mid + 1, high);
        }
    }
}
