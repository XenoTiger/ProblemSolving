package stackAndQueues;
/*
Implement a stack that supports push, pop, top, and retrieving the min and max element.
 */
class Stack {
    private int[] arr;
    private int[] minStack;
    private int[] maxStack;
    private int top;
    private int capacity;

    public Stack(int size) {
        arr = new int[size];
        minStack = new int[size];
        maxStack = new int[size];
        capacity = size;
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        top++;
        arr[top] = data;
        System.out.println("pushed: " + data);
        if(top == 0){
            minStack[top] = data;
            maxStack[top] = data;
        }else {
            minStack[top] = Math.min(data, minStack[top-1]);
            maxStack[top] = Math.max(data, maxStack[top-1]);
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        int val = arr[top];
        top--;
        System.out.println("popped: " + val);
        return val;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        System.out.println("peek: " + arr[top]);
        return arr[top];
    }

    public int getMin(){
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        System.out.println("Min element: " + minStack[top]);
        return minStack[top];
    }

    public int getMax(){
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        System.out.println("Max element: " + maxStack[top]);
        return maxStack[top];
    }
}

public class StackUsingArray {
    public static void main(String[] args) {
        Stack stack = new Stack(3);
        stack.push(1);
        stack.push(5);
        stack.push(3);
        stack.push(2);
        stack.pop();
        stack.push(3);
        stack.peek();

        stack.getMin();
        stack.getMax();

    }
}
