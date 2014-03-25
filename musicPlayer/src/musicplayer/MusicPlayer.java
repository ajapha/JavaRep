package musicplayer;

import java.util.Random;
import java.util.Scanner;

public class MusicPlayer {
    Playlist playlist = new Playlist();
    
    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();
        while(true) {
            System.out.println("\r\nWelcome to Java Player!\r\n"
                    + "Please choose from the following commands.\r\n"
                    + "'play' - select a song to play\r\n"
                    + "'play next' - plays the song after the song that is playing"
                    + "'play all' - play all the songs in order\r\n"
                    + "'stop' - stops the song now playing\r\n"
                    + "'resume' - continue playing the song\r\n"
                    + "'random' - play a random song\r\n"
                    + "'shuffle' - shuffles the songs and plays them\r\n"
                    + "'add' - add a song to your playlist\r\n"
                    + "'delete' - delete a song from your playlist\r\n"
                    + "'list' - list the songs in your playlist\r\n");
                    
            Scanner input = new Scanner(System.in);
            String selection = musicPlayer.getString(input);
            switch(selection) {
                case "add": musicPlayer.add();
                    break;
                case "delete": musicPlayer.delete();
                    break;
                case "list": musicPlayer.list();
                    break;
                case "play": musicPlayer.play();
                    break;
                case "stop": musicPlayer.stop();
                    break;
                case "resume": musicPlayer.resume();
                    break;    
                case "play next": musicPlayer.playNext();
                    break;
                case "play all": musicPlayer.playAll();
                    break;
                case "random": musicPlayer.random();
                    break;
                case "shuffle": musicPlayer.shuffle();
                    break;
                default: System.out.println("You have entered an invalid selection");    
            
            }       
        }
    }
    public void add() {
        System.out.println("Please enter the title of the song you wish to add");
        Scanner input = new Scanner(System.in);
        String title = getString(input);
        System.out.println("Please enter the artist for " + title);
        String artist = getString(input);
        System.out.println("Please enter the album of " + title);
        String album = getString(input);
        playlist.addSong(new Song(title, artist, album));
        System.out.println();
    }
    
    public void delete() {
        System.out.println("Choose the number of the song you wish to delete");
        list();
        Scanner input = new Scanner(System.in);
        int choice = getIntBetween(input, 1, playlist.songsLength());
        Song song = playlist.getSong(choice-1);
        playlist.deleteSong(song);
    }
    
    public void list() {
        playlist.displaySongs();
    }
    
    public void play() {
        System.out.println("Choose the number of the song you wish to play");
        list();
        Scanner input = new Scanner(System.in);
        int choice = getIntBetween(input, 1, playlist.songsLength());
        Song song = playlist.getSong(choice-1);
        playlist.playSong(song);
    }
    
    public void playNext() {
        playlist.playNext();
    }
    
    public void playAll() {
        playlist.playAll();
    }
    
    public void random() {
        Random random = new Random();
        int song = random.nextInt(playlist.songsLength());
        playlist.playSong(playlist.getSong(song));
    }
    
    public void shuffle() {
        playlist.shuffle();
    }
    
    public void stop() {
        playlist.stop();
    }
    
    public void resume() {
        playlist.resume();
    }

     //util methods
    public String getString(Scanner input) {
        String string = input.nextLine();
        return string;
    }
    public int getInt(Scanner sc) {
        while (true) {
            if(sc.hasNextInt()) {
                int number = sc.nextInt();
                return number;
            }
            else {
                System.out.println("That is not a valid number.  Please try again.");
                sc.nextLine();
            }
        }
    }
    public int getIntBetween(Scanner sc, int min, int max) {
        while (true) {
            if(sc.hasNextInt()) {
                int number = sc.nextInt();
                if(number < min || number > max) {
                    System.out.println("That is not a valid selection.  Please enter a number between " + min + " and " + max + ".");
                    sc.nextLine();
                    continue;
                }
                return number;
            }
            else {
                System.out.println("That is not a valid number.  Please try again.");
                sc.nextLine();
            }
        }
    }
    
}
