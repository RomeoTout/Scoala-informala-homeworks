package siit.java4.booking;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class SelectFromTest {

	@Test
	public void test() {
		/**
		 * to make sure the test is working I verified if the last record in the table holds the last value introduced
		 */
		// Given
		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = Main.connect("postgresql", "localhost", 5432, "Booking", "postgres", "Diana#101");
		if (conn == null)
			return;

		PreparedStatement ps = null;
		ResultSet rs = null;

		// When
		String sqlQuery = "SELECT value from room_fair inner join accomodation on accomodation.id = room_fair.id";

		double value = 0;
		try {
			ps = conn.prepareStatement(sqlQuery);

			rs = ps.executeQuery();

			boolean hasResult = rs.next();
			if (hasResult) {
				System.out.format("price\n");
				do {
					value = rs.getDouble("value");
					System.out.format(rs.getString("value"));
					System.out.println();

				} while (rs.next());
			} else {
				System.out.println("No result");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// Then
		double expected = 60.700000000000003;
		double actual = value;
		double delta = 0.9;
		assertEquals(expected, actual, delta);
	}

}
