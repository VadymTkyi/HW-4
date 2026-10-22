public class MyDeque<T>{
    private DequeNode head;
    private DequeNode tail;
    private int size = 0;
    public MyDeque(){
       head = null;
       tail = null;
    }
    public void addFirst(T value){
        DequeNode node = new DequeNode(value);

        if (size ==0){
            head = node;
            tail = node;
        }
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }
    public void addLast(T value){
        DequeNode node = new DequeNode(value);

        if (size == 0){
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }
    public int getSize(){
        return size;

    }
    public boolean isEmpty(){
        return size==0;
    }
    public T removeFirst() {
        if (head == null) {
            return null;
        }
        T value = head.value;
        if (head == tail) {
            head = null;
            tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return value;
    }
    public T peekFirst(){
        if (head == null){
            return null;
        }
        return head.value;
    }

    private class DequeNode {
        T value;
        DequeNode next;
        DequeNode prev;

        DequeNode(T value) {
            this.value = value;
        }
    }
}
