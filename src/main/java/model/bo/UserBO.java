package model.bo;

import java.sql.SQLException;
import java.util.List;

import model.dao.UserDAO;
import model.bean.User;

public class UserBO {
	UserDAO userDAO = new UserDAO();

	public List<User> getListUserByRole(String role) throws SQLException {
		return userDAO.getListUserByRole(role);
	}

	public void insertUser(User landLord) throws SQLException {
		userDAO.insertUser(landLord);
	}

	public List<User> getAllUsers() throws SQLException {
		return userDAO.getAllUsers();
	}

	public User getUserByEmail(String email) throws SQLException {
		return userDAO.getUserByEmail(email);
	}

	public void updateUser(User userUpdate) throws SQLException {
		userDAO.updateUser(userUpdate);
	}

}
