package song;

import java.io.*;
import java.util.*;

public class Client {
	public static PrintStream outprint;

	public static void main(String args[]) throws FileNotFoundException {
		Scanner prompt = new Scanner(System.in);
		// create definitions
		// C:\Users\s-kalkiv\Desktop\agazillionsongs.txt

		try {
			System.out.println("Song Database: Sorts and Filters Popular Songs... \nEnter a Database...");

			String in = prompt.nextLine();
			// String in = "agazillionsongs.txt";
			// agazillionsongs.txt
			File database = new File("C:\\Users\\s-kalkiv\\Desktop\\" + in);
			// prompt for a database

			System.out.println("Data loaded.\nEnter an Output...");

			String out = prompt.nextLine();
			// String out = "agazillionsongsout.txt";
			// agazillionsongsout.txt
			outprint = new PrintStream(new File("C:\\Users\\s-kalkiv\\Desktop\\" + out));

			System.out.println("Output loaded.\n");

			Scanner data = new Scanner(database);
			ArrayList<Song> dataList = new ArrayList<Song>();
			while (data.hasNextLine()) {
				Song temp = new Song(data.nextLine());
				dataList.add(temp);
			}
			// create all song objects

			SongCollection sc = new SongCollection(dataList, outprint);
			// add song data from file into the SongCollection database

			Range r = new Range();

			String userSearch = " ";

			while (!userSearch.equals("quit")) {
				System.out.println(
						"Database loaded... Search criteria?...\nFormat: [Sort/Filter]:[Year/Rank/Artist/Title]... [quit] to exit");
				userSearch = prompt.nextLine().toLowerCase();
				// prompt for a search criteria

				if (userSearch.equals("filter:year")) {
					System.out.println("Enter Year(s)...");
					String tempInput = prompt.next();
					sc.filterYear(r.parse(tempInput));
				} // filter year

				if (userSearch.equals("filter:rank")) {
					System.out.println("Enter Rank(s)...");
					String tempInput = prompt.next();
					sc.filterRank(r.parse(tempInput));
				} // filter rank

				if (userSearch.equals("filter:artist")) {
					System.out.println("Enter Artist...");
					String tempInput = prompt.next();
					sc.filterArtist(tempInput);
				} // filter artist

				if (userSearch.equals("filter:title")) {
					System.out.println("Enter Title...");
					String tempInput = prompt.next();
					sc.filterTitle(tempInput);
				} // filter title

				if (userSearch.equals("sort:year")) {
					System.out.println("Sorting by Year...");
					sc.sortYear();
				} // filter year

				if (userSearch.equals("sort:rank")) {
					System.out.println("Sorting by Rank...");
					sc.sortRank();
				} // filter rank

				if (userSearch.equals("sort:artist")) {
					System.out.println("Sorting by Artist...");
					sc.sortArtist();
				} // filter artist

				if (userSearch.equals("sort:title")) {
					System.out.println("Sorting by Title...");
					sc.sortTitle();
				} // filter title

				
				if (userSearch.toLowerCase().equals("print")) {
					sc.printList();
				}
				// clear up file for each loop
			}

		}

		catch (Exception e) {
			System.out.println("Invalid input.. try again.");
		}
		// catch invalid input
	}
}
