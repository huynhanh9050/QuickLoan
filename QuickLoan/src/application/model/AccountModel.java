package application.model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import application.entities.Account;

public class AccountModel {
	public static boolean create(Account account) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into account(username,password,fullname,email,role,term) values(?,?,?,?,?,?)");
			preparedStatement.setString(1, account.getUsername());
			preparedStatement.setString(2, account.getPassword());
			preparedStatement.setString(3, account.getFullname());
			preparedStatement.setString(4, account.getEmail());
			preparedStatement.setString(5, account.getRole());
			preparedStatement.setBoolean(6, account.getTerm());
			
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	public Account findByUsername(String username) {
	    Account account = null;
	    try {
	        PreparedStatement preparedStatement = ConnectDB.connection()
	            .prepareStatement("SELECT * FROM account WHERE username = ?");
	        preparedStatement.setString(1, username);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	            account = new Account();
	            account.setId(resultSet.getInt("id"));
	            account.setUsername(resultSet.getString("username"));
	            account.setPassword(resultSet.getString("password"));
	            account.setPhoto_after(resultSet.getByte("photo_after"));
	            account.setPhoto_before(resultSet.getByte("photo_before"));
	            account.setFullname(resultSet.getString("fullname"));
	            account.setBalance(resultSet.getDouble("balance"));
	            account.setTerm(resultSet.getBoolean("term"));
	            account.setRole(resultSet.getString("role"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        ConnectDB.disconnect();
	    }
	    return account;
	}

}
