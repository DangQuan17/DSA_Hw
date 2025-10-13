import edu.princeton.cs.algs4.MaxPQ;

public class testMaxPQ {
    public static void main(String[] args) {
        MaxPQ<Integer> pq = new MaxPQ<>();
        pq.insert(10);
        pq.insert(20);
        pq.insert(15);

        System.out.println("Max = " + pq.delMax());
    }
}
