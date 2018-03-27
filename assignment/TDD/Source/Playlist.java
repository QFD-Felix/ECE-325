/**
 * Assignment 6: Test Driven Development <br />
 * The {@code Playlist} class
 */
/**Qiufeng Du
 * 1439484
 */
import java.util.*;
@SuppressWarnings("serial")
public class Playlist<E extends Song> extends java.util.Vector<E> {
    java.util.Iterator<E> itr = this.iterator();       // Generic Iterator; Use it whenever you need it!
    private String title;
    public Playlist(String title) {
    	this.title = title;
    }
    public boolean addtoPlist(E song) {
    	if (song != null) {
    		if (!this.contains(song)) {
    			return this.add(song);
    		}
    	}
    	return false;
    }
    public String getTitle() {
    	return this.title;
    }
    public boolean removeFromPlist(E preSong) {
    	return this.remove(preSong);
    }
    public Song getSong(int pos_song) {
    	return this.get(pos_song);
    }
    public boolean hasTitle(String some_title) {
    	return this.title.toLowerCase().equals(some_title.toLowerCase());
    }
    public boolean hasArtist(String some_art) {
    	for (E song: this) {
    		if (some_art.toLowerCase().equals(song.getArtist().toLowerCase())) {
        		return true;
        	}
    	}
    	return false;
    }
    public int numberOfSongs() {
    	int result = 0;
        for (E song : this) {
            result++;
        }
        return result;
    }
    public int numberOfArtists() {
    	//int result = 0;
    	HashSet<String> num_art = new HashSet<String>();
    	for (E song: this) {
    		num_art.add(song.getArtist());
    		//result++;
    	}
    	return num_art.size();
    }
    public int numberOfTitles() {
    	HashSet<String> num_title = new HashSet<String>();
    	for (E song: this) {
    		num_title.add(song.getTitle());
    		//result++;
    	}
    	return num_title.size();
    }
    public double playTime() {
    	double time = 0;
    	for (E song: this) {
    		time = time+song.getLength();
    	}
    	return time;
    }
    public int findSong(E song) {
    	return this.indexOf(song);
    }
    public void sortByArtist() {
    	this.sort(new Comparator<E>(){
			@Override
			public int compare(E arg0, E arg1) {
				return arg0.getArtist().compareTo(arg1.getArtist());
			}
    	});
    }
    public void sortByTitle() {
    	this.sort(new Comparator<E>(){
			@Override
			public int compare(E arg0, E arg1) {
				return arg0.getTitle().compareTo(arg1.getTitle());
			}
    	});
    }
}
    // TODO: Assignment 6 -- complete this Playlist class to pass the tests

