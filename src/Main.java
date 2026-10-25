import java.util.Scanner;

public class Main {
  public static void printMenu(){
    System.out.print("\nWelcome to MuzykaOnline!\nBest streaming platform in the world\nWhat action are" +
            " you interested in right now\n1)add a song\n2)find an existing song\n3)Play a song\n4)num of played songs :(\n");
  }
  public static void printSong(LinkedList.Node song){
    System.out.printf("Id: %s\nTitle: %s\nArtist: %s\n",song.getId(),song.getTitle(),song.getArtist());
  }

  public static void main() {
        MusicPlayerManager manager = new MusicPlayerManager();
        Scanner input = new Scanner(System.in);
        boolean inSystem = true;
        manager.addSong("1s","bios","sh");
    manager.addSong("2s","cry","sh");

    manager.addSong("3s","aliez","sh");
    manager.play("2s");
    manager.play("3s");
    manager.play("1s");
    System.out.println("before removal"+manager.showPlaylist());
    System.out.println(manager.library.containsKey("2s"));
    System.out.println(manager.nowPlaying().getTitle());
    System.out.println(manager.removeSong("2s"));

    System.out.println(manager.library.containsKey("2s"));
    System.out.println("after removal"+manager.showPlaylist());
    System.out.println(manager.showPlaylist());



  }
}