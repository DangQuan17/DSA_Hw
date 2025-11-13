/*
đề bài: yêu cầu cài đặt Queue bằng cách dùng 2 stack.
phải xử lí 3 thao tác: enqueue, dequeue, peek - giống như queue bình thg
nhưng ko dc dùng queue trực tiếp
-> dùng 2 stack: stackIn: để thêm phần tử: enqueue
stackOut: để lấy phần tử: dequeue, peek
khi cần lấy phần tử đầu, nếu stackOut rỗng thì chuyển toàn bộ phần tử từ stackIn sang stackOut để reverse

tạo class Queue2Stacks với 2 stack
enqueue(X): push vào stack In
dequeue(): nếu stackOut rỗng thì chuyển từ stackIn sang, rồi pop
peek(): giống dequeue nhưng k pop
isEmpty(): ktra cả 2 stack đều rỗng
 */

import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

public class Queue2Stacks {
    private Stack<Integer> stackIn = new Stack<>(); // xử lí enqueue (Thêm)
    private Stack<Integer> stackOut = new Stack<>();// xử lí dequeue and peek

    public void enqueue(int x) {
        stackIn.push(x);
    }

    public int dequeue() {
        shiftStacks();
        return stackOut.pop();
    }

    public void print() {
        shiftStacks();
        if (!stackOut.isEmpty()) {
            System.out.println(stackOut.peek());
        }
    }

    public int peek() {
        shiftStacks();
        return stackOut.peek();
    }

    private void shiftStacks() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }

    public boolean isEmpty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();   // number of queries
        Queue2Stacks queue = new Queue2Stacks();    //hàng đợi mà mình thao tác, sử dụng 2 stack bên trong

        for (int i = 0; i < q; i++) { // vl chạy q lần
            int type = sc.nextInt();
            if (type == 1) {
                int x = sc.nextInt();
                queue.enqueue(x);
            } else if (type == 2) {
                queue.dequeue();
            } else if (type == 3) {
                queue.print();
            }
        }
        sc.close(); // giải phóng tài ng system
    }
}

