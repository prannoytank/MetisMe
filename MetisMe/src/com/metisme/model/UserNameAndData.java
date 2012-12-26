package com.metisme.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import com.metisme.bean.MessageDetailsBean;

public class UserNameAndData 
{
Connection con=DBConnection.getConnection();


	public String username(String email)
	{
		String name=null;
		try {
			System.out.print(email);
			PreparedStatement ps=con.prepareStatement("select name from user_master where email=?");
			ps.setString(1,email);
		    ResultSet rs=ps.executeQuery(); 
		    while(rs.next())
		    {
		    	name=rs.getString("name");
		    	System.out.print(name);
		    	return name;
		    }
		    
		
		} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
				
		
		return email;
	}
	
	public List<MessageDetailsBean> getMessage(int u_id)
	{
	    MessageDetailsBean mdb=null;
	    List<MessageDetailsBean> list=new ArrayList<MessageDetailsBean>();
	    try
	    {
		PreparedStatement ps=con.prepareStatement("select u_id,message,date_time from message_detail where u_id IN (select u_id from follower_detail where f_id=?) order by m_id DESC");
	    ps.setInt(1,u_id);
	    ResultSet rs=ps.executeQuery();
	    while(rs.next())
	    {   
	    	mdb=new MessageDetailsBean();
	    	mdb.setUser_id(rs.getInt("u_id"));
	    	
	    	String username=getUserName(rs.getInt("u_id"));
	    	mdb.setUsername(username);
	    	mdb.setMessage(rs.getString("message"));
	    	
	    	String date=new SimpleDateFormat("MM/dd/yyyy").format(rs.getTimestamp("date_time"));
	    	String whole=rs.getTimestamp("date_time").toString();
	    	
	    	mdb.setDate(date);
	    	String time=new SimpleDateFormat("hh:mm:ss").format(rs.getTimestamp("date_time"));
	    	//Timestamp ts1=Timestamp.valueOf(whole);
	    	//long time=ts1.
	    	
	    	
	    	mdb.setTime(time);
	    	list.add(mdb);
	    	
	    	
	    }
	    }
	    catch(Exception e)
	    {
	    	
	    	e.printStackTrace();
	    }
	    
		return list;
	}
	public String getUserName(int id)
	{
		String username = null;
		PreparedStatement ps1;
		try {
			ps1 = con.prepareStatement("select name from user_master where user_id=?");
			ps1.setInt(1,id);
			ResultSet rs=ps1.executeQuery();
			while(rs.next())
			{
				username=rs.getString("name");
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return username;
	}
	
	public boolean uploadImage(int id,String img_path)
	{
		try {
			PreparedStatement st=con.prepareStatement("update  user_master set profile_image=? where user_id=?");
			st.setString(1,img_path);
			st.setInt(2,id);
			st.executeUpdate();
			con.commit();
			st.clearBatch();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
		
		
		
	}
	public String getProfileImage(int id)
	{
		String path = null;
		PreparedStatement ps1;
		try {
			ps1 = con.prepareStatement("select profile_image from user_master where user_id=?");
			ps1.setInt(1,id);
			ResultSet rs=ps1.executeQuery();
			while(rs.next())
			{
				path=rs.getString("profile_image");
				
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return path;
	}
	
	
	
	public int userid(String email)
	{
		int id=0;
		try {
			//System.out.print(email);
			PreparedStatement ps=con.prepareStatement("select user_id from user_master where email=?");
			ps.setString(1,email);
		    ResultSet rs=ps.executeQuery(); 
		    while(rs.next())
		    {
		    	id=rs.getInt("user_id");
		    	//System.out.print(name);
		    	return id;
		    }
		    
		
		} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
				
		
		
		return id;
	}
	
	
	
	
}
