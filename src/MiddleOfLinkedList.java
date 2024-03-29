public class MiddleOfLinkedList {
    public static void main(String[] args) {
        //Node head = new Node(1,new Node(2,new Node(3,new Node(4, new Node(5,null)))));
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, null))));
        Node middleNode = middle(head);
        printLL(middleNode);

    }

    static void printLL(Node head) {
        Node cur = head;
        while (cur.next != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
        System.out.println(cur.data);
    }

    public static Node middle(Node head) {

        Node cur = head;
        int totalCount = 0;
        while (cur != null) {
            totalCount++;
            cur = cur.next;
        }

        totalCount = totalCount / 2 + 1;
        Node curPtr = head;
        for (int i = 1; i < totalCount; i++) {
            curPtr = curPtr.next;
        }
        return curPtr;
    }


    //Slow fast pointer approach for middle O(n) space and O(1) time complexity
    public static Node middleOptimal(Node head){
        Node slow = head;
        Node fast = head;

        if(head == null){
            return head;
        }

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static class Node {
        int data;
        Node next;

        Node(int data, Node nxt) {
            this.data = data;
            this.next = nxt;
        }
    }
}
