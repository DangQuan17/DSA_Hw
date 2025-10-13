import java.util.*;
import java.util.PriorityQueue;

public class JesseAndCookies {
    public static int cookies(int k, List<Integer> A) {     // k: độ ngọt tối thiểu cần đạt
        PriorityQueue<Integer> pq = new PriorityQueue<>(A);
        int operations = 0; // biến đếm số lần trộn bánh
        while (pq.size() > 1 && pq.peek() < k) {
            int least = pq.poll();
            int scleast = pq.poll();
            int newSweetness = least + 2 * scleast;
            pq.add(newSweetness);
            operations++;
        }

        return pq.peek() >= k ? operations : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(sc.nextInt());
        }

        System.out.println(cookies(k, A));
    }
}

