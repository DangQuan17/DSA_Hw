/*
Có 3 ngăn xếp (stack), mỗi ngăn có các hình trụ có chiều cao khác nhau.
Mỗi hình trụ có chiều cao nguyên dương.
Ta chỉ được bỏ hình trụ ở đỉnh của mỗi stack.
Hỏi: chiều cao lớn nhất mà 3 stack có thể bằng nhau (sau khi bỏ một số hình trụ ở trên).
 */
import java.util.*;

public class EqualStacks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //kích thước 3 stack
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        //mỗi mảng chứa chiều cao hình trụ, theo thứ tự stack.
        int[] h1 = new int[n1];
        int[] h2 = new int[n2];
        int[] h3 = new int[n3];

        //dùng 3 vòng for để đọc giá trị 3 mảng
        for (int i = 0; i < n1; i++) h1[i] = sc.nextInt();
        for (int i = 0; i < n2; i++) h2[i] = sc.nextInt();
        for (int i = 0; i < n3; i++) h3[i] = sc.nextInt();

        // tính tổng chiều cao ban đầu mỗi stack
        int sum1 = Arrays.stream(h1).sum();
        int sum2 = Arrays.stream(h2).sum();
        int sum3 = Arrays.stream(h3).sum();

        // chỉ số, đóng vai trò là con của đỉnh cho mỗi stack
        int i1 = 0, i2 = 0, i3 = 0;

        while (true) {
            // nếu một stack hết -> không thể bằng nhau
            if (i1 == n1 || i2 == n2 || i3 == n3) {
                System.out.println(0);
                break;
            }

            // nếu 3 tổng bằng nhau -> in ra và dừng
            if (sum1 == sum2 && sum2 == sum3) {
                System.out.println(sum1);
                break;
            }

            // bỏ phần tử ở stack có sum cao nhất
            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= h1[i1++];       // trừ đi chiều cao đỉnh hiện tại
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= h2[i2++];
            } else {
                sum3 -= h3[i3++];
            }
        }

        sc.close();
    }
}
