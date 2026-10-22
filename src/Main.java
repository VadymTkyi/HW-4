import java.util.Scanner;

public class Main {
  public static void printMenu(){
    System.out.print("Welcome to MuzykaOnline!\nBest streaming platform in the world\nWhat action are" +
            " you interested in right now\n1)add a song\n2)find an existing song\n3)Play a song\n4)leave :(\n");
  }
  public static void printSong(LinkedList.Node song){
    System.out.printf("Id: %s\nTitle: %s\nArtist: %s\n",song.getId(),song.getTitle(),song.getArtist());
  }

  public static void main() {
        MusicPlayerManager manager = new MusicPlayerManager();
        Scanner input = new Scanner(System.in);
        boolean inSystem = true;
        while (inSystem){
            printMenu();
            int choice = input.nextInt();
            switch (choice){
              case 1 : {
                System.out.print("Enter song id in format #s where # is a number starting from 1\n");
                input.nextLine();
                String id = input.nextLine();
                System.out.print("Enter song title\n");
                String title = input.nextLine();
                System.out.print("Enter the artist name\n");
                String artist = input.nextLine();
                if(manager.addSong(id,title,artist)){
                  System.out.print("Song successfully added\n");
                }
                else{
                  System.out.print("Failed to add a song\n");
                }
                break;
              }
              case 2 : {
                System.out.print("Enter song id in format #s where # is a number starting from 1\n");
                input.nextLine();
                String id = input.nextLine();
                LinkedList.Node song = manager.findSong(id);
                printSong(song);
                break;
              }
              case 3 : {
                System.out.print("Enter song id in format #s where # is a number starting from 1\n");
                input.nextLine();
                String id = input.nextLine();
                LinkedList.Node song = manager.play(id);
                printSong(song);
                break;
              }
              case 4 : {

                break;
              }
                default:{
                  System.out.print("wrong choice\n");
                }
            }
        }
    }
}