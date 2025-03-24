import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSumProblem {
    // Method to find two indices such that their values add up to the target
    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // Store value -> index
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{}; // Return empty array if no solution
    }

    public static void main(String[] args) {
        int[] arr4 = {2, 7, 11, 15};
        System.out.println("Two Sum Indices: " + Arrays.toString(twoSum(arr4, 9)));
    }
}
/*
Two Sum Indices: [0, 1]
 */