package com.sonht.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sonht.Entity.Account;

@Service
public interface IAccountService {
	public Account search(String usermail, String password, int role);

	public List<Account> getAllAccounts();

	public Account checkLoginExist(String userMail);

	public void signup(String userMail, String pass, String userName, String address, String phone);
	
	public void deleteAccount(String usermail);
	
	public void editAccount(String name,String password,int role, String address, String phone, String userMail);
	
	public Account getAccountByUserMail(String userMail);
}
