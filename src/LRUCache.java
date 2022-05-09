import java.util.HashMap;

public class LRUCache {

    static class Node{
        int key;
        int val;
        Node prev;
        Node next;

        Node(int k, int v){
            this.key = k;
            this.val = v;
            this.prev = null;
            this.next = null;
        }
    }

    static int capacity;
    static Node head;
    static Node tail;
    static HashMap<Integer,Node> cache;

    //initialization
    LRUCache(int capacity){
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(-22,78);
        tail = new Node(-23,-23);
        head.next = tail;
        tail.prev = head;
    }

    public static int get(int key){
        if(cache.containsKey(key)){
            Node cur = cache.get(key);
            moveToFrontInLL(cur);
            return cur.val;
        }
        return -1;
    }

    //Add in first of LL
    public static void addNodeToFirstInLL(Node cur){
        Node nbr1 = head.next;
        head.next = cur;
        cur.prev = head;
        cur.next = nbr1;
        cur.next.prev = cur;
    }

    //break connection from LL
    public static void removeLastNodeFromLL(Node node){
        Node prevNbr = node.prev;
        Node nextNbr = node.next;

        prevNbr.next = nextNbr;
        nextNbr.prev = prevNbr;

    }

    public static void moveToFrontInLL(Node node){
        removeLastNodeFromLL(node);
        addNodeToFirstInLL(node);
    }


    public static void put(int key, int value){
        Node node = cache.get(key);
        Node newNode = new Node(key,value);
        //if node not exist already hashmap return null
        if(node == null){
            if(cache.size()== capacity){
                Node LRUNode = tail.prev;
                cache.remove(LRUNode.key);
                removeLastNodeFromLL(LRUNode);

            }
            cache.put(key,newNode);
            addNodeToFirstInLL(newNode);

        }else{
            node.val = value;
            //cache.put(key,newNode); alternate of above line
            moveToFrontInLL(newNode);
        }

    }



    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1); // cache is {1=1}
        lruCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lruCache.get(1));    // return 1

        lruCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lruCache.get(2));    // returns -1 (not found)
        lruCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lruCache.get(1));    // return -1 (not found)
        System.out.println(lruCache.get(3));    // return 3
        System.out.println(lruCache.get(4));    // return 4
    }

}
