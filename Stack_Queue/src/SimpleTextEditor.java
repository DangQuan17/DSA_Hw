/*
một chuỗi S, ban đầu rỗng (“”). Thực hiện Q thao tác, mỗi thao tác thuộc một trong 4 loại:
1 W — append: thêm chuỗi W vào cuối S.
2 k — delete: xóa k ký tự cuối của S.
3 k — print: in ký tự thứ k của S
4 — undo: hoàn tác (undo) thao tác gần nhất (chưa bị undo) của loại 1 hoặc loại 2.
 */
import java.util.*;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();   // số thao tác
        StringBuilder S = new StringBuilder();  // chuỗi chính, dùng hiệu quả hơn string vì ít phải tạo đối tg mới
        Stack<String> history = new Stack<>();  // lưu trạng thái cũ để undo

        for (int i = 0; i < Q; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                // 1 W -> thêm chuỗi W vào cuối
                String W = sc.next();
                history.push(S.toString()); // lưu trạng thái trước khi thay đổi
                S.append(W);
            }
            else if (type == 2) {
                // 2 k -> xóa k ký tự cuối
                int k = sc.nextInt();
                history.push(S.toString()); // lưu trạng thái trước khi thay đổi
                S.delete(S.length() - k, S.length());
            }
            else if (type == 3) {
                // 3 k -> in ký tự thứ k
                int k = sc.nextInt();
                System.out.println(S.charAt(k - 1)); //java đánh số từ 0 nên phải trừ 1
            }
            else if (type == 4) {
                // 4 -> undo: quay lại trạng thái trước đó
                if (!history.isEmpty()) {
                    S = new StringBuilder(history.pop());
                }
            }
        }
        sc.close();
    }
}
