package ua.nure.strebkov.Practice4;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Create a class that implements the java.lang.Iterable interface.
 * The class must parse the text file and return the sentences
 * from the file. The iterator method of this class must return
 * an iterator object - an instance of the inner class.
 *
 * Don't use existing implementations of iterators from container classes!
 * Use regular expressions.
 */

public class Part4 implements Iterable<String> {
	private String fileName;

	public Part4() {
		this("part4.txt");
	}

	public Part4(String name) {
		fileName = name;
	}

	private Pattern pattern = Pattern
			.compile("(?Um)(^|(?<=[.!?]\\s))(\\d+\\.\\s?)*[\\p{L}][^!?]*?[.!?](?=\\s*(\\d+\\.\\s)*[\\p{L}]|$)");
	private Pattern pattern2 = Pattern.compile("(?iU)(?<=(\\s*|^)).?(\\p{L}+|\\S).?\\p{L}*.?(?=\\s*)");

	/**
	 * Iterator.
	 *
	 * @return toString.
	 */
	public Iterator<String> iterator() {

		final Matcher matcher = pattern.matcher(Reader.read(fileName));
		return new Iterator<String>() {
			public boolean hasNext() {
				return matcher.find();
			}

			public String next() {
				StringBuilder sb = new StringBuilder();
				Matcher matcher2 = pattern2.matcher(matcher.group());
				while (matcher2.find()) {
					sb.append(matcher2.group());
				}
				return sb.toString();

			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String[] args) {
		Part4 part4 = new Part4("part4.txt");
		Iterator<String> it = part4.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}