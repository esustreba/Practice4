package ua.nure.strebkov.Practice4;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	public static void main(String[] args) {
		Part4 part4 = new Part4("part4.txt");
		Iterator<String> it = part4.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}