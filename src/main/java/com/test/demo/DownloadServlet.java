package com.test.demo;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filename = request.getParameter("filename");
		System.out.println(filename);
		
		//String path = this.getServletContext().getRealPath("D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\output\\pdf\\"+filename);
		String path = "D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\output\\pdf\\"+filename;
				
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		
		String mimeType = this.getServletContext().getMimeType(filename);
		response.setContentType(mimeType);
		
		
		System.out.println(path);
		
		ServletOutputStream out = response.getOutputStream();
		
		FileInputStream in = new FileInputStream(path);
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len=in.read(buffer))!=-1) {
			out.write(buffer,0,len);
		}
		in.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
