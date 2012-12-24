package com.metisme.bean;

public class FriendFollowBean 
{
	private int UserId;
	private String Path;
	private String user_name;
	private String email_address;
	
	public int getUserId()
	{
		return UserId;
	}
	public void setUserId(int userId)
	{
		UserId = userId;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	

}
