package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionDB;
import model.bean.Account;

public class AccountDAO {
	private static ConnectionDB connection = new ConnectionDB();
	
	public int registerAccount(Account newAccount) {
	    Connection con = connection.connect();
	    String sql = "INSERT INTO users (id, full_name, password, email, address, is_enabled, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    try {
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, newAccount.getId());
	        pstmt.setString(2, newAccount.getFullname());
	        pstmt.setString(3, newAccount.getPassword());
	        pstmt.setString(4, newAccount.getEmail());
	        pstmt.setString(5, newAccount.getAddress());
	        pstmt.setBoolean(6, newAccount.getIs_enable());
	        pstmt.setString(7, newAccount.getRole());
	        int rowsAffected = pstmt.executeUpdate();
	        pstmt.close();
	        con.close();
	        
	        return rowsAffected;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return -1;
	}
	
	public Account loginAccount(String email, String password) throws SQLException {
		Connection con = connection.connect();
		String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		Account user = null;
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			user = new Account();
	        user.setId(rs.getString("id"));
	        user.setFullname(rs.getString("full_name"));
	        user.setPassword(rs.getString("password"));
	        user.setEmail(rs.getString("email"));
	        user.setAddress(rs.getString("address"));
	        user.setIs_enable(rs.getBoolean("is_enabled"));
	        user.setRole(rs.getString("role"));
	    }
		return user;
	}
}
