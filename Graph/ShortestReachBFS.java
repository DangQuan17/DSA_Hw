import java.util.*;

public class ShortestReachBFS {
    public static int[] findShortestReach(ArrayList<ArrayList<Integer>> graph, int n, int start) {

        // Mảng costs lưu chi phí. Kích thước n+1 (để dùng index 1 đến n).
        int[] costs = new int[n + 1];
        // Khởi tạo tất cả chi phí là -1 (chưa thăm / không đến được)
        Arrays.fill(costs, -1);

        // Hàng đợi cho thuật toán BFS
        Queue<Integer> queue = new LinkedList<>();

        // Thiết lập đỉnh xuất phát
        costs[start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            int currentCost = costs[u];

            // Duyệt qua tất cả các đỉnh kề (v) của đỉnh hiện tại (u)
            for (int v : graph.get(u)) {
                // Nếu đỉnh v chưa được thăm (costs[v] vẫn là -1)
                if (costs[v] == -1) {
                    // Chi phí tới v = chi phí tới u + 6
                    costs[v] = currentCost + 6;
                    queue.add(v);
                }
            }
        }

        // Số đỉnh còn lại (n-1 đỉnh không phải đỉnh start)
        int resultSize = n - 1;
        int[] finalResult = new int[resultSize];
        int idx = 0;

        // Duyệt từ đỉnh 1 đến n để lấy chi phí (bỏ qua đỉnh start)
        for (int i = 1; i <= n; i++) {
            if (i != start) {
                finalResult[idx++] = costs[i];
            }
        }

        return finalResult;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();


            ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            // Nhập m cạnh
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();

                // Đồ thị vô hướng
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            // Nhập đỉnh xuất phát
            int start = scanner.nextInt();

            // Gọi hàm tìm đường đi ngắn nhất
            int[] result = findShortestReach(graph, n, start);

            // In kết quả
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
                if (i != result.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}