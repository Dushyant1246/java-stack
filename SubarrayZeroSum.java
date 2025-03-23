import java.util.*;

public class SubarrayZeroSum {
    // Method to Find All Subarrays with Zero Sum
    public static List<int[]> subarraysWithZeroSum(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        map.put(0, new ArrayList<>(Arrays.asList(-1))); // Initialize for zero sum at start

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    result.add(Arrays.copyOfRange(arr, start + 1, i + 1));
                }
            }
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        return result;
    }
    public static void main(String[] args){
        int[] arr = {1, 2, -3, 3, 1, -1};
        System.out.println("Subarrays with Zero Sum: ");
        for (int[] item: subarraysWithZeroSum(arr)){
            for (int val: item){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
/*
Subarrays with Zero Sum:
1 2 -3
-3 3
-3 3 1 -1
1 -1
 */
