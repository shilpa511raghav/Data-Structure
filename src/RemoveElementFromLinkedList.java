public class RemoveElementFromLinkedList {
    public static void main(String[] args) {
        //ListNode head = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(2, new ListNode(5,null))))));
        //ListNode head = new ListNode(2,new ListNode(2, new ListNode(2, new ListNode(2, new ListNode(2, new ListNode(2,null))))));
        ListNode head = new ListNode(2,null);
        ListNode outputListNode = removeElementFromLL(head,2);
        //System.out.println(outputListNode);
        printLinkList(outputListNode);
    }

    static class ListNode {
        int data ;
        ListNode next;

        ListNode(int data,ListNode nxt){
            this.data = data;
            this.next = nxt;
        }
    }

    public static void printLinkList(ListNode head ){
        if(head == null){
            return;
        }
        ListNode cur = head;
        while(cur.next != null){
            System.out.println(cur.data);
            cur = cur.next;
        }
        System.out.println(cur.data);

    }

    public static ListNode removeElementFromLL(ListNode head, int val){
        if(head == null){
            return head;
        }
        ListNode cur = head;
        ListNode dummy = new ListNode(-234343,head);
        ListNode prev = dummy;
        while(cur != null){
            ListNode nxt = cur.next;
            if(cur.data == val){
                prev.next = nxt;
            }else{
                prev = cur;
            }
            cur = nxt;
        }

        return dummy.next;

    }


    public static ListNode removemElement(ListNode head, int val){
        if (head == null){
            return head;
        }

        ListNode cur = head;
        ListNode dummy = new ListNode(-748485,null);
        ListNode prev = dummy;
        while(cur != null){
            //ListNode nxt = cur.next;
            if(cur.data == val){
                prev.next = cur.next;
            }else{
                prev = cur;
            }
            cur = cur.next;
        }

        return dummy.next;
    }


   /* public static ListNode recursiveRemoveElelementFromLL(ListNode head, int val){

        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = recursiveRemoveElelementFromLL(head.next,val);

    }*/
}
