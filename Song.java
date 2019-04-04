package song;

import java.io.*;
import java.util.*;

public class Song {

	private int year;
	private int rank;
	private String artist;
	private String title;

	public Song(String fromFile) {
		parse(this, fromFile);
		//create temp
	}

	public static Song parse(Song current, String input) {

		Scanner parse = new Scanner(input).useDelimiter("	");

		current.year = parse.nextInt();
		current.rank = parse.nextInt();
		current.artist = parse.next();
		current.title = parse.next();
		//define all subparts of the object
		return null;
	}

	public int getYear() {
		return year;
	}

	public int getRank() {
		return rank;
	}

	public String getArtist() {
		return artist;
	}

	public String getTitle() {
		return title;
	}

	public String toString() {
		String song = year + "\t" + rank + "\t" + artist + "\t" + title;
		return song;
	}
}
