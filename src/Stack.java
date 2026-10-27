import java.util.ArrayList;
public class Stack <E>{
    private Node top;
    private int size = 0;

    public Stack(){
        top = null;
    }
    public void push(E e){
        Node node = new Node(e);
        node.next = top;
        top = node;
        size++;

    }
    public E pop(){
        if (top == null){
            return null;
        }
        E val = top.val;

        top = top.next;
        size--;

        return val;
    }
    public E peek(){
        if (top == null){
            return null;
        }
        return top.val;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }
    private class Node{
        private E val;
        private Node next;

       public Node(E val){
           this.val = val;
        }
    }


}