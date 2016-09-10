package siit.java4.metriclengthcalc;

/**
 * The objective of this class is to decompose the main string into substring/operand parts
 */
public class MetricLengthExpressionParser  {

	private static final String MINUS = "-";
	private static final String PLUS = "\\+";
	/**
	 * parses a string expression and returns an array of Length type
	 */
	public Length[] parse(String expression) throws UnknownLengthFormatException{
		/**
		 * operandCount represents the number of operands 
		 */
		int operandCount = countSubStringOccurrences(expression, PLUS) + countSubStringOccurrences(expression, MINUS)
				+ 1;
		/**
		 * if first operand has "-" in front, reduce the number of operands by 1
		 */
		if (expression.startsWith("-")) {
			operandCount--;
		}
		/**
		 * creating an array with the operands and deleting the whitespace
		 */
		Length lengths[] = new Length[operandCount];
		int index = 0;
		expression = expression.trim().replaceAll(" ", "").replaceAll("/t", "");
		while (expression.length() > 0) {
			int sign = 1;
			if (expression.startsWith(MINUS)) {
				expression = expression.replaceFirst(MINUS, "");
				sign = -1;
			} else if (expression.startsWith("+")) {
				expression = expression.replaceFirst(PLUS, "");
			}
			int nextOpPos = nextOperatorPos(expression);
			String operator = null;
			if (nextOpPos == -1) {
				operator = expression;
			} else {
				operator = expression.substring(0, nextOpPos);

			}
			expression = expression.replaceFirst(operator, "");
			lengths[index++] = convertToLength(operator, sign);
		}
		return lengths;
	}
	/**
	 * determine the next plus or minus position
	 * @param expression the string to analyze
	 */
	public int nextOperatorPos(String expression) {
		int plusPos = expression.indexOf("+");
		int minusPos = expression.indexOf("-");
		if (plusPos == -1) {
			return minusPos;
		}
		if (minusPos == -1) {
			return plusPos;
		}
		return plusPos < minusPos ? plusPos : minusPos;

	}
	/**
	 * converts a String into an object of type {@link Length}
	 * @param sign represents if the number is positive or negative
	 * @param e the string to convert
	 */
	private Length convertToLength(String e, int sign) throws UnknownLengthFormatException {
		if (e.endsWith(Length.CENTIMETERS)) {
			return convertToLength(e, sign, Length.CENTIMETERS);
		} else if (e.endsWith(Length.DECIMETERS)) {
			return convertToLength(e, sign, Length.DECIMETERS);
		} else if (e.endsWith(Length.FOOT)) {
			return convertToLength(e, sign, Length.FOOT);
		} else if (e.endsWith(Length.INCH)){
			return convertToLength(e, sign,  Length.INCH);
		} else if (e.endsWith(Length.KILOMETERS)){
			return convertToLength(e, sign,  Length.KILOMETERS);
		} else if (e.endsWith(Length.MILIMETERS)){
			return convertToLength(e, sign,  Length.MILIMETERS);
		} else if (e.endsWith(Length.MILES)){
			return convertToLength(e, sign,  Length.MILES);
		} else if(e.endsWith(Length.METERS)){
			return convertToLength(e, sign,  Length.METERS);
		}
		throw new UnknownLengthFormatException("Can not parse ["+e+"] as a valid weight.");
	}
	/**
	 * converts a String into an object of type {@link Length}
	 * @param e the string to convert
	 * @param sign represents if the number is positive or negative
	 * @param formatName the metric system symbols
	 * @return the converted string
	 */
	private Length convertToLength(String e, int sign, String formatName) {
		return new Length(formatName, sign * Double.parseDouble(e.replace(formatName, "")));
	}
	/**
	 * counts the occurrences of a substring in a string
	 * @param s the string
	 * @param sub the substring to count
	 * @returns the number of occurrences
	 */
	private int countSubStringOccurrences(String s, String sub) {
		return s.length() - s.replaceAll(sub, "").length();
	}
}
