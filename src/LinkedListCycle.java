import java.util.LinkedList;

public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(6);
        ListNode fourth = new ListNode(9);
        head.next = second;
        second.next = third;
        third.next = fourth;
        //fourth.next = head;

        System.out.println(hasCycle(head));
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slowMover = head;
        ListNode fastMover = head;
        if (head == null|| head.next == null ) return false;

        while (fastMover != null && slowMover.next != null && fastMover.next != null) {
            slowMover = slowMover.next;
            fastMover = fastMover.next.next;
            if (slowMover == fastMover) {
                return true;
            }
        }
        return false;
    }
}
