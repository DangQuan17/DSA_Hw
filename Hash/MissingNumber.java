import java.util.*;

class SolutionMissingHash {
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        Map<Integer, Integer> freqB = new HashMap<>();
        for (int num : brr) {
            freqB.put(num, freqB.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            // Giảm số đếm
            freqB.put(num, freqB.getOrDefault(num, 0) - 1);

            // Nếu số đếm bằng 0, ta có thể xoá nó để tối ưu
            if (freqB.get(num) == 0) {
                freqB.remove(num);
            }
        }


        List<Integer> missing = new ArrayList<>(freqB.keySet());
        Collections.sort(missing);

        return missing;
    }
}