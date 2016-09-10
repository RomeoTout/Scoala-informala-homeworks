package siit.java4.metriclengthcalc;

import org.junit.Test;
import org.junit.Assert;

public class LengthConverterTest {
	
	@Test
	public void metersToKilometersConvertion() throws UnknownLengthFormatException{
		//Given
		Length m1000 = new Length(Length.METERS, 1000);
		MetricLengthConverter LengthConverter = new MetricLengthConverter();
		Length result = LengthConverter.convert(m1000, Length.KILOMETERS);
		//When
		Length expected = new Length(Length.KILOMETERS, 1);
		//Then
		Assert.assertEquals("Convertion from meters to kms is incorrect.", expected,  result);
	}
	
	@Test
	public void kilometersToMetersConvertion() throws UnknownLengthFormatException{
		//Given
		Length km1 = new Length(Length.KILOMETERS, 1);
		MetricLengthConverter LengthConverter = new MetricLengthConverter();
		
		Length result = LengthConverter.convert(km1, Length.METERS);
		//When
		Length expected = new Length(Length.METERS, 1000);
		//Then
		Assert.assertEquals("Convertion from kms to ms is incorrect.", expected,  result);
	}
	
	@Test(expected=UnknownLengthFormatException.class)
	public void convertionFailsWhenUnknownFormatIsPassed() throws UnknownLengthFormatException{
		//Given
		Length km1 = new Length(Length.KILOMETERS, 1);
		MetricLengthConverter LengthConverter = new MetricLengthConverter();
		//When
		LengthConverter.convert(km1, "dkm");
	}
	

}
