package siit.java4.metriclengthcalc;

/**
 * @author Romeo Tout
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) throws UnknownLengthFormatException {
		String s = "1km + 750m - 0.5miles + 25cm - 2mm";
		MetricLengthCalculator calc = new MetricLengthCalculator();
		System.out.println(calc.computeLength(s, Length.METERS));
	}
}