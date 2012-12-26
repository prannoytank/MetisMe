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
import javax.servlet.http.HttpSession;

import com.metisme.bean.FriendFollowBean;
import com.metisme.bean.MessageDetailsBean;
import com.metisme.bean.userdata;
import com.metisme.model.FollowAndUnfollow;
import com.metisme.model.FollowingManager;
import com.metisme.model.Messages;
import com.metisme.model.UserNameAndData;


@WebServlet("/UserDataForHomePage")
public class UserDataForHomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserNameAndData und=new UserNameAndData();
    RequestDispatcher rd=null;
    HttpSession ss=null;
    public UserDataForHomePage()
    {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
			doPost(request,response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//System.out.print("inside get");
		 ss=request.getSession(false);
		String name= (String)ss.getAttribute("user_email");
	
		//System.out.print(name);
		String username=und.username(name);
		int id=und.userid(name);
		
		HttpSession uid=request.getSession(true);
		uid.setAttribute("userid",id);
		FollowingManager fm=new FollowingManager();
		FollowAndUnfollow fnu=new FollowAndUnfollow();
		int follower=fm.countFollowers(id);
		int following=fm.countFollowing(id);
		List<MessageDetailsBean> list=und.getMessage(id);
		
		String path=und.getProfileImage(id);
		//System.out.print("path"+path);
		Messages m=new Messages();
		//List<FriendFollowBean > friend_follow_list=fnu.getYourFriendsFollowPeopleData(id);
		List<MessageDetailsBean> posts=m.yourPost(id);
		List<userdata> unknow_people=fnu.getUnknowPeopleData(id);
		List<FriendFollowBean> friend_u_follow=fnu.youFollowList(id);
		int msg_count=m.countTweets(id);
		
		
		
		
		request.setAttribute("posts",posts);
		request.setAttribute("tweets",msg_count);
		request.setAttribute("UfollowList",friend_u_follow);
		request.setAttribute("people_list",unknow_people);
      

//int count=list.size();

//request.setAttribute("friend_follow_list",friend_follow_list);
request.setAttribute("image_path",path);
request.setAttribute("userid",id);
request.setAttribute("follower", follower);
request.setAttribute("following", following);
//request.setAttribute("list_size",count);
request.setAttribute("messages",list);
request.setAttribute("username",username);

rd=request.getRequestDispatcher("/Home.jsp");
rd.forward(request,response);
			
	}

}
