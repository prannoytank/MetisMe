package com.metisme.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.metisme.bean.MessageDetailsBean;

public class Messages

{
	Connection con=DBConnection.getConnection();
public int countTweets(int id)
{
	int tweets=0;
	try {
		PreparedStatement st3=con.prepareStatement("select count(message) from message_detail where u_id=?");
		st3.setInt(1,id);
		ResultSet rs5=st3.executeQuery();
		while(rs5.next())
			tweets=rs5.getInt(1);
		
	return tweets;
	}
	
	catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	return tweets;
	
}
public List<MessageDetailsBean> yourPost(int id)
{
	List<MessageDetailsBean> l=new ArrayList<MessageDetailsBean>();
	MessageDetailsBean mdb=null;
	PreparedStatement st3;
	try {
		st3 = con.prepareStatement("select message,date_time from message_detail where u_id=? order by m_id DESC");
		st3.setInt(1,id);
		ResultSet rs6=st3.executeQuery();
		while(rs6.next())
		{
			mdb=new MessageDetailsBean();
			mdb.setMessage(rs6.getString("message"));
			String date=new SimpleDateFormat("MM/dd/yyyy").format(rs6.getTimestamp("date_time"));
			mdb.setDate(date);
			String time=new SimpleDateFormat("hh:mm:ss").format(rs6.getTimestamp("date_time"));
			mdb.setTime(time);
			l.add(mdb);
		}
		return l;
	
	} catch (SQLException e)
	{
		return l=null;
	}
	
	
	
	
}

	
	public boolean update(MessageDetailsBean mdb)
	{
		
		try {
			
			PreparedStatement pst=con.prepareStatement("insert into message_detail(message,date_time,u_id)values(?,?,?)");
			pst.setString(1, mdb.getMessage());
			//String datetime=mdb.getDate()+" "+mdb.getTime(); 
			java.util.Date date= new java.util.Date();
			 //System.out.println();
			
			Timestamp ts=new Timestamp(date.getTime());
			pst.setTimestamp(2,ts);
			pst.setInt(3,mdb.getUser_id());
			
			pst.executeUpdate();
			con.commit();
			return true;
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return false;
		
		
		
		
	}

}
