package linkedList;

public class MiddleOfLinkedList {

    private static Node middleOfLinkedList(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);
        linkedList.insert(6);

        linkedList.traverse();
        System.out.println();

        System.out.println("Middle of LinkedList -> " + middleOfLinkedList(linkedList.head).data);

    }
}
