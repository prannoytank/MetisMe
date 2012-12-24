package com.metisme.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metisme.bean.userdata;
import com.metisme.model.FollowAndUnfollow;


@WebServlet("/FollowPeopleServlet")
public class FollowPeopleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    FollowAndUnfollow fnu=null;
    RequestDispatcher rd=null;
    public FollowPeopleServlet()
    {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String req_type=request.getParameter("req_type");
		int uid=Integer.parseInt(request.getParameter("follow_id")); 
		fnu=new FollowAndUnfollow();
		if(req_type.equals("Follow_mutual"))
		{
			int fid=Integer.parseInt(request.getParameter("person_id"));
			try {
				
				if(fnu.FollowFriendPeople(fid, uid))
				{
					response.sendRedirect("UserDataForHomePage");
				}
				
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		List<userdata> unknow_people=fnu.getUnknowPeopleData(uid);
		request.setAttribute("people_list",unknow_people);
		
		
	}

}
