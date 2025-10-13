import java.util.*;

public class Find_Median {

    public static double findMedian(List<Integer> arr) {
        Collections.sort(arr);   // hâmf này có sẵn trong java để sx tăng dần
        int n = arr.size();
        if (n % 2 == 1) {
            return arr.get(n / 2);
        }
        else {
            return (arr.get(n /2 -1) + arr.get(n / 2)) / 2.0;
        }
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
