public class QueueCustom {


    private ListNode front;
    private ListNode rear;
    private int length;

    class ListNode{
        int data;
        ListNode next;

        ListNode(int data){
             this.data = data;
             this.next = null;
        }
    }

    //check length of queue;
    public int length(){
        return length;
    }

    //check if queue is empty
    public boolean isEmpty(){
        return length == 0;
    }

    //Add or insert element in queue
    public void enqueue(int data){
        ListNode node = new ListNode(data);
        if(isEmpty()){
            front = node;
        }else{
            rear.next = node;
        }
        rear = node;
        length++;
    }

    // Remove an element
    public int dequeue(){
        if(isEmpty()){
            System.out.println("queue is empty so no node to remove");
        }
        int removedElement = front.data;
        front = front.next;
        if(front == null){
            rear = null;
        }
        length--;
        return removedElement;

    }

    public static void main(String[] args) {
        QueueCustom q = new QueueCustom();
        q.enqueue(1);
        System.out.println("Added 1 in the queue: "+q);
        System.out.println("added an element in queues so size is: "+q.length);
        q.enqueue(55);
        q.enqueue(82);
        System.out.println("Added total 3 elements in queue"+q.toString());
        System.out.println("Added 3 elements in queues so size is: "+q.length);
        q.dequeue();
        System.out.println("After removing a single element size is: "+ q.length);
    }

}
