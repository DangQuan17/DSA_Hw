package benchmark;

import java.util.Random;

public class QuickSort_Shuffle {
    public static void main(String[] args) {
        int[] arr = {17, 1, 2, 6, 49, 21, 9};

        shuffle(arr);

        quickSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];       // chọn pivot là phần tử cuối;
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

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // shuffle;
    public static void shuffle(int[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i>0; i--) {
            int j = rand.nextInt(i+1);
            swap(arr, i, j);
        }
    }
}
