package com.metisme.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.metisme.bean.userdata;

public class registrationandlogin
{
	Connection con=DBConnection.getConnection();
public boolean registration(userdata u)
{
	
	
	try {
		PreparedStatement ps=con.prepareStatement("insert into user_master(email,password,name)values(?,?,?)");
		ps.setString(1,u.getEmail());
		ps.setString(2,u.getPassword());
		ps.setString(3,u.getUsername());
		ps.executeUpdate();
		con.commit();
		return true;
		
	} 
	catch (SQLException e)
	{

		return false;
		//e.printStackTrace();
	}
	
}

public boolean login(userdata u1)
{
	
	
	
	try {
		
		PreparedStatement ps1=con.prepareStatement("select user_id from user_master where email=? and password=?");
		ps1.setString(1, u1.getEmail());
		ps1.setString(2, u1.getPassword());
	    ResultSet rs=ps1.executeQuery();
	    
	    if(rs.next())
	    return true;
	    else
	    	return false;
		
		
	} catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return false;
}
	
	
	
	
}
