package com.sonht.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class MapperUsers implements RowMapper<Account>{
	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();
		account.setUsr(rs.getString("user_mail"));
		account.setPwd(rs.getString("password"));
		account.setRole(rs.getInt("account_role"));
		account.setName(rs.getString("user_name"));
		account.setAddress(rs.getString("user_address"));
		account.setPhone(rs.getString("user_phone"));
		return account;
	}

}
