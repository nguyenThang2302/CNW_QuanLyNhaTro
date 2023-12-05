package model.bo;

import java.sql.SQLException;
import java.util.List;

import model.dao.UserDAO;
import model.entity.User;

public class UserBO {
	UserDAO userDAO = new UserDAO();

	public List<User> getLandLordList() throws SQLException{
		return userDAO.getAllLandLord();
	}

}

