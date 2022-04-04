package com.test.demo;

import java.io.IOException;
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
		
        
        MyDAO md = new MyDAO();
        apkBean currentAPK = md.get_single_apk_by_id(currentID);

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
        
        request.getRequestDispatcher("/testReport.jsp").forward(request, response);
   

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
