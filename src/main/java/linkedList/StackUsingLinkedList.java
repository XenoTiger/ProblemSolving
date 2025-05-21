package linkedList;

public class StackUsingLinkedList {
    static Node top;

    StackUsingLinkedList() {
        top = null;
    }

    public static boolean isEmpty() {
        return top == null;
    }

    private static void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        System.out.println("Pushed data: " + data);
    }

    private static void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        int val = top.data;
        top = top.next;
        System.out.println("Popped : " + val);
    }

    private static void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        }
        System.out.println("Peek : " + top.data);
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        push(10);
        push(20);

        pop();

        peek();
    }

}
