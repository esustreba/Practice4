package ua.nure.strebkov.Practice4;
import java.io.*;

/**
 * Class to read data from file.
 */

public class Reader {
	public static String read(String name) {
		StringBuilder sb = new StringBuilder();
		try {
			File file = new File(name);
			if (file.exists()) {
				boolean flag = false;
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
				String result;
				while ((result = reader.readLine()) != null) {
					if (flag) {
						sb.append(System.lineSeparator()).append(result);
					} else {
						sb.append(result);
						flag = true;
					}
				}
				flag = false;
				reader.close();
			}

		} catch (IOException e) {
			System.out.println(e);
		}
		return sb.toString();
	}
}