package ua.nure.strebkov.Practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {

	public static String writeProperties(String s) {
		Pattern pattern = Pattern.compile("(\\w+)(\\s)(\\w+)");
		Matcher matcher = pattern.matcher(s);
		if (matcher.find()) {
			ResourceBundle rb = ResourceBundle.getBundle("resources", new Locale(matcher.group(3)));
			return rb.getString(matcher.group(1));
		}
		return "";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "Cp1251"));
		String variable;
		do {
			variable = reader.readLine();
			if (variable == null) {
				continue;
			}
			if (variable.equalsIgnoreCase("stop")) {
				break;
			}
			System.out.println(writeProperties(variable));
		} while (true);
	}
}