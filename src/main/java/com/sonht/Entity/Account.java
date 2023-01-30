package com.sonht.Entity;

public class Account {
	private String usr, pwd;
	private int role;
	private String name, address, phone;

	public Account(String usr, String pwd, int role, String name, String address, String phone) {
		super();
		this.usr = usr;
		this.pwd = pwd;
		this.role = role;
		this.name = name;
		this.address = address;
		this.phone = phone;
		
	}

	public Account() {
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phoneString) {
		this.phone = phoneString;
	}


	public String validate() {
		String messageString = "";
		if(usr.trim().equals("")) {
			messageString += "Email can't be empty<br>";
		}
		if(pwd.trim().equals("")) {
			messageString += "Password can't be empty<br>";
		}
		if(!usr.trim().matches("\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b")) {
			messageString += "Invalid email address<br>";
		}
		
		if(pwd.length() < 8) {
			messageString += "Password must be at least 8 characters<br>";
		} else if (pwd.matches("\\w*\\s+\\w*")){
			messageString += "Password cannot contain space<br>";
		}
		if (name.trim().length() == 0) {
			messageString += "Name cannot be blank<br>";
		}

		if (address.trim().length() == 0) {
			messageString += "Address cannot be blank<br>";
		}

		if (phone.trim().length() == 0) {
			messageString += "phone cannot be blank<br>";
		}

		return messageString;
	}
}
