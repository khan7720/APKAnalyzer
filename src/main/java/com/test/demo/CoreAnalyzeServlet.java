package com.test.demo;

import java.io.File;
import java.io.IOException;
import java.util.jar.Attributes.Name;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CoreAnalyzeServlet
 */
@WebServlet("/CoreAnalyzeServlet")
public class CoreAnalyzeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoreAnalyzeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String filename = request.getParameter("filename");
		System.out.println("文件名为"+filename);
		
		String message = "分析完成！";

        /**-----直接命令-------**/
        String s2 = "cmd /c start java -jar D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\core\\soot-infoflow-cmd-2.9.0-jar-with-dependencies.jar -a D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\core\\Button1.apk -p D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\core\\android-platforms -s D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\core\\SourcesAndSinks.txt -o D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\output\\toolResults\\flout.xml";

        String toolFlow = "java -jar D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\core\\soot-infoflow-cmd-2.9.0-jar-with-dependencies.jar";
        String toolFast = "java -jar D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\core\\xd-fastdroid-jar-with-dependencies.jar -Ftw D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\core\\EasyTaintWrapperSource.txt -Fo D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\output\\toolResults\\";
        String FastMiddle = " -Ffs -p D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\core\\android-platforms -s D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\core\\SourcesAndSinks.txt -a D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\WEB-INF\\upload\\";
        
        //String 
        
        
        StringBuilder cmd = new StringBuilder();
        cmd.append(toolFast);
        String[] nameSplit = filename.split("[.]");
        
        
        cmd.append(nameSplit[0]);
        cmd.append(FastMiddle);
        cmd.append(filename);       
        
        
        
        System.out.println(cmd.toString());
        
        
        try{
            Process proc = Runtime.getRuntime().exec(cmd.toString());
//	            HtmlToPdfInterceptor error = new HtmlToPdfInterceptor(proc.getErrorStream());
//	            HtmlToPdfInterceptor output = new HtmlToPdfInterceptor(proc.getInputStream());
//	            error.start();
//	            output.start();
            proc.waitFor();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        apkBean currentAPK = ResultExtractor.extractFile(nameSplit[0]);
        System.out.println(currentAPK.toString());
        MyDAO md = new MyDAO();
        System.out.println(md.insert_single_apk(currentAPK)); 
        
        
        
        

//	        process = Runtime.getRuntime().exec(s2);
//	        process.waitFor();
//	        int value = process.exitValue();
//	        System.out.println(value);

        request.setAttribute("currentID", currentAPK.getApkID());
	    request.setAttribute("message",message);
	    request.setAttribute("filename",filename);
		request.getRequestDispatcher("/finish.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
