class NodeQ {
    int data;
    NodeQ next;

    NodeQ(int data) {
        this.data= data;
        this.next=null;
    }
}

public class QueueLinked {
    private NodeQ front, rear;

    public QueueLinked() {
        front = rear = null;
    }

    // thêm phần tử vào cuối hàng:
    public void enqueue(int x) {
        NodeQ newNode = new NodeQ(x);
        if (isEmpty()) {
            front = rear = newNode;         // hàng rỗng -> cả 2 trỏ cùng node
        }
        else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // lấy phần tử ở đầu hàng
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue empty!");
            return -1;
        }
        int value = front.data;
        front = front.next; // bỏ node đầu
        if (front == null) rear = null; // nếu rỗng thì reset
        return value;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
