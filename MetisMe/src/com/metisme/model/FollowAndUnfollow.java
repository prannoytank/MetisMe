package com.metisme.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metisme.bean.FriendFollowBean;
import com.metisme.bean.userdata;

public class FollowAndUnfollow 
{
	Connection con=DBConnection.getConnection();
	List<userdata> u=new ArrayList<userdata>();
	
	public List<userdata> getUnknowPeopleData(int id)
	{
		try {
			userdata ud1=null;
			  PreparedStatement st=con.prepareStatement("SELECT user_id,name,email,profile_image from user_master where user_id NOT IN (Select u_id from follower_detail where f_id=?) and user_id!=?");
			  st.setInt(1,id);
			  st.setInt(2,id);
			  ResultSet rs=st.executeQuery();
			  while(rs.next())
			  {
				  ud1=new userdata();
				  ud1.setUserid(rs.getInt("user_id"));
				  ud1.setUsername(rs.getString("name"));
				  ud1.setEmail(rs.getString("email"));
				  ud1.setPath(rs.getString("profile_image"));
				  u.add(ud1);
				  
				  
			  }
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}
	public List<FriendFollowBean > getYourFriendsFollowPeopleData(int id) throws SQLException
	{
		List<FriendFollowBean > u1=new ArrayList<FriendFollowBean >();
		FriendFollowBean  ud=null;
		PreparedStatement st=con.prepareStatement("SELECT user_id,name,email,profile_image FROM user_master WHERE user_id IN (SELECT u_id FROM follower_detail WHERE f_id IN (SELECT u_id FROM follower_detail WHERE f_id =?) AND f_id!=?)");
		st.setInt(1,id);
		st.setInt(2,id);
		ResultSet rs1=st.executeQuery();
		while(rs1.next())
		{
			ud=new FriendFollowBean ();
			ud.setUserId(rs1.getInt("user_id"));
			ud.setUser_name(rs1.getString("name"));
			ud.setEmail_address(rs1.getString("email"));
			ud.setPath(rs1.getString("profile_image"));
			u1.add(ud);
		}
		
		return u1;
	}
	public boolean FollowFriendPeople(int f_id,int u_id) throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("insert into follower_detail(f_id,u_id)values(?,?)");
		pst.setInt(1,f_id);
		pst.setInt(2,u_id);
		pst.executeUpdate();
		con.commit();
		return true;
	}

}
