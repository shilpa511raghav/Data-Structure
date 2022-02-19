public class MergeTwoLinkedList {

    static class Node{
        int data;
        Node next;
         Node(int data,Node next){
             this.data = data;
             this.next = next;
         }
    }

    public static Node addNodeAtTheEnd(Node head,int val){
        if(head == null){
            return new Node(val,null);
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
                /*if(current.next == null){
                    current.next = new Node(val,null);
                    break;
                }*/
            }
            current.next = new Node(val,null);
        }
        return head;
    }

    /*public static Node addNodeAtTheEnd(Node head, int val) {
        if (head == null) {
            head = new Node(val, null);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(val, null);

        }
        return head;
    }*/

    public static void printLL(Node head){
        Node current = head;
        while(current.next != null){
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(current.data);
    }

    public static Node MergeTwoSortedLLOriginal(Node l1,Node l2){

        //if(l1 == null || l2 ==null )return l1 != null ? l1:l2;

        Node dummy = new Node(-123,null);
        Node temp = dummy;
        Node c1 = l1;
        Node c2 = l2;
        while(c1!= null && c2 != null){
            if(c1.data < c2.data){
                //temp= addNodeAtTheEnd(temp,p1.data);
                temp.next = c1;
                c1 = c1.next;
            }else{
                //temp = addNodeAtTheEnd(temp,p2.data);
                temp.next = c2;
                c2 = c2.next;
            }
            temp = temp.next;
        }


        temp.next  = c1 != null ?c1:c2;

        /*if(p1 != null){
            //temp = addNodeAtTheEnd(temp,p1.data);
            temp.next = p1;
            p1 = p1.next;
        }
        if(p2 != null){
            //temp = addNodeAtTheEnd(temp,p2.data);
            temp.next = p2;
            p2 = p2.next;
        }*/

        return dummy.next;
    }

    static Node MergeTwoSortedLL(Node n1,Node n2){
       Node dumm= new Node(987,null);
        Node dummyPtr = dumm;

        Node n1Ptr = n1;
        Node n2Ptr = n2;

        while(n1Ptr!= null || n2Ptr != null){
            if(n1Ptr.data < n2Ptr.data){
                dummyPtr.next = n1Ptr;
                n1Ptr = n1Ptr.next;
            }else{
                dummyPtr.next = n2Ptr;
                n2Ptr = n2Ptr.next;
            }
            dummyPtr = dummyPtr.next;
        }
        if(n1Ptr != null){
            dummyPtr.next = n1Ptr;
        }else{
            dummyPtr.next = n2Ptr;
        }
        return dumm.next;
    }

    public static void main(String[] args) {
        /*Node ll1 = new Node(-2,new Node(-1,new Node(12,new Node(64,null))));
        Node ll2 = new Node(-1,new Node(2,new Node(12,new Node(13,new Node(23,null)))));
*/
        Node ll1 = new Node(-1,new Node(1,new Node(2,new Node(12,new Node(17,null)))));
       Node ll2 = new Node(-1,new Node(1,new Node(9,new Node(11,null))));

        Node finalLL = MergeTwoSortedLL(ll1,ll2);
        printLL(finalLL);

    }
}
