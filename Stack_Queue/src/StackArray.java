/* cài đặt stack = mảng:
push(e): top++, arr[top] = e;
pop: top--
top/peek: return arr[top]
chú ý: khi ngăn xếp rỗng, thì top = -1  -> isEmpty return top == -1, isFull return top == capacity - 1,
 */
public class StackArray {
    private int[] arr;
    private int top;
    private int capacity;       // kích thước tối đa của stack

    // hàm khởi tạo
    public StackArray(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // thêm ptu vào stack
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack is full!");
        }
        top++;
        arr[top] = x;
    }

    // xoá ptu ra khỏi stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        top--;
        return arr[top];
    }

    // xem phần tử trên cùng
    public int peek() {
        if (isEmpty()) return -1;
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}
