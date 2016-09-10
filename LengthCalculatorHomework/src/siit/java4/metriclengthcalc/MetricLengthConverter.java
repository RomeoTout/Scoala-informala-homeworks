package siit.java4.metriclengthcalc;

/**
 * Converts from one metric system type to another.
 */
public class MetricLengthConverter {

	private static final Convertion[] CONVERTIONS = new Convertion[] {
			new Convertion(Length.CENTIMETERS, Length.DECIMETERS, 0.1),
			new Convertion(Length.CENTIMETERS, Length.FOOT, 0.032808),
			new Convertion(Length.CENTIMETERS, Length.INCH, 0.3937),
			new Convertion(Length.CENTIMETERS, Length.KILOMETERS, 0.00001),
			new Convertion(Length.CENTIMETERS, Length.METERS, 0.01),
			new Convertion(Length.CENTIMETERS, Length.MILES, 0.00000621),
			new Convertion(Length.CENTIMETERS, Length.MILIMETERS, 10),

			new Convertion(Length.DECIMETERS, Length.CENTIMETERS, 10),
			new Convertion(Length.DECIMETERS, Length.FOOT, 0.32808),
			new Convertion(Length.DECIMETERS, Length.INCH, 3.937),
			new Convertion(Length.DECIMETERS, Length.KILOMETERS, 0.0001),
			new Convertion(Length.DECIMETERS, Length.METERS, 0.1),
			new Convertion(Length.DECIMETERS, Length.MILES, 0.000621),
			new Convertion(Length.DECIMETERS, Length.MILIMETERS, 100),

			new Convertion(Length.METERS, Length.CENTIMETERS, 100), new Convertion(Length.METERS, Length.FOOT, 3.2808),
			new Convertion(Length.METERS, Length.INCH, 39.37), new Convertion(Length.METERS, Length.KILOMETERS, 0.001),
			new Convertion(Length.METERS, Length.DECIMETERS, 10), new Convertion(Length.METERS, Length.MILES, 0.0062),
			new Convertion(Length.METERS, Length.MILIMETERS, 1000),

			new Convertion(Length.MILIMETERS, Length.CENTIMETERS, 0.1),
			new Convertion(Length.MILIMETERS, Length.FOOT, 0.0032808),
			new Convertion(Length.MILIMETERS, Length.INCH, 0.03937),
			new Convertion(Length.MILIMETERS, Length.KILOMETERS, 0.000001),
			new Convertion(Length.MILIMETERS, Length.DECIMETERS, 0.01),
			new Convertion(Length.MILIMETERS, Length.MILES, 0.000000621),
			new Convertion(Length.MILIMETERS, Length.METERS, 0.001),

			new Convertion(Length.KILOMETERS, Length.CENTIMETERS, 100000),
			new Convertion(Length.KILOMETERS, Length.FOOT, 3280.83),
			new Convertion(Length.KILOMETERS, Length.INCH, 39370.07),
			new Convertion(Length.KILOMETERS, Length.MILIMETERS, 1000000),
			new Convertion(Length.KILOMETERS, Length.DECIMETERS, 10000),
			new Convertion(Length.KILOMETERS, Length.MILES, 0.6213),
			new Convertion(Length.KILOMETERS, Length.METERS, 1000),

			new Convertion(Length.INCH, Length.CENTIMETERS, 2.54), new Convertion(Length.INCH, Length.FOOT, 0.08333333),
			new Convertion(Length.INCH, Length.KILOMETERS, 0.0000254),
			new Convertion(Length.INCH, Length.MILIMETERS, 25.4), new Convertion(Length.INCH, Length.DECIMETERS, 0.254),
			new Convertion(Length.INCH, Length.MILES, 0.00001578), new Convertion(Length.INCH, Length.METERS, 0.0254),

			new Convertion(Length.FOOT, Length.CENTIMETERS, 30.48), new Convertion(Length.FOOT, Length.INCH, 12),
			new Convertion(Length.FOOT, Length.KILOMETERS, 0.0003048),
			new Convertion(Length.FOOT, Length.MILIMETERS, 304.8),
			new Convertion(Length.FOOT, Length.DECIMETERS, 3.048),
			new Convertion(Length.FOOT, Length.MILES, 0.00018939), new Convertion(Length.FOOT, Length.METERS, 0.3048),

			new Convertion(Length.MILES, Length.CENTIMETERS, 160934.4),
			new Convertion(Length.MILES, Length.INCH, 63360), new Convertion(Length.MILES, Length.KILOMETERS, 1.609344),
			new Convertion(Length.MILES, Length.MILIMETERS, 1609344),
			new Convertion(Length.MILES, Length.DECIMETERS, 16093.44), new Convertion(Length.MILES, Length.FOOT, 5280),
			new Convertion(Length.MILES, Length.METERS, 1609.344), };

	/**
	 * converts the metric system from one type to another
	 * 
	 * @param length
	 *            the length to convert
	 * @param toFormat
	 *            the format to convert in
	 * @return a converted length
	 * @throws UnknownLengthFormatException
	 */
	public Length convert(Length length, String toFormat) throws UnknownLengthFormatException {
		if (length.getFormatName().equals(toFormat)) {
			return length;
		}
		Convertion convertion = null;
		for (Convertion c : CONVERTIONS) {
			if (c.fromFormat.equals(length.getFormatName()) && c.toFormat.equals(toFormat)) {
				convertion = c;
				break;
			}
		}
		if (convertion == null) {
			throw new UnknownLengthFormatException("No rate found for " + length.getFormatName() + " - " + toFormat);
		}
		return new Length(toFormat, length.getValue() * convertion.rate);
	}

	/**
	 * a class that holds information to convert one type to another
	 */
	private static class Convertion {
		double rate;
		String fromFormat;
		String toFormat;

		private Convertion(String fromFormat, String toFormat, double rate) {
			super();
			this.rate = rate;
			this.fromFormat = fromFormat;
			this.toFormat = toFormat;
		}
	}
}
