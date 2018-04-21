package ua.nure.strebkov.Practice4.part5;

import static org.junit.Assert.*;

import org.junit.Test;
import ua.nure.strebkov.Practice4.Part5;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Part5Test {

	private static final String ENCODING = "UTF-8";
	private static final String[] ARG = {};

	@Test
	public void writeProperties() {
		String expected = "стол";
		String actual = Part5.writeProperties("table ru");

		assertEquals(expected, actual);

		expected = "table";
		actual = Part5.writeProperties("table en");

		assertEquals(expected, actual);

		expected = "apple";
		actual = Part5.writeProperties("apple en");

		assertEquals(expected, actual);

	}

	@Test
	public void constructor() {
		Part5 part5 = new Part5();
	}

	@Test
	public void main() {
		try {
			System.setIn(new ByteArrayInputStream("table ru\ntable en\napple ru\naaa\nstop".getBytes(ENCODING)));
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getStackTrace());
		}
		try {
			Part5.main(ARG);
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}
	}
}
