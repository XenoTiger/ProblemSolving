package stackAndQueues;

import java.util.Stack;

class QueueImpl {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public void add(int data) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(data);
        System.out.println("Pushed: " + data);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        System.out.println("Removed: " + stack1.pop());
        return stack1.pop();
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        System.out.println("Peek: " + stack1.peek());
        return stack1.peek();
    }
}

public class QueueUsingStacks {

    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        queue.remove();
        queue.peek();

    }
}
