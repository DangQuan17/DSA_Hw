import java.util.*;

class SolutionPairs {

    public static int pairs(int k, List<Integer> arr) {
        Set<Integer> set = new HashSet<>(arr);
        int count = 0;
        for (int x : arr) {
            int smaller = x - k;
            int larger = x + k;
            if (set.contains(larger)) {
                count++;
            }
        }
        return count;
    }
}