import java.util.*;

class LRU {
    HashMap<Integer, Node> map;
    int capacity = 0;
    Node head = new Node(0, 0), tail = new Node(0, 0);

    LRU(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            remove(map.get(key));
            insert(map.get(key));
            return map.get(key).val;

        } else
            return -1;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        } else if (map.size() == capacity) {
            System.out.println("removing tail Key " + tail.prev.key);
            remove(tail.prev);
        }
        Node curr = new Node(key, val);
        insert(curr);
    }

    public void remove(Node curr) {
        map.remove(curr.key);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        return;
    }

    public void insert(Node curr) {
        map.put(curr.key, curr);
        head.next.prev = curr;
        curr.next = head.next;
        curr.prev = head;
        head.next = curr;
    }

}

class Node {
    int val, key;
    Node next, prev;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}