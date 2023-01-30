package com.sonht.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonht.Dao.AccountDao;
import com.sonht.Entity.Account;

@Service
public class AccountServiceImpl implements IAccountService{
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public Account search(String usermail, String password, int role) {
		return accountDao.search(usermail, password, role);
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountDao.getAllAccounts();
	}

	@Override
	public Account checkLoginExist(String userMail) {
		return accountDao.checkLoginExist(userMail);
	}

	@Override
	public void signup(String userMail, String pass, String userName, String address, String phone) {
		accountDao.signup(userMail, pass, userName, address, phone);
	}

	@Override
	public void deleteAccount(String usermail) {
		accountDao.deleteAccount(usermail);
		
	}

	@Override
	public void editAccount(String name,String password,int role, String address, String phone, String userMail) {
		accountDao.editAccount(name,password,role, address, phone, userMail);
		
	}

	@Override
	public Account getAccountByUserMail(String userMail) {
		return accountDao.getAccountByUserMail(userMail);
	}

}
