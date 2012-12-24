package com.metisme.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.metisme.bean.MessageDetailsBean;

public class Messages

{
	Connection con=DBConnection.getConnection();
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
