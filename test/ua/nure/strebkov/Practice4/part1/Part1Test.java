package ua.nure.strebkov.Practice4.part1;

import static org.junit.Assert.*;
import org.junit.Test;
import ua.nure.strebkov.Practice4.Part1;

public class Part1Test {

	private static final String[] ARG = {};

	@Test
	public void convertTestString() {
		String actual = Part1
				.convert("This tutorial explains unit testing with JUnit 4.x and JUnit5.");
		String expected = "THIS TUTORIAL EXPLAINS UNIT TESTING WITH JUNIT 4.x and JUNIT5.";
		assertEquals(expected, actual);

		assertEquals("", Part1.convert(""));

		assertEquals(null, Part1.convert(null));
	}

	@Test
	public void constructor() {
		Part1 part1 = new Part1();
	}

	@Test
	public void main() {
		Part1.main(ARG);
	}

}
