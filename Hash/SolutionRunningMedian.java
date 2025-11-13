import java.util.*;

class Element implements Comparable<Element> {
    int value;
    int id;

    Element(int value, int id) {
        this.value = value;
        this.id = id;
    }

    @Override
    public int compareTo(Element other) {
        if (this.value != other.value) {
            return Integer.compare(this.value, other.value);
        }
        return Integer.compare(this.id, other.id);
    }
}

class SolutionRunningMedian {

    private static Element findKthElement(TreeSet<Element> set, int k) {
        int count = 0;
        for (Element e : set) {
            if (count == k) {
                return e;
            }
            count++;
        }
        return null;
    }

    public static List<Double> runningMedian(List<Integer> a) {

        TreeSet<Element> set = new TreeSet<>();
        List<Double> medians = new ArrayList<>();
        int count = 0; // Tổng số phần tử

        for (int num : a) {
            set.add(new Element(num, count));
            count++;

            int totalSize = count;

            if (totalSize % 2 == 1) {
                // Số lẻ: Trung vị là phần tử đứng giữa (chỉ số (totalSize - 1) / 2)
                int medianIndex = totalSize / 2;
                Element medianElement = findKthElement(set, medianIndex);
                medians.add((double) medianElement.value);
            } else {
                // Số chẵn: Trung vị là trung bình cộng của hai phần tử đứng giữa
                int index1 = totalSize / 2 - 1;
                int index2 = totalSize / 2;

                Element e1 = findKthElement(set, index1);
                Element e2 = findKthElement(set, index2);

                double median = (e1.value + e2.value) / 2.0;
                medians.add(median);
            }
        }
        return medians;
    }
}