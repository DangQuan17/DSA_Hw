import java.util.*;

public class Find_Median {

    public static double findMedian(List<Integer> arr) {
        int n = arr.size();
        int medianIndex = (n - 1) / 2;  // xđ vị trí thứ k là trung vị chỉ mục giữa

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = arr.get(i);
        }

        return (double) quickSelect(array, 0, n - 1, medianIndex);
    }
    private static int quickSelect(int[] arr, int start, int end, int k) {
        if (start == end) {
            return arr[start];
        }

        int pivotIndex = partition(arr, start, end);

        // So sánh và Đệ quy
        if (pivotIndex == k) {
            return arr[pivotIndex];
        } else if (k < pivotIndex) {
            return quickSelect(arr, start, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, end, k);
        }
    }

    /**
     * Hàm Partition
     */
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

    /**
     * Hàm tiện ích swap
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số ptu: ");
        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        System.out.println("Nhập các ptu: ");
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        double median = findMedian(arr);
        System.out.println("Số tvi: " + median);
    }
}
