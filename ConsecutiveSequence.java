import java.util.HashSet;
import java.util.Set;

public class ConsecutiveSequence {
    // Method to Find Longest Consecutive Sequence
    public static int longestConsecutiveSequence(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int maxLength = 0;
        for (int num : arr) {
            if (!set.contains(num - 1)) { // Start of a sequence
                int length = 0;
                while (set.contains(num + length)) {
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr3 = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence: " + longestConsecutiveSequence(arr3));
    }
}
/*
Longest Consecutive Sequence: 4
 */