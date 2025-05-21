package linkedList;

public class IntersectionOfLinkedLists {

    private static int getSize(Node head) {
        Node temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    private static Node getIntersectionPoint(Node l1, Node l2) {
        int sizeA = getSize(l1);
        int sizeB = getSize(l2);

        if (l1 == null || l2 == null) {
            return null;
        }

        int delta = Math.abs(sizeA - sizeB);

        if (sizeA > sizeB) {
            for (int i = 0; i < delta; i++) {
                l1 = l1.next;
            }
        } else {
            for (int i = 0; i < delta; i++) {
                l2 = l2.next;
            }
        }

        while (l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }

    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList();
        linkedList1.insert(1);
        linkedList1.insert(2);
        linkedList1.insert(3);
        linkedList1.insert(4);

        linkedList1.traverse();
        System.out.println();

        LinkedList linkedList2 = new LinkedList();
        linkedList2.insert(5);
        linkedList2.insert(6);

        // Create an intersection at node with value 3
        linkedList2.head.next.next = linkedList1.head.next.next;
        linkedList2.traverse();
        System.out.println();

        Node result = getIntersectionPoint(linkedList1.head, linkedList2.head);
        System.out.println(result.data);
    }
}
