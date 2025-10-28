/*
“Em sẽ tạo lớp Element chứa value và priority.
 Khi thêm phần tử (enqueue), em đưa vào cuối mảng.
 Khi lấy ra (dequeue), em duyệt mảng để tìm phần tử có độ ưu tiên cao nhất,
 rồi xóa nó bằng cách ghi đè bằng phần tử cuối và giảm size.”
 */

class Element {
    int value;
    int priority;
    public Element(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }
}

public class PriorityQueueArray {
    private Element[] arr;
    private int size;
    private int capacity;

    public PriorityQueueArray(int capacity) {
        this.capacity = capacity;
        arr = new Element[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    // thêm phần tử mới
    public void enqueue(int value, int priority) {
        if (isFull()) return;
        arr[size++] = new Element(value, priority);
    }

    // lấy phần tử có độ ưu tiên cao nhất
    public int dequeue() {
        if (isEmpty()) return -1;
        int highest = 0;
        for (int i = 1; i < size; i++) {
            if (arr[i].priority > arr[highest].priority)
                highest = i;
        }
        int result = arr[highest].value;
        arr[highest] = arr[size - 1]; // xóa phần tử đó
        size--;
        return result;
    }
}
