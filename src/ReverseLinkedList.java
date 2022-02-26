public class ReverseLinkedList {
    static Node head;

    public static void main(String[] args) {
        head = new Node(3,new Node(5,new Node(7,new Node (12,new Node (31,null)))));
        //head = new Node(3,new Node(5,new Node(7,new Node (12,new Node (31,new Node(10,null))))));
        //Node newHead = reverseRecursion(head);
        Node newHead = reverseLinkList(head);
        //Node newHead = revLL(head);
        printLL(newHead);
    }

    static void printLL(Node head){
        Node cur = head;
        while(cur.next != null){
            System.out.println(cur.data);
            cur = cur.next;
        }
        System.out.println(cur.data);
    }

    static class Node{
        int data;
        Node next;

        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    public static Node reverseLinkList(Node head){
        Node prev = null;
        Node cur = head;
        while(cur != null){
            Node temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }


    public static Node reverseRecursion(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node newHead = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //insted of taking current  pointer head moved as head will became last node after reversal
    public static Node revLL(Node head){
        Node prev = null;
        while(head != null){
          Node  temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
