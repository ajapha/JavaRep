package musicplayer;

import java.util.ArrayList;
import java.util.Collections;



public class Playlist {
    private ArrayList<Song> songs = new ArrayList();
    private Song nowPlaying = null;
    private boolean np = false;

    public void addSong(Song song) {
        songs.add(song);
    }
    
    public void deleteSong(Song song) {
        songs.remove(song);
    }
    
    public int songsLength() {
        return songs.size();
    }
    
    public Song getSong(int index) {
        return songs.get(index);
    }
    
    public void playSong(Song song) {
        nowPlaying = song;
        np = true;
        System.out.println("Now Playing " + song.getTitle() + "...");
        System.out.println();
    }
    
    public void playNext() {
        int now = songs.indexOf(nowPlaying);
        playSong(songs.get(now+1));
    }
    
    public void playAll() {
        for (Song song : songs) {
            playSong(song);
        }
    }
    
    public void shuffle() {
        ArrayList<Song> shuffled = new ArrayList();
        for(Song song : songs) {
            shuffled.add(song);
        }
        Collections.shuffle(shuffled);
        for (Song song : shuffled) {
            playSong(song);
        }
    }
    
    public void resume() {
        if(nowPlaying != null && np == false) {
            playSong(nowPlaying);
        }
    }
    
    public void stop() {
        if(np) {
            np = false;
            System.out.println("Song stopped");
        }
    }
    
    public void displaySongs() {
        if(songs.isEmpty()) {
            System.out.println("You're playlist is empty.");
            return;
        }
        int i = 0;
        for(Song song : songs) {
            System.out.println((i+1) + ") Title: " + song.getTitle() + " | Artist: " + song.getArtist() + " | Album: " + song.getAlbum()+"\r\n");
            i++;
        }
    }
}