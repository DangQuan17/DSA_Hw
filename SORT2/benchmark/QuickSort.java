package benchmark;

public class QuickSort {
    public static void main (String[] args) {
        int[] arr = {17,1,2,6,49,21,9};

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sau khi sx: ");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);

            //đệ quy sắp xếp:
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];       // pivot = ptu cuối
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                //swap arr[i] và arr[j]
                swap(arr, i, j);
            }
        }
        // đặt pivot vào đúgn vị trí:
        swap(arr, i + 1, end);
        return i + 1;
    }

    public static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
