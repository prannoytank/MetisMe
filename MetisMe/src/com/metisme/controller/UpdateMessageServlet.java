package com.metisme.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metisme.bean.MessageDetailsBean;
import com.metisme.model.Messages;

@WebServlet("/UpdateMessageServlet")
public class UpdateMessageServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    RequestDispatcher rd=null;
    public UpdateMessageServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//HttpSession ses=request.getSession(false);
		//String email=(String) ses.getAttribute("user_email");
		int id=Integer.parseInt(request.getParameter("user_id"));
		MessageDetailsBean mdb=new MessageDetailsBean();
		mdb.setUser_id(id);
		mdb.setMessage(request.getParameter("status"));
		//SimpleDateFormat date=new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
    	mdb.setTime(sdf.format(cal.getTime()));
    	String pattern = "yyyy-mm-dd";
    	String dateInString =new SimpleDateFormat(pattern).format(new Date());
    	mdb.setDate(dateInString);
		
		
		
		String upd_msg;
		
		
		//mdb.setDate()
		
		Messages m=new Messages();
		boolean result=m.update(mdb);
		if(result==true)
		upd_msg="Status Updated Successfully";
		else
		upd_msg="Status Not Updated";
		request.setAttribute("upd_msg", upd_msg);
		
		rd=request.getRequestDispatcher("UserDataForHomePage");
		rd.forward(request, response);
		
		
		
	}

}
