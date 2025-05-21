package linkedList;

public class ReverseLinkedList {

    private static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);

        linkedList.traverse();
        System.out.println();
        System.out.println("reverse linked list");
        linkedList.head = reverse(linkedList.head);
        linkedList.traverse();
    }
}
