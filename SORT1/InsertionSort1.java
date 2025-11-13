import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result1 {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
        int key = arr.get(n - 1);   // ptu cuối ds cần chèn
        int i = n - 1 - 1;          // mục bắt đầu so sánh (phần tử ngay trc key_

        // vòng lặp dịch chuyển
        while (i >= 0 && arr.get(i) > key) {
            arr.set(i + 1, arr.get(i));
            printList(arr);
            i--;
        }

        arr.set(i + 1, key);    // chèn key vào vị trí thích hợp
        printList(arr);
    }

    private static void printList(List<Integer> arr) {
        for (int j = 0; j < arr.size(); j++) {
            System.out.print(arr.get(j) + " ");
        }
        System.out.println();
    }


}

public class InsertionSort1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result1.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
