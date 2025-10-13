package benchmark;

public class MergeSort {
    public static void main (String[] args) {
        int[] array = {17, 1, 2, 6, 49, 21, 9};

        mergeSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void mergeSort(int[] array) {
        if (array.length <= 1) return;

        int middle = array.length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[array.length - middle];

        // chia thành 2 mảng
        for (int i = 0; i < middle; i++) {
            leftArray[i] = array[i];
        }
        for (int i = middle; i < array.length; i++) {
            rightArray[i - middle] = array[i];
        }

        // đệ quy để sx 2 nửa
        mergeSort(leftArray);
        mergeSort(rightArray);

        // gộp 2 nửa
        merge(array, leftArray, rightArray);
    }

    public static void merge(int[] array, int[] leftArray, int[] rightArray) {
        int i = 0, l = 0, r = 0;

        while (l < leftArray.length && r < rightArray.length) {
            if (leftArray[l] <= rightArray[r]) {
                array[i] = leftArray[l];
                i++; l++;
            }
            else {
                array[i] = rightArray[r];
                i++; r++;
            }
        }

        while (l < leftArray.length) {
            array[i] = leftArray[l];
            i++; l++;
        }

        while (r < rightArray.length) {
            array[i] = rightArray[r];
            i++; r++;
        }
    }
}
