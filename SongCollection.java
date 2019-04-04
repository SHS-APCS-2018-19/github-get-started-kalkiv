package song;

import java.io.*;
import java.util.*;

//u
public class SongCollection {

	ArrayList<Song> list = new ArrayList<Song>();
	PrintStream outprint;
	// define general object

	public SongCollection(ArrayList<Song> songs, PrintStream out) {
		list = songs;
		outprint = out;
		// define unique object
	}

	public void filterYear(Range r) {
		for (int i = 0; i < list.size(); i++) {
			if ((list.get(i).getYear() < r.getMin()) || (list.get(i).getYear() > r.getMax())) {
				list.remove(i);
				i--;
			}
		}
		// remove all non relevant data
		System.out.println("Filtered!");
	}

	public void filterRank(Range r) {
		for (int i = 0; i < list.size(); i++) {
			if ((list.get(i).getRank() < r.getMin()) || (list.get(i).getRank() > r.getMax())) {
				list.remove(i);
				i--;
			}
		}
		// remove all non relevant data
		System.out.println("Filtered!");
	}

	public void filterArtist(String s) {
		for (int i = 0; i < list.size(); i++) {
			String temp = list.get(i).getArtist();
			if (!temp.toString().contains(s)) {
				list.remove(i);
				i--;
			}
		}
		// remove all non relevant data
		System.out.println("Filtered!");
	}

	public void filterTitle(String s) {
		for (int i = 0; i < list.size(); i++) {
			String temp = list.get(i).getTitle();
			if (!temp.toString().contains(s)) {
				list.remove(i);
				i--;
			}
		}
		// remove all non relevant data
		System.out.println("Filtered!");
	}

	public void sortYear() {
		for (int i = 0; i < list.size() - 1; i++) {

			int min = i;
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j).getYear() < list.get(min).getYear())
					min = j;
			}

			Song temp = list.get(min);
			list.set(min, list.get(i));
			list.set(i, temp);
		}
		// selection sort
		System.out.println("Sorted!");
	}

	public void sortRank() {
		for (int i = 0; i < list.size() - 1; i++) {

			int min = i;
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j).getRank() < list.get(min).getRank())
					min = j;
			}

			Song temp = list.get(min);
			list.set(min, list.get(i));
			list.set(i, temp);
		}
		// selection sort
		System.out.println("Sorted!");
	}

	public void sortArtist() {

		for (int i = 0; i < list.size(); i++) {
			int min = i;
			for (int j = i; j < list.size(); j++) {
				if (list.get(j).getArtist().compareTo(list.get(min).getArtist()) < 0)
					min = j;
			}

			Song temp = list.get(min);
			list.set(min, list.get(i));
			list.set(i, temp);
		}
		// selection sort
		System.out.println("Sorted!");
	}

	public void sortTitle() {
		for (int i = 0; i < list.size(); i++) {
			int min = i;
			for (int j = i; j < list.size(); j++) {
				if (list.get(j).getTitle().compareTo(list.get(min).getTitle()) < 0)
					min = j;
			}

			Song temp = list.get(min);
			list.set(min, list.get(i));
			list.set(i, temp);
		}
		// selection sort
		System.out.println("Sorted!");
	}

	public void printList() {
		for (int i = 0; i < list.size(); i++) {
			outprint.println(list.get(i));
			System.out.println(list.get(i));
			// print in file or console
		}
	}
}
