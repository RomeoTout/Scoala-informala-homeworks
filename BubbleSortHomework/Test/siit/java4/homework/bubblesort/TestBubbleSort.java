package siit.java4.homework.bubblesort;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBubbleSort {
	BubbleSort testSorter = new BubbleSort();
	@Test
	public void testInteger() {
	//Given
		Integer[] testInt = new Integer[] {4, 3, 2, 1};

	//When
		Integer[] result = testSorter.bubblesorter(testInt);
		Integer[] expected = new Integer[] {1, 2, 3, 4};
	//Then
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testString() {
	//Given
		String[] testString = new String[] {"dune", "colt", "belt", "art"};
	//When
		String[] result = testSorter.bubblesorter(testString);
		String[] expected = new String[] {"art", "belt", "colt", "dune"};
	//Then
		assertArrayEquals(expected, result);
	}

	@Test
	public void testComparable() {
	//Given
		Book book1 = new Book(889, "Ion Ionescu", "Titlul lui Ion");
		Book book2 = new Book(882, "George Ionescu", "Titlul lui George");
		Book book3 = new Book(887, "Petre Ionescu", "Titlul lui Petre");
		Book book4 = new Book(885, "Vasile Ionescu", "Titlul lui Vasile");
		Book[] testBooks = new Book[] {book1, book2, book3, book4};
	//When
		Book[] result = testSorter.bubblesorter(testBooks);
		Book[] expected = new Book[] {book1, book3, book4, book2};
	//Then
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testDouble() {
	//Given
		Double[] testDouble = new Double[] {3.14, 5.15, 100.51, 86.90, 25.31};
	//When
		Double[] result = testSorter.bubblesorter(testDouble);
		Double[] expected = new Double[] {3.14, 5.15, 25.31, 86.90, 100.51};
	//Then
		assertArrayEquals(expected, result);
	}
	@Test
	public void testChar() {
	//Given
		Character[] testChar = new Character[] {'z', 'y', 'x'};
	//When
		Character[] result = testSorter.bubblesorter(testChar);
		Character[] expected = new Character[] {'x', 'y', 'z'};
	//Then
		assertArrayEquals(expected, result);
	}
}
