package com.test.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReportGenerateServlet
 */
@WebServlet("/ReportGenerateServlet")
public class ReportGenerateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportGenerateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filename = request.getParameter("filename");
		String currentID = request.getParameter("currentID");
		System.out.println("currentID="+currentID);
		System.out.println("正在生成"+filename+"的jsp报告");
		
		request.setAttribute("filename", filename);
        request.setAttribute("currentID", currentID);
		
        
        MyDAO md = new MyDAO();
        apkBean currentAPK = md.get_single_apk_by_id(currentID);
        ArrayList<permissionBean> currentPermission = md.select_permission_by_apkid(currentID);
        ArrayList<apiBean> currentAPI = md.select_api_by_apkid(currentID);
        
        request.setAttribute("plist", currentPermission);
        request.setAttribute("alist", currentAPI);
        
        
        request.setAttribute("ApknameToShow", currentAPK.getApkName());
        request.setAttribute("ApkSizeToShow", currentAPK.getApkSize());
        request.setAttribute("CodeSizeToShow", currentAPK.getCodeSize());
        request.setAttribute("CFGTimeToShow", currentAPK.getCFGTime());
        request.setAttribute("FastDroidTimeToShow", currentAPK.getFastDroidTime());
        request.setAttribute("AnalysedClassToShow", currentAPK.getAnalysedClass());
        request.setAttribute("AnalysedMethodToShow", currentAPK.getAnalysedMethod());
        request.setAttribute("AnalysedStatementToShow", currentAPK.getAnalysedStatement());
        request.setAttribute("TaintFlowToShow", currentAPK.getTaintFlow());
        request.setAttribute("MayTaintFlowToShow", currentAPK.getMayTaintFlow());
        request.setAttribute("StartTimeToShow", currentAPK.getStartTime());
        request.setAttribute("PermissionToShow", currentAPK.getPermission());
        request.setAttribute("APIToShow", currentAPK.getAPI());
        
        
        int currentDangerous = 0, currentSignature = 0, currentNormal = 0, currentOthers = 0;
        for(permissionBean pb: currentPermission) {
        	if(pb.getPlevel().equals("dangerous")) {
        		currentDangerous ++;
        	}else if(pb.getPlevel().equals("signature")) {
        		currentSignature++;
        	}else if(pb.getPlevel().equals("normal")) {
        		currentNormal++;
        	}else currentOthers++;
        }
        request.setAttribute("dangerousCount", currentDangerous);
        request.setAttribute("signatureCount", currentSignature);
        request.setAttribute("normalCount", currentNormal);
        request.setAttribute("othersCount", currentOthers);
        
        if(!currentAPI.isEmpty()) {
        	request.setAttribute("SourceCaller", simplifyAPI(currentAPI.get(0).getCaller().substring(currentAPI.get(0).getCaller().indexOf(",")+1,currentAPI.get(0).getCaller().length())));
            request.setAttribute("SinkCaller", simplifyAPI(currentAPI.get(1).getCaller().substring(currentAPI.get(1).getCaller().indexOf(",")+1,currentAPI.get(1).getCaller().length())));
            request.setAttribute("SourceName", simplifyAPI(currentAPI.get(0).getAname().substring(currentAPI.get(0).getAname().indexOf(":")+1,currentAPI.get(0).getAname().length())));
            request.setAttribute("SinkName", simplifyAPI(currentAPI.get(1).getAname().substring(currentAPI.get(1).getAname().indexOf(":")+1,currentAPI.get(1).getAname().length())));
            request.setAttribute("Permission1", "READ_PHONE_STATE");
            request.setAttribute("Permission2", "SEND_SMS");
            
        }else {
        	request.setAttribute("SourceCaller","");
            request.setAttribute("SinkCaller", "");
            request.setAttribute("SourceName", "");
            request.setAttribute("SinkName", "");
            request.setAttribute("Permission1", "READ_PHONE_STATE");
            request.setAttribute("Permission2", "SEND_SMS");
        }
        

        
        
        request.setAttribute("CFGAverage", md.get_CFGTime_avg());
        request.setAttribute("FastDroidAverage", md.get_FastTime_avg());
        request.setAttribute("apkSizeAverage", md.get_apksize_avg());
        request.setAttribute("codeSizeAverage", md.get_code_avg());
      
        
        request.getRequestDispatcher("/SingleReport.jsp").forward(request, response);
   

	}
	
	public String simplifyAPI(String api) {
		String inner = api.substring(api.indexOf('(')+1,api.indexOf(')'));
		return api.replace(inner, "");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
