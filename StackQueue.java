import java.util.Stack;

public class StackQueue {
    Stack<String> stack1;   // main stack
    Stack<String> stack2;   // extra stack to perform dequeue actions

    // Constructor
    public StackQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Method to add element to queue
    public void add(String data){
        stack1.add(data);
    }

    // Method to remove first element from queue
    public void remove(){
        if (stack1.isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        while (!stack1.isEmpty()){  // reverse stack1 in stack2
            stack2.add(stack1.pop());
        }
        stack2.pop();
        while (!stack2.isEmpty()){  // put data back in stack1 after removing
            stack1.add(stack2.pop());
        }
    }

    // Method to get top element
    public String peek(){
        if (stack1.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        while (!stack1.isEmpty()){  // reverse stack1 in stack2
            stack2.add(stack1.pop());
        }
        String data = stack2.peek();
        while (!stack2.isEmpty()){  // put data back in stack1 after retrieving top element
            stack1.add(stack2.pop());
        }
        return data;
    }

    // Method to check if queue is empty
    public boolean isEmpty(){
        return stack1.isEmpty();
    }

    // Method to print queue
    public void printQueue(){
        if (stack1.isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        while (!stack1.isEmpty()){  // reverse stack1 in stack2
            String data = stack1.pop();
            System.out.print(data + " ");
            stack2.add(data);
        }
        System.out.println();
        while (!stack2.isEmpty()){  // put data back in stack1
            stack1.add(stack2.pop());
        }
    }
}
/*
StackQueue stackQueue = new StackQueue();
stackQueue.add("A");
stackQueue.add("B");
stackQueue.add("C");
stackQueue.add("D");

System.out.print("Queue Elements: ");
stackQueue.printQueue();

stackQueue.remove();
System.out.print("Queue Elements after removing: ");
stackQueue.printQueue();

System.out.println("Top element : " + stackQueue.peek());
System.out.println("Is Queue empty? " + stackQueue.isEmpty());

Queue Elements: D C B A
Queue Elements after removing: D C B
Top element : B
Is Queue empty? false
 */