import edu.princeton.cs.algs4.MinPQ;

public class testMinPQ {
    public static void main(String[] args) {
        MinPQ<Integer> pq = new MinPQ<>();
        pq.insert(10);
        pq.insert(5);
        pq.insert(20);

        System.out.println("Min = " + pq.delMin());
    }
}
