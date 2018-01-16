package com.game.model.user;

public class User {
	private static int ID = 0;
	private int id;
	private String username;
	private String password;
	private String email;
	private int age;
	private String address;

	public User(String username, String password, String email, int age, String address) {
		this.id = ++ID;
		this.username = username;
		this.password = password;
		this.email = email;
		this.age = age;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
