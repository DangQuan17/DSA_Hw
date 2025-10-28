/*
queue là một danh sách kiểu FIFO: first in first out: vào trc ra trc
em cài queue vòng để tận dụng mảng, dùng 2 biến front và rear
"enqueue": muốn thêm phần tử: rear++, arr[rear] = x, count++
"dequeue": muốn xoá ptu: front++, count --;
khi count == capacity: isFull()
khi count == 0 : isEmpty()
 */


public class QueueArray {
    private int[] arr;
    private int front;      // vị trí ptu đầu
    private int rear;       // vị trí ptu cuối
    private int count;      // số phần tử hiện có
    private int capacity;   // kích thước tối đa

    public QueueArray(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    // thêm phần tử vào cuối hàng: enqueue(E): rear++, arr[rear] = e, count++
    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue is Full!");
            return;
        }
        rear = (rear + 1) % capacity;   // nếu tới cuối mảng ->quay lại 0
        arr[rear] = x;
        count++;
    }

    // lấy phần tử ở đầu hàng: dequeue(): front++, count--;

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue empty");
            return -1;
        }
        int value = arr[front];
        front = (front + 1) % capacity;         // front++, quay vòng nếu cần
        count--;
        return value;
    }

    public int peek() {
        if(isEmpty()) return -1;
        return arr[front];
    }

    public boolean isFull() {
        return count == capacity;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
