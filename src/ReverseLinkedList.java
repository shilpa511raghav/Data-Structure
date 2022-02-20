public class ReverseLinkedList {

    public static void main(String[] args) {

    }

    class Node{
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
