public class ReverseLinkedList {
    static Node head;

    public static void main(String[] args) {
        head = new Node(3,new Node(5,new Node(7,null)));

        Node newHead = reverseLinkList(head);
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
        Node temp = null;
        Node cur = head;
        while(cur != null){
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

}
