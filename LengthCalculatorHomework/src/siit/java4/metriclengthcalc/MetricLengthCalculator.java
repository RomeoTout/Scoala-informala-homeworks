package siit.java4.metriclengthcalc;

/**
 * This class converts a string expression into the required format.
 */

public class MetricLengthCalculator {
	private MetricLengthExpressionParser parser;
	private MetricLengthConverter converter;
	/**
	 * creates a new MetricLengthCalculator
	 */
	public MetricLengthCalculator() {
		this(new MetricLengthExpressionParser(), new MetricLengthConverter());
	}
	
	MetricLengthCalculator(MetricLengthExpressionParser parser, MetricLengthConverter converter) {
		this.parser = parser;
		this.converter = converter;
	}
	/**
	 * converts a string expression into the required format
	 * @param expression
	 * @param resultLengthFormat
	 * @return
	 * @throws UnknownLengthFormatException
	 */
	public Length computeLength(String expression, String resultLengthFormat) throws UnknownLengthFormatException{
		Length[] lengths = parser.parse(expression);
		Length result = new Length(resultLengthFormat, 0);
		for(Length length :  lengths){
			Length converted = converter.convert(length, resultLengthFormat);
			result.add(converted.getValue());
		}
		return result;
	}
}
