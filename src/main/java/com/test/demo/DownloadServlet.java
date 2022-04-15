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
		String fullname = request.getParameter("filename");
		String currentID = request.getParameter("currentID");
		String realName = fullname.substring(0,fullname.length()-4);
		String filename = realName;
		System.out.println(filename);
		String pdfname = filename+"ID-"+currentID+".pdf";
		
		
		String htmlname = htmlUnitTest.generateHTML(fullname,currentID);
		
		String toPdfDest = "D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\output\\pdf\\"+pdfname;
		
		HTMLtoPDF.convert(htmlname, toPdfDest);
				
		
		//String path = this.getServletContext().getRealPath("D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\output\\pdf\\"+filename);
		String path = "D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\output\\pdf\\"+pdfname;
				
		response.setHeader("Content-Disposition", "attachment;filename="+pdfname);
		
		String mimeType = this.getServletContext().getMimeType(pdfname);
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
