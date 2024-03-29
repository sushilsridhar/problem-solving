package linkedlist.adv;

/*
    Given a singly linked list, delete middle of the linked list.
    For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5

    If there are even nodes, then there would be two middle nodes, we need to delete the second middle element.
    For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.

    Return the head of the linked list after removing the middle node.
    If the input linked list has 1 node, then this node should be deleted and a null node should be returned.

    bruteforce:
    iterate and find the size of the array and find the middle
    iterate upto middle to delete the element

    optimized: two pointer approach, slow faster pointer approach

    every iteration
    1. increment pointer1 once
    2. increment pointer2 twice,

    by the time pointer2 reaches end of the list, pointer1 will be in the middle

    tc: O(n/2)
 */
public class DeleteMiddle {

    // tc: O(n/2)
    public static ListNode twoPointers(ListNode A) {

        ListNode head = A;

        ListNode pointer = head;
        ListNode pointer2 = head;
        ListNode prev = null;

        while(pointer2.next != null && pointer2.next.next != null) {
            prev = pointer;
            pointer = pointer.next;
            pointer2 = pointer2.next.next;
        }

        if(pointer2.next == null) {
            if(prev == null) {
                head = head.next;
                return head;
            }
            prev.next = pointer.next;
        } else {
            prev = pointer;
            pointer = pointer.next;

            prev.next = pointer.next;
        }

        return head;
    }

    // tc: O(n + n/2)
    private static ListNode bruteForce(ListNode A) {

        ListNode head = A;

        ListNode pointer1 = head;
        int size = 0;

        while(pointer1 != null) {
            size++;
            pointer1 = pointer1.next;
        }

        if(size == 1) {
            A = A.next;
            return A;
        }

        int k = (size-1)/2;
        if((size & 1) == 0) {
            k++;
        }

        ListNode prev = null;
        ListNode pointer2 = head;
        int i=0;
        while(i<k) {
            prev = pointer2;
            pointer2 = pointer2.next;
            i++;
        }

        prev.next = pointer2.next;


        return head;
    }

    public static void main(String[] args) {

        ListNode head = createLinkedList();
        printLinkedList(head);

        ListNode updatedList = twoPointers(head);
        printLinkedList(updatedList);

        ListNode head2 = createLinkedListOdd();
        printLinkedList(head2);

        ListNode updatedList2 = twoPointers(head2);
        printLinkedList(updatedList2);

    }

    /* ----------------------------------------------------------------------------- */
    /* ------------------------------------ HELPER --------------------------------- */
    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    private static ListNode createLinkedList() {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);


        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        return head;
    }

    private static ListNode createLinkedListOdd() {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        return head;
    }

    private static void printLinkedList(ListNode head) {
        ListNode pointer = head;

        while(pointer != null) {
            System.out.print(pointer.val+" --> ");
            pointer = pointer.next;
        }
        System.out.print("null");
        System.out.println("");
    }
}
