package cn.wit.servlet;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import cn.wit.common.ExcelToModelListUtil;

/**
 * Servlet implementation class ExcelUploadServlet
 */
@WebServlet("/ExcelUploadServlet.do")
public class ExcelUploadServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //�������̹�������
	    DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
	    //����servlet�ļ��ϴ����Ķ���
	    ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
	    
	    try {
	        RequestContext requestContext = new ServletRequestContext(request);
	        List<FileItem> fileItemList = fileUpload.parseRequest(requestContext);
	        System.out.println("size:" + fileItemList.size());
	        InputStream is = fileItemList.get(0).getInputStream();
	        ExcelToModelListUtil.getList(is);
	        request.setAttribute("excelMsg", "����ɹ�!");
		    request.getRequestDispatcher("admin/excelUpload.jsp").forward(request,response);
	    } catch (FileUploadException e) {
	    	request.setAttribute("excelMsg", "����ʧ��!");
	        request.getRequestDispatcher("admin/excelUpload.jsp").forward(request,response);
	    }
	}
}
