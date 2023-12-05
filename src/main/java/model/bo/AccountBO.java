package model.bo;

import java.sql.SQLException;

import model.bean.Account;
import model.dao.AccountDAO;

public class AccountBO {
	private AccountDAO accountDAO = new AccountDAO();
	public int registerAccount(Account newAccount)  {
		return accountDAO.registerAccount(newAccount);
	}
	public Account loginAccount(String email, String password) throws SQLException {
		return accountDAO.loginAccount(email, password);
	}
}
