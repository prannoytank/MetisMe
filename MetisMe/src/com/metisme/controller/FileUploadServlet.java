package com.metisme.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.eclipse.core.internal.resources.Resource;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;

import com.metisme.model.UserNameAndData;
//import com.neeta.model.PackageImages;


@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
                                     
        
    
    public FileUploadServlet() 
    {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.print("inside post");
		HttpSession ses=request.getSession(false);
		int UserId=(Integer) ses.getAttribute("userid");
		
		UserNameAndData und=new UserNameAndData();
		
		 boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		 
	        if (isMultipart) {
	            FileItemFactory factory = new DiskFileItemFactory();
	            ServletFileUpload upload = new ServletFileUpload(factory);
	 
	            try {
	                List items = upload.parseRequest(request);
	                Iterator iterator = items.iterator();
	                while (iterator.hasNext()) {
	                    FileItem item = (FileItem) iterator.next();
	 
	                    if (!item.isFormField()) {
	                        String fileName = item.getName();
	 
	                        String relativeWebPath = "workspace/MetisMe/WebContent/ProfileImages";
	                        //String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
	                        String absoluteDiskPath="C:/Users/Ashirwad Tank/Desktop/MetisMe/WebContent/ProfileImages/";
	                        String filename = FilenameUtils.getName(item.getName());
	                        File file = new File(absoluteDiskPath, filename);
	                        //File path = new File(root + "/ProfileImages");
	                       // System.out.print("root"+file);
	                       
	 
	                       // File uploadedFile = new File(path + "/" + fileName);
	                        //System.out.println(file.getAbsolutePath());
	                        item.write(file);
	                      
	                      // IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
	                       
	                       //IResource.refreshLocal();
	                       //Resource.refreshLocal(IResource.DEPTH_INFINITE,null);

	                        boolean result=und.uploadImage(UserId,filename);
	                           if(result==true)
	                           {
	                        	   response.sendRedirect("UserDataForHomePage");
	                        	   
	                           }
	                    }
	                }
	            }
	            catch (FileUploadException e) 
	            {
	                e.printStackTrace();
	            } 
	            catch (Exception e)
	            {
	                e.printStackTrace();
	            }
	        }
	    }
	}

	


