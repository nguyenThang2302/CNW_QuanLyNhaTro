package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;

import connection.ConnectionDB;
import model.bean.User;
import model.bean.enums.Role;
public class UserDAO {
	private static ConnectionDB connection = new ConnectionDB();
	
	public int registerAccount(User user) {
	    Connection con = connection.connect();
	    String sql = "INSERT INTO users (id, full_name, password, email, address, is_enabled, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    try {
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, user.getId().toString());
	        pstmt.setString(2, user.getFullName());
	        pstmt.setString(3, user.getPassword());
	        pstmt.setString(4, user.getEmail());
	        pstmt.setString(5, user.getAddress());
	        pstmt.setBoolean(6, false);
	        pstmt.setString(7, String.valueOf(user.getRole()));
	        int rowsAffected = pstmt.executeUpdate();
	        pstmt.close();
	        con.close();
	        
	        return rowsAffected;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return -1;
	}
	
	public User loginAccount(String email, String password) throws SQLException {
		Connection con = connection.connect();
		String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
		User user = new User();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setId(UUID.fromString(rs.getString("id")));
				user.setFullName(rs.getString("full_name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				user.setEnabled(rs.getBoolean("is_enabled"));
				user.setRole(Role.valueOf(rs.getString("role")));
				
			}
		} catch (SQLException e) {
	        e.printStackTrace();
	    }
		return user;
	}
	
	public List<User> getListUserByRole(String role) throws SQLException {
		Connection con = connection.connect();
		User user = new User();
		List<User> result = new ArrayList<User>();
		String sql = "SELECT * FROM users where role= ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, role);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			user.setId(UUID.randomUUID());
			user.setAddress(rs.getString("address"));
			user.setFullName(rs.getString("full_name"));
			user.setEmail(rs.getString("email"));
			user.setRole(Role.valueOf(rs.getString("role")));
			user.setEnabled(rs.getBoolean("is_enabled"));
			result.add(user);
		}
		return result;
	}

	public List<User> getAllUsers() throws SQLException {
		Connection con = connection.connect();
		List<User> result = new ArrayList<User>();
		String sql = "SELECT * FROM users where is_enabled = '1'";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			User user = new User();
			user.setId(UUID.randomUUID());
			user.setAddress(rs.getString("address"));
			user.setFullName(rs.getString("full_name"));
			user.setEmail(rs.getString("email"));
			user.setRole(Role.valueOf(rs.getString("role")));
			user.setEnabled(rs.getBoolean("is_enabled"));
			result.add(user);
		}
		return result;
	}

	public void insertUser(User landLord) throws SQLException {
		Connection con = connection.connect();
		String sql = "INSERT INTO users (id, address, fullname, email, role, enabled) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		landLord.setRole(Role.LANDLORD);
		// Generate a new UUID for the user
		landLord.setId(UUID.randomUUID());

		// Set values for the prepared statement
		pstmt.setObject(1, landLord.getId());
		pstmt.setString(2, landLord.getAddress());
		pstmt.setString(3, landLord.getFullName());
		pstmt.setString(4, landLord.getEmail());
		pstmt.setString(5, landLord.getRole().toString());
		pstmt.setBoolean(6, landLord.isEnabled());

		// Execute the insert statement
		pstmt.executeUpdate();

		// Close resources
		pstmt.close();
		con.close();
	}

	public User getUserByEmail(String email) throws SQLException {
		Connection con = connection.connect();
		User user = null; // Chuyển sang sử dụng null thay vì tạo một đối tượng User trước đó
		String sql = "SELECT * FROM users WHERE email = ?";

		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(UUID.fromString(rs.getString("id")));
				user.setAddress(rs.getString("address"));
				user.setFullName(rs.getString("full_name"));
				user.setEmail(rs.getString("email"));
				user.setRole(Role.valueOf(rs.getString("role")));
				user.setEnabled(rs.getBoolean("is_enabled"));
			}
		} finally {
			// Đảm bảo đóng kết nối
			con.close();
		}

		return user;
	}	
	public void updateUser(User updatedUser) throws SQLException {
		Connection con = connection.connect();
		String sql = "UPDATE users SET address = ?, full_name = ?, role = ?, is_enabled = ?,password=? WHERE email = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		try {
			// Set values for the prepared statement
			pstmt.setString(1, updatedUser.getAddress());
			pstmt.setString(2, updatedUser.getFullName());
			pstmt.setString(3, updatedUser.getRole().toString());
			pstmt.setBoolean(4, updatedUser.isEnabled());
			pstmt.setObject(6, updatedUser.getEmail());
			pstmt.setObject(5, updatedUser.getPassword());
			// Execute the update statement
			pstmt.executeUpdate();
		} finally {
			// Close resources
			pstmt.close();
			con.close();
		}
	}
	

}
