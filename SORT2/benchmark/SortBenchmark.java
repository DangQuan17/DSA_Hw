package benchmark;

import edu.princeton.cs.algs4.*;
import java.io.*;
import java.util.*;

public class SortBenchmark {
    public static void main(String[] args) throws IOException {
        // Danh sách file dữ liệu
        String[] files = {
                "C:\\Users\\Admin\\Downloads\\algs4-data\\1Kints.txt",
                "C:\\Users\\Admin\\Downloads\\algs4-data\\4Kints.txt",
                "C:\\Users\\Admin\\Downloads\\algs4-data\\8Kints.txt"
        };

        // In ra console
        System.out.printf("%-20s %-12s %-12s %-12s %-12s %-12s%n",
                "Dataset", "Insertion", "Selection", "Merge", "Quick", "QuickShuffle");

        // Mở file report.txt để ghi kết quả
        PrintWriter writer = new PrintWriter(new FileWriter("report.txt"));
        writer.printf("%-20s %-12s %-12s %-12s %-12s %-12s%n",
                "Dataset", "Insertion", "Selection", "Merge", "Quick", "QuickShuffle");

        // Lặp qua từng bộ dữ liệu
        for (String file : files) {
            In in = new In(file);
            int[] data = in.readAllInts();

            // Chạy các thuật toán, lấy trung bình 3 lần
            double tInsert = averageTime(() -> InsertionSort.insertionsort(Arrays.copyOf(data, data.length)), 3);
            double tSelect = averageTime(() -> SelectionSort.selectionSort(Arrays.copyOf(data, data.length)), 3);
            double tMerge  = averageTime(() -> MergeSort.mergeSort(Arrays.copyOf(data, data.length)), 3);
            double tQuick  = averageTime(() -> QuickSort.quickSort(Arrays.copyOf(data, data.length), 0, data.length - 1), 3);
            double tQShuffle = averageTime(() -> QuickSort_Shuffle.quickSort(Arrays.copyOf(data, data.length), 0, data.length - 1), 3);

            // In ra màn hình
            System.out.printf("%-20s %-12.3f %-12.3f %-12.3f %-12.3f %-12.3f%n",
                    getFileName(file), tInsert, tSelect, tMerge, tQuick, tQShuffle);

            // Ghi vào file
            writer.printf("%-20s %-12.3f %-12.3f %-12.3f %-12.3f %-12.3f%n",
                    getFileName(file), tInsert, tSelect, tMerge, tQuick, tQShuffle);
        }

        // Đóng file
        writer.close();
        System.out.println("Report đã được ghi vào file 'report.txt'");
    }

    // Hàm đo thời gian trung bình của thuật toán
    private static double averageTime(Runnable sortFunc, int times) {
        long total = 0;
        for (int i = 0; i < times; i++) {
            long start = System.currentTimeMillis();
            sortFunc.run();
            long end = System.currentTimeMillis();
            total += (end - start);
        }
        return total / (double) times;
    }

    private static String getFileName(String path) {
        return path.substring(path.lastIndexOf("\\") + 1);
    }
}
