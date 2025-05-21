package linkedList;

public class DetectCycle {

    private static boolean detectCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);

        linkedList.traverse();
        System.out.println();

        linkedList.head.next.next.next = linkedList.head.next;  //3-->2
        System.out.println(detectCycle(linkedList.head));
    }
}
