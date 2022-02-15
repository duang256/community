package cn.wit.pojo;

import java.util.Date;

public class User {
	private int userid;
	private String username;
	private String password;
	private int age;
	private String sex;
	private Date birthday;
	
	
	public User() {
		super();
	}
	public User(int userid, String username, String password, int age, String sex, Date birthday) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	
}
