import java.util.Scanner;

public class ConnectedCells {

    private static int R;
    private static int C;
    private static int[][] grid;
    private static boolean[][] visited;

    private static final int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    private static int count_connected(int row, int col) {
        if (row < 0 || row >= R || col < 0 || col >= C ||
                visited[row][col] || grid[row][col] == 0) {
            return 0;
        }

        visited[row][col] = true;
        int size = 1;

        for (int i = 0; i < 8; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];
            size += count_connected(newRow, newCol);
        }

        return size;
    }

    public static int find_max_region() {
        int maxRegionSize = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int currentRegionSize = count_connected(i, j);
                    if (currentRegionSize > maxRegionSize) {
                        maxRegionSize = currentRegionSize;
                    }
                }
            }
        }
        return maxRegionSize;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        R = scanner.nextInt();
        C = scanner.nextInt();

        grid = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        System.out.println(find_max_region());
    }
}