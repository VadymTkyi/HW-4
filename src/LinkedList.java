import java.util.List;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;
    public LinkedList(){
    }

    public Node add(String id, String title, String artist){
        Node song = new Node(id,title,artist);
        if (head==null) {
            head = song;
            tail = song;
        }
        else {
            tail.next = song;
            song.prev = tail;
            tail = song;
        }
        size++;
        return song;
    }
    public void remove(Node song){
        if (head == null){
            return;
        }
        if (song == head && song == tail){
           head = null;
           tail = null;
        }
        else if (song == tail){
            song.prev.next = null;
            tail = song.prev;
        }
        else if (song == head){
            song.next.prev = null;
            head = song.next;
        }
        else {
            song.next.prev = song.prev;
            song.prev.next = song.next;
        }
        size--;
    }
    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }




    public class Node{
      private String title = null;
      private String id = null;
      private String artist = null;
      private Node prev;
      private Node next;

       public Node(String id, String title, String artist){
           this.id = id;
           this.title = title;
           this.artist = artist;
       }
        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getArtist() {
            return artist;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }
    }
}
