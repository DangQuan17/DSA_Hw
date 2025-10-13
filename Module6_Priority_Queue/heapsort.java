import edu.princeton.cs.algs4.Heap;

public class heapsort {
    public static void main(String[] args) {
        String[] a = {"D", "A", "N", "G", "Q", "U", "A", "N"};
        Heap.sort(a);

        for (String s : a) {
            System.out.print(s + " ");
        }
    }
}
