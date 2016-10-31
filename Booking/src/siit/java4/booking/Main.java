package siit.java4.booking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		/**
		 * loading the specified class
		 */
		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		/**
		 * establishing a connection with the data source
		 */
		Connection conn = connect("postgresql", "localhost", 5432, "Booking", "postgres", "Diana#101");
		if (conn == null)
			return;

		PreparedStatement ps = null;
		ResultSet rs = null;

		final String format = "%20s%20S%12s\n";

		String sqlQuery = "select * from \"Customer\"";

		try {
			ps = conn.prepareStatement(sqlQuery);

			rs = ps.executeQuery();

			boolean hasResult = rs.next();
			if (hasResult) {
				System.out.format(format, "firstName", "email", "lastName");
				do {
					System.out.format(format, rs.getString("firstName"), rs.getString("email"),
							rs.getString("lastName"));
				} while (rs.next());
			} else {
				System.out.println("No result");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		/**
		 * closing the resultSet, preparedStatement and connection
		 */
		finally {
		    try { rs.close(); } catch (Exception e) { /* ignored */ }
		    try { ps.close(); } catch (Exception e) { /* ignored */ }
		    try { conn.close(); } catch (Exception e) { /* ignored */ }
		}


	}

	static Connection connect(String type, String host, int port, String dbName, String user, String pw) {
		Connection conn = null;
		DriverManager.setLoginTimeout(60);
		try {
			String url = new StringBuilder().append("jdbc:").append(type).append("://").append(host).append(":")
					.append(port).append("/").append(dbName).append("?user=").append(user).append("&password=")
					.append(pw).toString();
			System.out.println("URL:" + url);
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.err.println("Cannot connect to the database: " + e.getMessage());
		}
		return conn;
		
		
	}

}
