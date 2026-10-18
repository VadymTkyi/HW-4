public class LinkedList {
    node head;
    node tail;
    int size = 0;
    public LinkedList(){
    }

    public void add(node song){
        if (head==null){

        }
    }




    private class node{
       String songName = null;
       String id = null;
       String artist = null;
       node prev;
       node next;

       public node(String id, String songName, String artist){
           this.id = id;
           this.songName = songName;
           this.artist = artist;
       }

    }
}
