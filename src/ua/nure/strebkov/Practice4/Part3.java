package ua.nure.strebkov.Practice4;

import java.util.regex.*;
import java.io.*;

public class Part3 {
	public static String types(String text, String type) {
		StringBuilder sb = new StringBuilder();
		Pattern pattern = null;
		if (type.equals("char")) {
			pattern = Pattern.compile("(?iU)(^\\p{L}(?=\\s))|((?<=\\s)\\p{L}(?=\\s))");
		} else {
			if (type.equals("int")) {
				pattern = Pattern.compile("(^d+(?=\\s))|((?<=\\s)\\d+(?=\\s))");
			} else {
				if (type.equals("double")) {
					pattern = Pattern.compile("\\d*\\.\\d*");
				} else {
					if (type.equals("String")) {
						pattern = Pattern.compile("(?iU)(^(\\p{L}{2,})(?=\\s))|(?<=\\s)?(\\p{L}{2,})(?=\\s)");
					} else {
						return sb.toString();
					}
				}
			}
		}
		Matcher matcher = pattern.matcher(text);
		boolean flag = false;
		while (matcher.find()) {
			if (flag) {
				sb.append(" ").append(matcher.group());
			} else {
				sb.append(matcher.group());
				flag = true;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
		String text = Reader.read("part3.txt");
		String variable;
		do {
			variable = reader.readLine();
			if (variable == null) {
				continue;
			}
			if (variable.equalsIgnoreCase("stop")) {
				break;
			}
			System.out.println(types(text, variable));
		} while (true);
	}

}