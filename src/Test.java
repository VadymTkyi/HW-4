import java.util.Scanner;

public class Test {

  public static void main() {
        MusicPlayerManager playerManager = new MusicPlayerManager();
        Scanner input = new Scanner(System.in);

      System.out.println("--- 1. Building the playlist ---");

      System.out.println(playerManager.addSong("s1", "Night Drive", "Artist 1"));
      System.out.println(playerManager.addSong("s2", "Slow Tide", "Artist 2"));
      System.out.println(playerManager.addSong("s3", "Copper Sky", "Artist 3"));
      System.out.println(playerManager.addSong("s4", "Static Bloom", "Artist 4"));
      System.out.println(playerManager.addSong("s5", "Low Orbit", "Artist 5"));
      System.out.println(playerManager.addSong("s6", "Glass Rivers", "Artist 6"));

      System.out.println("duplicate s3: "+playerManager.addSong("s3", "Copper Sky", "Artist 3"));

      System.out.println("playlist: "+playerManager.showPlaylist());

      System.out.println("--- 2. Look up songs ---");

      System.out.println("find s4: "+playerManager.findSong("s4").getTitle());
      System.out.println("find s9: "+(playerManager.findSong("s9") == null ? "null" : playerManager.findSong("s9").getTitle()));
      System.out.println("--- 3. Play and move forward ---");

      System.out.println("play s1: "+playerManager.play("s1").getTitle());
      System.out.println("play s9: "+(playerManager.play("s9") == null ? "null" : playerManager.play("s9").getTitle()));
      System.out.println("next: "+playerManager.next().getTitle());
      System.out.println("next: "+playerManager.next().getTitle());
      System.out.println("history: " +playerManager.showHistory());

      System.out.println("--- 4. Up next ---");

      System.out.println(playerManager.queueNext("s6"));
      System.out.println(playerManager.queueNext("s5"));
      System.out.println(playerManager.queueNext("s1"));
      System.out.println("queue s9: "+playerManager.queueNext("s9"));
      System.out.println("next: "+playerManager.next().getTitle());
      System.out.println("now playing: "+playerManager.nowPlaying().getTitle());
      System.out.println("history: "+playerManager.showHistory());

      System.out.println("--- 5. Back button ---");

      System.out.println("back: "+playerManager.back().getTitle());
      System.out.println("up next: " +playerManager.showUpNext());
      System.out.println("history: "+playerManager.showHistory());

      System.out.println("--- 6. Remove songs ---");
      System.out.println("remove s5:"+playerManager.removeSong("s5"));
      System.out.println("remove current (s3): "+playerManager.removeSong("s3"));
      System.out.println("remove s9"+playerManager.removeSong("s9"));
      System.out.println("playlist:" + playerManager.showPlaylist());
      System.out.println("up next: "+playerManager.showUpNext());

      System.out.println("--- 7. Removed songs are skipped ---");

      System.out.println("next: "+playerManager.next().getTitle());
      System.out.println("next: "+playerManager.next().getTitle());
      LinkedList.Node song = playerManager.next();
      System.out.println("next at end: "+ (song==null ?"null":song.getTitle()));
      System.out.println("now playing: "+playerManager.nowPlaying().getTitle());
      System.out.println("back: "+playerManager.back().getTitle());
      System.out.println("up next: "+playerManager.showUpNext());

      System.out.println("--- 8. Play counts ---");
      System.out.println("s1: "+playerManager.playCount("s1"));
      System.out.println("s3: "+playerManager.playCount("s3"));
      System.out.println("s6: "+playerManager.playCount("s6"));
      System.out.println("s5 (removed): "+playerManager.playCount("s5"));

      System.out.println("---9. Empty player ---");

      MusicPlayerManager emptyPlayer = new MusicPlayerManager();
      song = emptyPlayer.next();
      System.out.println("next: "+(song == null ? "null" : song.getTitle()));
      song = emptyPlayer.back();
      System.out.println("back: "+(song == null ? "null" : song.getTitle()));
      song = emptyPlayer.nowPlaying();
      System.out.println("now playing: "+(song==null ? "null" : song.getTitle()));
      System.out.println("playlist: "+emptyPlayer.showPlaylist());

      System.out.println("---10. Top Songs Test ---");
      System.out.println("Top 3 songs"+playerManager.topSongs(3));



  }
}