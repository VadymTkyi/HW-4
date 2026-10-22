public class MusicPlayerManager {
    private LinkedList.Node current;
    private LinkedList playlist = new LinkedList();
    private MyHashMap<String, LinkedList.Node> library = new MyHashMap<>(16);
    private MyDeque<LinkedList.Node> upNext = new MyDeque<>();
    private Stack<LinkedList.Node> history = new Stack<>();
    private MyHashMap<String,Integer> playCounts = new MyHashMap<>(16);
    public MusicPlayerManager(){

    }
    public boolean addSong(String id,String title, String artist){
        if (library.containsKey(id)) {
            return false;
        }
        library.put(id,playlist.add(id,title,artist));
        return true;
    }

    public LinkedList.Node findSong(String id){
         return library.get(id);
    }
    public void showPlaylist(){
    }
    public LinkedList.Node play(String id){
        if (!library.containsKey(id)) {
            return null;
        }
        else {
            current = library.get(id);
            return current;
        }
    }
    public void nowPlaying(){
        //return song
    }
    public void playCount(String id){
        //returns int
    }
    public void queueLayer(String id){
    //true or false
    }
    public void queueNext(String id){
        //true or false

    }
    public void showUpNext(){
        //list of titles
    }
    public String next(){
        return null;//temp
    }
    public void back(){
        //returns song
    }
    public void showHistory(){
        //returns list of titles
    }
    public void removeSong(String id){
        //return true/false
    }



}
