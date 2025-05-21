package linkedList;

public class MergeTwoSortedLinkedLists {

    private static Node mergeTwoSortedLinkedLists(Node l1, Node l2) {
        Node dummy = new Node();
        Node temp = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 != null ? l1 : l2;
        return dummy.next;
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
        linkedList2.insert(3);
        linkedList2.insert(4);
        linkedList2.insert(5);
        linkedList2.insert(6);

        linkedList2.traverse();
        System.out.println();

        LinkedList result = new LinkedList();
        result.head = mergeTwoSortedLinkedLists(linkedList1.head, linkedList2.head);
        result.traverse();
    }
}
