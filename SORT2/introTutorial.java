import java.util.*;

public class introTutorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int n = scanner.nextInt();

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        for (int i = 0; i < n; i++) {
            if (arr.get(i) == V) {
                System.out.println(i);
                break;
            }
        }
    }
}
