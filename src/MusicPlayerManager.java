import java.net.IDN;
import java.util.ArrayList;
import java.util.List;

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
    public List<String> showPlaylist(){
        List<String> result = new ArrayList<>();
        LinkedList.Node temp = this.playlist.getHead();
        while (temp!=null){
            result.add(temp.getTitle());
            temp=temp.getNext();
        }
        return result;
    }
    private List<String> showPlaylistId(){
        List<String> result = new ArrayList<>();
        LinkedList.Node temp = this.playlist.getHead();
        while (temp!=null){
            result.add(temp.getId());
            temp=temp.getNext();
        }
        return result;
    }
    public LinkedList.Node play(String id){
        if (!library.containsKey(id)) {
            return null;
        }
        if (current != null){
            history.push(current);
        }
        current = library.get(id);
        if (playCounts.get(id) ==null){
            playCounts.put(id,1);
        }
        else {
            playCounts.put(id,playCounts.get(id)+1);
        }
        return current;

    }
    public LinkedList.Node nowPlaying(){
        return current;
    }
    public int playCount(String id){
        if (playCounts.get(id)==null){
            return 0;
        }
        else return playCounts.get(id);
    }
    public boolean queueLater(String id){
        if (library.get(id)!=null){
            upNext.addLast(library.get(id));
            return true;
        }
        return false;
    }
    public boolean queueNext(String id){
        if (library.get(id)!=null){
            upNext.addFirst(library.get(id));
            return true;
        }
        return false;

    }
    public List<String> showUpNext(){
        List<String> result = new ArrayList<String>();
        MyDeque<LinkedList.Node> temp = new MyDeque<>();
        while (!upNext.isEmpty()){
            LinkedList.Node song = upNext.removeFirst();
            if (library.containsKey(song.getId())) {
                result.add(song.getTitle());
                temp.addLast(song);
            }
        }
        while (!temp.isEmpty()){
            upNext.addLast(temp.removeFirst());
        }
        return result;
    }
    public LinkedList.Node next(){
        LinkedList.Node next;
        while (!upNext.isEmpty()&&!library.containsKey(upNext.peekFirst().getId())){
            upNext.removeFirst();
        }
        if (!upNext.isEmpty()) {
            next = upNext.removeFirst();
        }
        else {
            if (current == null){
                return null;
            }
            next = current.getNext();
            if (next ==null){
                return null;
            }
        }
        if (current!= null){
            history.push(current);
        }
        current = next;
        playCounts.put(next.getId(),playCount(next.getId())+1);

        return current;
    }
    public LinkedList.Node back(){
        LinkedList.Node prev;
        while (!history.isEmpty() && !library.containsKey(history.peek().getId())) {
            history.pop();
        }
        if (history.isEmpty()){
            return null;
        }
        prev = history.pop();
        if (current!=null){
            upNext.addFirst(current);
        }
        current = prev;
        playCounts.put(current.getId(),playCount(current.getId())+1);
        return current;
    }
    public List<String> showHistory(){
        List<String> result = new ArrayList<>();
        Stack<LinkedList.Node> temp = new Stack<>();
       while (!history.isEmpty()){
           LinkedList.Node song = history.pop();
            if (library.containsKey(song.getId())){
                result.add(song.getTitle());
                temp.push(song);
            }
       }

       while (!temp.isEmpty()){
           history.push(temp.pop());
       }
       return result;
    }
    public boolean removeSong(String id){
        LinkedList.Node song = library.get(id);
        if (song==null||song==current){
            return false;
        }
        playlist.remove(song);
        playCounts.remove(id);
        library.remove(id);

        return true;
    }
    public List<String> topSongs(int n){
        List<String> ids = showPlaylistId();
        ids.sort((id1,id2)->Integer.compare(playCount(id2),playCount(id1)));
        List<String> result = new ArrayList<>();

        for (int i = 0;i< n&& i< ids.size();i++) {
            LinkedList.Node song = library.get(ids.get(i));
            result.add(song.getTitle()+": amount played "+playCount(song.getId()));
        }
        return result;
    }



}
