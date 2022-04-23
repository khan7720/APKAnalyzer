package com.test.demo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		
		String filename = request.getParameter("filename").replace(" ", "");
		System.out.println("文件名为"+filename);
		
		String message = "分析完成！";

        /**-----直接命令-------**/
        
        String toolFlow = "java -jar D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\core\\soot-infoflow-cmd-2.9.0-jar-with-dependencies.jar -p D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\core\\android-platforms -s D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\core\\SourcesAndSinks.txt -a D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\WEB-INF\\upload\\";
        String FlowMiddle = "-o D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\output\\flowXMLs\\";
        
        String toolFast = "java -jar D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\core\\xd-fastdroid-jar-with-dependencies.jar -Ftw D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\core\\EasyTaintWrapperSource.txt -Fo D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\output\\toolResults\\";
        String FastMiddle = " -Ffs -p D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\core\\android-platforms -s D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\core\\SourcesAndSinks.txt -a D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\WEB-INF\\upload\\";
        
        //String 
        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
        String outfileDate = df.format(new Date());
        
        
        StringBuilder Fastcmd = new StringBuilder();
        Fastcmd.append(toolFast);
        String realName = filename.substring(0,filename.length()-4);

        
        
        Fastcmd.append(realName+outfileDate);
        Fastcmd.append(FastMiddle);
        Fastcmd.append(filename);                            
        System.out.println(Fastcmd.toString());
        
        
        
        StringBuilder Flowcmd = new StringBuilder();
        Flowcmd.append(toolFlow);
        Flowcmd.append(filename);
        Flowcmd.append(FlowMiddle);
        Flowcmd.append(realName+outfileDate);
        System.out.println(Flowcmd.toString());
        
        
        try{
            Process proc = Runtime.getRuntime().exec(Fastcmd.toString());
            proc.waitFor();
        }catch(Exception e){
            e.printStackTrace();
        }
        
//        try{
//            Process proc = Runtime.getRuntime().exec(Flowcmd.toString());
//            proc.waitFor();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        
        
        apkBean currentAPK = ResultExtractor.extractAPKinfo(realName+outfileDate);
        ArrayList<permissionBean> currentplist = ResultExtractor.extractPermission(realName+outfileDate, currentAPK.getApkID());
        ArrayList<apiBean> currentalist = ResultExtractor.extractAPI(realName+outfileDate, currentAPK.getApkID());
        currentAPK.setAPI(currentalist.size());
        System.out.println(currentAPK.toString());
        MyDAO md = new MyDAO();
        md.insert_single_apk(currentAPK); 
        for(permissionBean pb:currentplist) {
        	md.insert_single_permission(pb);
        }
        for(apiBean ab:currentalist) {
        	md.insert_single_api(ab);
        }
        
        
        
        

        request.setAttribute("currentID", currentAPK.getApkID());
	    request.setAttribute("message",message);
	    request.setAttribute("filename",filename);
		request.getRequestDispatcher("/Result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
