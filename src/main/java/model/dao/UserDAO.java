package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import connection.ConnectionDB;
import model.entity.User;

public class UserDAO {
	private static ConnectionDB connection = new ConnectionDB();

	public List<User> getAllLandLord() throws SQLException {
		Connection con = connection.connect();
		User user = new User();
		List<User> result = new ArrayList<User>();
		String sql = "SELECT * FROM users where role="+ "'LANDLORD'";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			user.setId(UUID.randomUUID());
			user.setAddress(rs.getString("address"));
			user.setFullName(rs.getString("fullname"));
			user.setEmail(rs.getString("email"));
			user.setRole(rs.getString("role"));
			user.setEnabled(rs.getBoolean("enabled"));
	        result.add(user);
	    }
		return result;
	} 
	

}
