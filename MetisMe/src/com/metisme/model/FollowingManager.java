package com.metisme.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.metisme.bean.Follower;

//import com.connectme.entity.Follower;

public class FollowingManager {
	
	Connection con=DBConnection.getConnection();
	
	public boolean insertFollowDetails(Follower f)
	{
		try {
			
			PreparedStatement ps=con.prepareStatement("INSERT INTO `follower_detail`(`f_id`, `u_id`) VALUES (?,?)");
			ps.setInt(1,f.getFid());
			ps.setInt(2,f.getUid());
			ps.executeUpdate();
			con.commit();
			return true;	
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	return false;	
}
	
	public int countFollowers(int uid)
	{
		
		try {
			
			PreparedStatement ps1=con.prepareStatement("select count(*) from follower_detail where `u_id`= ? ");
			ps1.setInt(1, uid);
			ResultSet rs=ps1.executeQuery();
		    
		    if(rs.next())
		    {
		    	return rs.getInt(1);
		    }
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}

public int countFollowing(int fid)
{
	
	try {
		
		PreparedStatement ps1=con.prepareStatement("select count(*) from follower_detail where `f_id`=?");
		ps1.setInt(1, fid);
		ResultSet rs=ps1.executeQuery();
	    
	    if(rs.next())
	    {
	    	return rs.getInt(1);
	    }
		
	} catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
	
}
}
