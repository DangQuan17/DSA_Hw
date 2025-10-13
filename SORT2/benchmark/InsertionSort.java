package benchmark;

public class InsertionSort {
    public static void insertionsort (int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j -1;
            }

            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 6, 7, 9, 2, 3, 15, 16};
        System.out.println("Mảng trước khi được sắp xếp: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("");

        insertionsort(arr);

        System.out.println("Mảng sau khi được sắp xếp: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        }
    }