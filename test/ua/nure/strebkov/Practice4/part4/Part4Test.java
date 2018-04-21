package ua.nure.strebkov.Practice4.part4;

import static org.junit.Assert.*;

import org.junit.Test;
import ua.nure.strebkov.Practice4.Part4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class Part4Test {
	private static final String[] ARG = {};
	private static String text = "Это ведь неправда, что бывают дети и бывают взрослые. Все, на самом деле, сложнее." +
			" Бывают взрослые и бывают взрослые.";
	private static Part4 part4 = new Part4(write());

	public static String write() {
		String name = "part4test.txt";
		try {
			FileWriter fw = new FileWriter(name);
			fw.write(text);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}
		return name;
	}

	@Test
	public void hasNext() {
		Iterator<String> it = part4.iterator();

		assertTrue(it.hasNext());
	}

	@Test
	public void next() {
		Iterator<String> it = part4.iterator();
		if (it.hasNext()) {
			String actual = it.next();
			String expected = "Это ведь неправда, что бывают дети и бывают взрослые.";

			assertEquals(expected, actual);
		}
	}

	@Test(expected = UnsupportedOperationException.class)
	public void remove() {
		Iterator<String> it = part4.iterator();
		it.remove();
	}

	@Test
	public void constructor() {
		Part4 part4 = new Part4();
	}

	@Test
	public void main() {
		Part4.main(ARG);
	}
}
