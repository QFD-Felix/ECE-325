/**
 * Assignment 6: Test Driven Development <br />
 * The {@code Song} class
 */
/**Qiufeng Du
 * 1439484
 */
public class Song {
    // TODO: Assignment 6 -- complete this Song class to pass the tests
	private String artist;
	private String title;
	private double length;
	public boolean equals;
	public String getArtist;
	public String getTitle;
	public double getLength;
	public Song (String artist, String title, double length) {
		this.artist = artist;
		this.title = title;
		this.length = length;
	}
	public boolean equals(Object newSong) {
		if (this == newSong) {
			return true;
		}
		else if (newSong.getClass() != this.getClass() || newSong == null) {
			return false;
		}
		Song new_song = (Song)newSong;
		//System.out.println("1");
		if (this.getArtist().toLowerCase().equals(new_song.getArtist().toLowerCase())){
			//System.out.println("2");
				if(this.getLength() == new_song.getLength()) {
					//System.out.println("2");
					if(this.getTitle().toLowerCase().equals(new_song.getTitle().toLowerCase())) {
						return true;
					}
				}
		}
		return false;
	}
	public String getArtist() {
		return this.artist;
	}
	public String getTitle() {
		return this.title;
	}
	public double getLength() {
		return this.length;
	}
	public boolean isArtist(String artist) {
		if (this.getArtist().toLowerCase().equals(artist.toLowerCase())) {
			return true;
		}
		return false;
	}
	public boolean isTitle(String title) {
		if (this.getTitle().toLowerCase().equals(title.toLowerCase())) {
			return true;
		}
		return false;
	}
}
