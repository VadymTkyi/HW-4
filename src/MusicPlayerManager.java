public class MusicPlayerManager {
    LinkedList playList = new LinkedList();
    public MusicPlayerManager(){

    }
    public boolean addSong(String id,String title, String artist){
        playList.add(id,title,artist);
        return true;//temporary
    }

    public void findSong(String id){
        //returns song
    }
    public void showPlaylist(){
        //returns playList
    }
    public void play(String id){
        //returns song
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
