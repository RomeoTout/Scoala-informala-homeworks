package siit.java4.metriclengthcalc;

import org.junit.Assert;
import org.junit.Test;

public class MetricLengthCalculatorIntegrationTest {
	
	@Test
	public void lengthCalculatorWorksWithCorrectInput() throws UnknownLengthFormatException {
		// given
		String s = "1km + 500m - 300000mm";
		MetricLengthCalculator calc = new MetricLengthCalculator();
		// when
		Length result = calc.computeLength(s, Length.KILOMETERS);
		// then
		Length expected = new Length(Length.KILOMETERS, 1.2);
		Assert.assertEquals(expected, result);		
	}

}
