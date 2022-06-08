public class AddTwoNumbersLL {
    public static void main(String[] args) {
       /* Node l1 = new Node(2,new Node(4,new Node(3,null)));
        Node l2 = new Node(5,new Node(6,new Node(4,null)));*/

        /*Node l1 = new Node(0,null);
        Node l2 = new Node(0,null);*/

        Node l1 = new Node(9,new Node(9,new Node(9,new Node(9,new Node(9,new Node(9,new Node(9,new Node(9,null))))))));
        Node l2 = new Node(9,new Node(9,new Node(9,new Node(9,new Node(9,new Node(9,new Node(9,null)))))));

        Node res = addTwoNumberLL(l1,l2);
        printLinkedList(res);
    }

    static class Node{
        int data;
        Node next;
        Node(int data,Node next){
            this.data = data;
            this.next = next;
        }
    }

    public static void printLinkedList(Node head){
        if(head == null ) {
            System.out.println("list is empty");
            return;
        }
        Node cur = head;
        while(cur!= null){
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public static Node addTwoNumberLL(Node l1, Node l2) {
        if (l1 == null && l2 == null) return new Node(0, null);
        Node n1  =l1;
        Node n2 = l2;
        Node headDummyRes = new Node(0,null);
        Node result = headDummyRes;
        int sum;
        int carry = 0;
        while(l1 != null || l2!= null){
            int data1 = l1 != null ? l1.data : 0;
            int data2 = l2 != null ? l2.data : 0;
            sum = (data1 + data2 + carry )%10;

            result.next = new Node(sum,null);
            result = result.next;
            carry = (data1 + data2 + carry)/10;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;

        }
        if(carry>0){
            result.next  = new Node(carry,null);
        }
        return headDummyRes.next;
    }



    public static Node addNumLL(Node node1, Node node2){
        if(node1 == null && node2 == null) return new Node(0,null);
        Node resDummyNode = new Node(-78765,null);
        Node result = resDummyNode;
        Node l1 = node1;
        Node l2 = node2;
        int sum;
        int carry = 0;
        while(l1 != null || l2!= null){
            int data1 = l1  != null ? l1.data:0;
            int data2 = l2!= null ? l2.data:0;
            sum = data1+data2+carry;
            result.next = new Node(sum%10,null);
            carry = sum/10;
             if(l1 != null ) l1 = l1.next;
             if (l2 != null) l2 = l2.next;
        }
        if(carry > 0) result.next = new Node(carry,null);
        return  resDummyNode.next;

    }

}
