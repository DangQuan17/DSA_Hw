/*
dùng linkedlist, mỗi node có data và next
top trỏ đến node đầu tiên (Đỉnh stack)
push: tạo node mới, trỏ vào top, rồi cập nhật top
pop: lấy dữ liệu node đầu, bỏ nó đi

-> ưu điểm: ko giới hạn kích thước như mảng!
 */


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class StackLinked {
    private Node top;       // node trên cùng của stack
    public StackLinked() {
        top = null;
    }

    //thêm phần tử:
    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;     // node ms trỏ vào node hiện tại
        top = newNode;
    }

    //xoá ptu trên cùng:
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        int value = top.data;       //lấy dữ liệu
        top = top.next;             // bỏ node đầu
        return value;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
