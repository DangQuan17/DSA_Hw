import java.io.*;
import java.util.*;
// đây là bản chuyển thể từ hackerrank sang để có thể chạy trên này

class Result {

    public static List<Integer> quickSort(List<Integer> arr) {
        if (arr == null || arr.size() <= 1) return arr;

        int[] array = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            array[i] = arr.get(i);
        }

        quickSort(array, 0, array.length - 1);

        List<Integer> sorted = new ArrayList<>();
        for (int num : array) sorted.add(num);
        return sorted;
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int p = partition(arr, start, end);
            quickSort(arr, start, p - 1);
            quickSort(arr, p + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, end);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

public class Quicksort1_Partition {
    public static void main(String[] args) throws IOException {
        // Test nhanh
        List<Integer> arr = Arrays.asList(4, 5, 3, 7, 2);
        List<Integer> result = Result.quickSort(arr);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
