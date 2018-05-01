package ua.nure.strebkov.Practice4;

import java.util.regex.*;

/** Read text from part1.txt and convert words
 * whose length bigger then 3 to upper case.
 * Use regular expressions.
 */

public class Part1 {
	public static String convert(String input) {
		if (input == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		Pattern pattern = Pattern.compile("(?iU)(\\s*|^).?(\\w+|\\S)(\\s*)");
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			if (matcher.group(2).length() > 2) {
				sb.append(matcher.group().toUpperCase());
			} else {
				sb.append(matcher.group());
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String text = Reader.read("part1.txt");
		System.out.println(convert(text));
	}

}