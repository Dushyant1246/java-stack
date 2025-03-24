import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// Method to get a list of maximums of a sliding window
public class WindowMaximum {
    public static int[] getSlidingWindowMaximum(int[] array, int k){
        int[] result = new int[array.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0 ; i < array.length ; i++){
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1){
                deque.pollFirst();
            }
            while (!deque.isEmpty() && array[deque.peekLast()] < array[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i >= k - 1){
                result[i - k + 1] = array[deque.peekFirst()];
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = getSlidingWindowMaximum(arr, k);
        System.out.println(Arrays.toString(result));
    }
}
