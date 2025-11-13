/*
Tóm tắt: Kiểm tra xem các dấu đóng mở ngoặc {[()]} có đúng qui tắc hay không.
- dùng stack, khi gặp dấu mở -> push vào stack
              khi gặp dấu đóng ->
              kiểm tra xem có ptu tương ứng ở đỉnh stack ko,
              nếu có thì pop ra, nếu ko thì chuỗi ko hợp lệ
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return "NO";
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return "NO";
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }
}

