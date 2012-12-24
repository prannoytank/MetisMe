package com.metisme.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metisme.bean.userdata;
import com.metisme.model.registrationandlogin;


@WebServlet("/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       userdata u=new userdata();
       registrationandlogin rl=new registrationandlogin();
    RequestDispatcher rd=null;
    public UserRegistrationServlet()
    {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String req_type=request.getParameter("login");
		
		if(req_type.equals("Register"))
		{
			u.setUsername(request.getParameter("username"));
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			String message=null;
			boolean reg_result=rl.registration(u);
			
					if(reg_result==true)
					{
						message="Registration is successfull";
						request.setAttribute("result",message);
					}
       else
       {
    	   message="Registration is not completed";
    	   request.setAttribute("result",message);
    	   
       }
					rd=request.getRequestDispatcher("/Index.jsp");
					rd.forward(request, response);
		}
		else if(req_type.equals("Login"))
		{
			
			u.setEmail(request.getParameter("email_id"));
			
			u.setPassword(request.getParameter("user_password"));
			
			boolean login=rl.login(u);
			
			if(login==true)
			{
				HttpSession user_email=request.getSession(true);
				user_email.setAttribute("user_email",u.getEmail());
				
				rd=getServletContext().getRequestDispatcher("/UserDataForHomePage");
				
			}
			else
			{
				String alert="Invalid Details";
				request.setAttribute("alert",alert);
				rd=request.getRequestDispatcher("/Index.jsp");	
			}
			rd.forward(request, response);
			
			
			
			
		}
	}

}
