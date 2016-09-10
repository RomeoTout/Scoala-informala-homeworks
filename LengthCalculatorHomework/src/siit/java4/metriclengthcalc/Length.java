package siit.java4.metriclengthcalc;

import siit.java4.metriclengthcalc.Length;

/**
 * encapsulates the metric systems as a format name and value pair
 */
public class Length {
	public static final String MILIMETERS = "mm";
	public static final String CENTIMETERS = "cm";
	public static final String DECIMETERS = "dm";
	public static final String METERS = "m";
	public static final String KILOMETERS = "km";
	public static final String INCH = "inch";
	public static final String FOOT = "foot";
	public static final String MILES = "miles";

	private String formatName;
	private double value;

	public Length(String formatName, double value) {
		this.formatName = formatName;
		this.value = value;
	}
	public String getFormatName() {
		return formatName;
	}

	public double getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formatName == null) ? 0 : formatName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Length other = (Length) obj;
		if (formatName == null) {
			if (other.formatName != null)
				return false;
		} else if (!formatName.equals(other.formatName))
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Length [formatName=" + formatName + ", value=" + value + "]";
	}

	public void add(double value) {
		this.value += value;
	}
}
