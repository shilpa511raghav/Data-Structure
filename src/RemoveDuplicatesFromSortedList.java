public class RemoveDuplicatesFromSortedList {


    static rNode head;
    static class rNode{
        int data;
        rNode next;

        rNode(int data , rNode nxt){
            this.data = data;
            this.next = nxt;
        }
    }


    public static void printLLN(rNode head){
        if(head == null){
            System.out.println("empty node");
            return;
        }
        rNode curPtr = head;
        while(curPtr.next != null){
            System.out.println(curPtr.data);
            curPtr = curPtr.next;
        }
        System.out.println(curPtr.data);
    }

    public static void main(String[] args) {
        //head = new rNode(1,new rNode(2,new rNode(2,new rNode(2,new rNode(3,new rNode(3,new rNode(4,null)))))));
        //rNode head = new rNode(1,new rNode(1,new rNode(2,new rNode(3,new rNode(3,null)))));
        //rNode head = new rNode(1,new rNode(1,null));
        rNode head = new rNode(1,new rNode(1,new rNode(2, new rNode(3,new rNode(3,null)))));
        //Node head = null;

        /*rNode fourth = new rNode(2,null);
        rNode third = new rNode(2,fourth);
        rNode second = new rNode(1,third);
        rNode head = new rNode(1,second);*/



        rNode  my = removeDuplicatesFromLL(head);
        printLLN(my);
    }

    public static rNode removeDuplicatesFromLL(rNode n1){
        if(n1 == null){
            return n1;
        }
        rNode curPtr = n1;

        while(curPtr.next != null ){
            if(curPtr.data == curPtr.next.data){
                curPtr.next = curPtr.next.next;
            }else{
                curPtr = curPtr.next;
            }
        }
        return n1;
    }

}
