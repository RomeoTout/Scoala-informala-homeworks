package siit.java4.booking;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class InsertIntoTest {

	@Test
	public void test() {
		/**
		 * to make sure the test is working I verified if the last record in the table holds the number of max_guests 
		 * inserted by the test
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
		ResultSet rs = null;

		// When

		String insertInto = "INSERT INTO accomodation" + "(id, type, bed_type, max_guests, description) VALUES"
				+ "(?,?,?,?,?)";
		try {
			PreparedStatement prepStatement = conn.prepareStatement(insertInto);
			prepStatement.setInt(1, 5);
			prepStatement.setString(2, "insert test");
			prepStatement.setString(3, "insert test");
			prepStatement.setInt(4, 666);
			prepStatement.setString(5, "insert test");
			prepStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sqlQuery = "SELECT max_guests from accomodation ";

		int max_guests = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sqlQuery);

			rs = ps.executeQuery();

			boolean hasResult = rs.next();
			if (hasResult) {
				do {
					max_guests = rs.getInt("max_guests");

				} while (rs.next());
			} else {
				System.out.println("No result");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Then
		int expected = 666;
		int actual = max_guests;
		assertEquals(expected, actual);

	}

}
