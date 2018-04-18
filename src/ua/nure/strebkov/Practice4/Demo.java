package ua.nure.strebkov.Practice4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


public class Demo {

	private static final String[] ARGS = {};

	private static final String ENCODING = "Cp1251";

	public static void main(String[] args) throws IOException {
		System.out.println("=========================== PART1");
		Part1.main(ARGS);

		System.out.println("=========================== PART2");
		Part2.main(ARGS);

		System.out.println("=========================== PART3");

		System.setIn(new ByteArrayInputStream("char\nString\nint\ndoubl\\naaa\nstop".getBytes(ENCODING)));
		Part3.main(ARGS);

		System.out.println("=========================== PART4");
		Part4.main(ARGS);

		System.out.println("=========================== PART5");

		System.setIn(new ByteArrayInputStream("table ru\ntable en\napple ru\naaa\nstop".getBytes(ENCODING)));
		Part5.main(ARGS);

	}

}