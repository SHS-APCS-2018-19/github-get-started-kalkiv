package song;

import java.io.*;
import java.util.*;

public class Range {

	private static int low = 1890;
	private static int high = 2008;

	public Range parse(String s) {
		Scanner parse = new Scanner(s).useDelimiter("-");
		low = Integer.parseInt(parse.next());
		if (parse.hasNext()) {
			high = Integer.parseInt(parse.next());
		}

		Range r = new Range();

		r.low = low;
		r.high = high;
		return r;

	}

	public boolean contains(int n) {
		if (n <= 2008 && n >= 1890) {
			return true;
		} else {
			return false;
		}
	}

	public int getMin() {
		return low;
	}

	public int getMax() {
		return high;
	}
}
