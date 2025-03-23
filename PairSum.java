import java.util.HashSet;
import java.util.Set;

public class PairSum {
    // Method to Check for a Pair with Given Sum in an Array
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(target - num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
    public static void main(String[] args){
        int[] arr2 = {10, 15, 3, 7};
        System.out.println("Has Pair with Sum 17? " + hasPairWithSum(arr2, 17));
    }
}
/*
Has Pair with Sum 17? true
 */