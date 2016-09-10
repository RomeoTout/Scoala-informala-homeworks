package siit.java4.metriclengthcalc;

import org.junit.Test;
import static org.junit.Assert.*;

public class MetricLengthExpressionParserTest {

	@Test
	public void nextOperatorTest1() {
		// given
		MetricLengthExpressionParser parser = new MetricLengthExpressionParser();
		String s = "12345-";
		
		// when
		int opPos = parser.nextOperatorPos(s);
		
		//then
		assertEquals(5, opPos);
	}

	@Test
	public void nextOpPosNotFound() {
		//Given
		MetricLengthExpressionParser parser = new MetricLengthExpressionParser();
		String s = "123";
		//When and Then
		assertEquals(-1, parser.nextOperatorPos(s));
	}

	@Test
	public void nextOperatorTestCorrectWithMultipleOps() {
		//Given
		MetricLengthExpressionParser parser = new MetricLengthExpressionParser();
		String s = "12332-+-";
		//When and Then
		assertEquals(5, parser.nextOperatorPos(s));
	}

	@Test
	public void nextOperatorTestWithJustOp() {
		//Given
		MetricLengthExpressionParser parser = new MetricLengthExpressionParser();
		String s = "+";
		//When and Then
		assertEquals(0, parser.nextOperatorPos(s));
	}

	@Test
	public void correctFormatIsParsed() throws UnknownLengthFormatException {
		//Given
		MetricLengthExpressionParser parser = new MetricLengthExpressionParser();
		String s = "1km+1km";
		Length[] expected = new Length[] { new Length(Length.KILOMETERS, 1), new Length(Length.KILOMETERS, 1) };
		//When
		Length[] actual = parser.parse(s);
		//Then
		assertArrayEquals(expected, actual);
	}

	@Test
	public void correctFormatWithMinusIsParsed() throws UnknownLengthFormatException {
		//Given
		MetricLengthExpressionParser parser = new MetricLengthExpressionParser();
		String s = "1km-1km";
		Length[] expected = new Length[] { new Length(Length.KILOMETERS, 1), new Length(Length.KILOMETERS, -1) };
		//When
		Length[] actual = parser.parse(s);
		//Then
		assertArrayEquals(expected, actual);
	}

	@Test
	public void correctFormatIsParsed2() throws UnknownLengthFormatException {
		//Given
		MetricLengthExpressionParser parser = new MetricLengthExpressionParser();
		String s = "1km-15km";
		Length[] expected = new Length[] { new Length(Length.KILOMETERS, 1), new Length(Length.KILOMETERS, -15) };
		//When
		Length[] actual = parser.parse(s);
		//Then
		assertArrayEquals(expected, actual);
	}

	@Test
	public void correctFormatWithMultipleOpsAndNegativeSignAtStartIsParsed() throws UnknownLengthFormatException {
		//Given
		MetricLengthExpressionParser parser = new MetricLengthExpressionParser();
		String s = "-1km+5km-3m";
		Length[] expected = new Length[] { new Length(Length.KILOMETERS, -1), new Length(Length.KILOMETERS, 5),
				new Length(Length.METERS, -3) };
		//When
		Length[] actual = parser.parse(s);
		//Then
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void correctFormatWithMultipleOpsIsParsed() throws UnknownLengthFormatException {
		//Given
		MetricLengthExpressionParser parser = new MetricLengthExpressionParser();
		String s = "1km+5km-3m";
		Length[] expected = new Length[] { new Length(Length.KILOMETERS, 1), new Length(Length.KILOMETERS, 5),
				new Length(Length.METERS, -3) };
		//When
		Length[] actual = parser.parse(s);
		//Then
		assertArrayEquals(expected, actual);
	}
	
	@Test(expected=UnknownLengthFormatException.class)
	public void parsingFailsWithInvalidLengthFormat() throws UnknownLengthFormatException {
		//Given
		MetricLengthExpressionParser parser = new MetricLengthExpressionParser();
		String s = "-1km+5km-3kg";
		//When and Then
		parser.parse(s);
	}

}
