import java.util.Stack;

public class StackSort {
    public static void sortStack(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int top = stack.pop();
        sortStack(stack);
        insertInSortedOrder(stack, top);
    }

    private static void insertInSortedOrder(Stack<Integer> stack, int item){
        if (stack.isEmpty() || stack.peek() <= item){
            stack.push(item);
            return;
        }

        int top = stack.pop();
        insertInSortedOrder(stack, item);
        stack.push(top);
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}
/*
Original Stack: [3, 1, 4, 2]
Sorted Stack: [1, 2, 3, 4]
 */