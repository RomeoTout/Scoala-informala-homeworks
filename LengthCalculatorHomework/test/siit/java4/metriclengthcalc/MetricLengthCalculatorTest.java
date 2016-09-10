package siit.java4.metriclengthcalc;

import org.junit.Test;
import static org.junit.Assert.*;

public class MetricLengthCalculatorTest {
	
	@Test
	public void simpleExpressionIsCalculated() throws UnknownLengthFormatException{
		// given
		MetricLengthExpressionParser mockParser = new MetricLengthExpressionParser(){
			@Override
			public Length[] parse(String expression) throws UnknownLengthFormatException {
				return new Length[]{new Length(Length.KILOMETERS, 1), new Length(Length.METERS, 1)};
			}	
		};
		MetricLengthConverter mockConverter = new MetricLengthConverter(){
			@Override
			public Length convert(Length Length, String toFormat) throws UnknownLengthFormatException {
				if(Length.getFormatName().equals(Length.KILOMETERS)){
					return new Length(Length.METERS, 1000);
				} else {
					return Length;
				}
			}
		};
		MetricLengthCalculator calc = new MetricLengthCalculator(mockParser, mockConverter);
		
		// when
		Length actual = calc.computeLength("1km+1m", Length.METERS);
		
		// then
		Length expected = new Length(Length.METERS, 1001);
		assertEquals(expected, actual);
	}

}
