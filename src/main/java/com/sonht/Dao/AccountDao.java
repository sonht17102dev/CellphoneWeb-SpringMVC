package com.sonht.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sonht.Entity.Account;
import com.sonht.Entity.MapperUsers;

@Repository
public class AccountDao extends BaseDao{
	public Account search(String usermail, String password, int role) {
		String sql = "select * from account where user_mail=? and password=? and account_role=?";
		List<Account> acc = (List<Account>) _jdbcTemplate.query(sql, new MapperUsers(), new Object[] {usermail,password, role});
		if (acc.size()==0) return null;
		return acc.get(0);
	}
	public List<Account> getAllAccounts(){
		String sql = "select * from account";
		List<Account> accoutList = _jdbcTemplate.query(sql, new MapperUsers());
		return accoutList;
	}
	
	public Account checkLoginExist(String userMail) {
		String sql = "select * from Account where user_mail = '" + userMail + "'; ";
		List<Account> acc =  _jdbcTemplate.query(sql, new MapperUsers());
		if (acc.size()==0) return null;
		return acc.get(0);
	}
	public void signup(String userMail, String pass, String userName, String address, String phone) {
		String sql = "insert into Account values ("
				+ "'"+ userMail + "', "
				+ "'"+pass + "', "
				+ 1 + ", "
				+ "'"+userName + "', "
				+ "'"+address + "', "
				+ "'"+phone + "'"
				+ ")";
		_jdbcTemplate.update(sql);
	}
	
	public void deleteAccount(String usermail) {
		String sql = "delete from Account where user_mail = '" + usermail + "'";
		_jdbcTemplate.update(sql);
	}
	
	public void editAccount(String name, String password,int role, String address,  String phone, String userMail) {
		String sql = "update account "
				+ "set user_name = '"+ name + "',"
				+ " password = '"+ password + "',"
				+ " account_role = "+ role + ","
				+ " user_address = '"+ address + "',"
				+ " user_phone= '"+ phone + "',"
				+ " user_mail= '"+ userMail + "'"
				+ " where user_mail = '" + userMail + "'";
		_jdbcTemplate.update(sql);
	}
	
	public Account getAccountByUserMail(String userMail) {
		String sql = "select * from Account where user_mail = '" + userMail + "'";
		List<Account> acc =  _jdbcTemplate.query(sql, new MapperUsers());
		return acc.get(0);
	}
}
