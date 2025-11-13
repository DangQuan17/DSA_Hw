public class PriorityQueue {
    private int[] queue;
    private int size;
    private int capacity;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.size = 0;
    }

    // Thêm phần tử vào hàng đợi
    public void insert(int x) {
        if (size >= capacity) {
            System.out.println("Queue is full!");
            return;
        }
        queue[size] = x;
        size++;
    }

    // Xóa và trả về phần tử nhỏ nhất
    public int deleteMin() {
        int minIndex = 0;
        for (int i = 1; i < size; i++) {
            if (queue[i] < queue[minIndex]) {
                minIndex = i;
            }
        }

        int minValue = queue[minIndex];

        // Dịch các phần tử sau minIndex sang trái
        for (int i = minIndex; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }

        size--;
        return minValue;
    }

    // In hàng đợi hiện tại
    public void printQueue() {
        for (int i = 0; i < size; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}
