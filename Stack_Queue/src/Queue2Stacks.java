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

import java.util.Stack;

public class Queue2Stacks {
    private Stack<Integer> stackIn = new Stack<>();
    private Stack<Integer> stackOut = new Stack<>();

    public void enqueue(int x) {
        stackIn.push(x);
    }
    public int dequeue() {
        shiftStacks();
        return stackOut.pop();
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
}

