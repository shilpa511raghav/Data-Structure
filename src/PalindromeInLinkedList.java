import java.util.Stack;

public class PalindromeInLinkedList {

    public static void main(String[] args) {
        //Node head = new Node(1, new Node(2, new Node(3, new Node(2, new Node(1, null)))));
        //Node head = new Node(1,new Node(3, new Node(3,new Node(2, new Node(1,null)))));
        //Node head = new Node(1,new Node(2, new Node(2,new Node(1,null))));
        //Node head = new Node(1,new Node(2, new Node(2,null)));
        Node head = new Node(1,new Node(2, null));

        //System.out.println(palndromeLLOptimal(head));
    }

    //Using stack with space O(n)
    public static boolean palindromeLL(Node head) {
        Stack<Integer> stk = new Stack<Integer>();
        Node cur = head;
        while (cur != null) {
            stk.push(cur.data);
            cur = cur.next;
        }

        while (head != null) {
            if (head.data != stk.pop()) {
                return false;
            }
            head = head.next;

        }
        return true;

    }

    static Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /*public static boolean palndromeLLOptimal(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node right = reverse(slow.next);
        Node left = head;
        //Node right = prev;
        while (right != null) {
            if (left.data != right.data) {

                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }*/

    static class Node {
        int data;
        Node next;

        Node(int data, Node nxt) {
            this.data = data;
            this.next = nxt;
        }
    }
}
