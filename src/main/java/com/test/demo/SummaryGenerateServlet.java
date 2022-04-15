package com.test.demo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SummaryGenerateServlet
 */
@WebServlet("/SummaryGenerateServlet")
public class SummaryGenerateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SummaryGenerateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyDAO md = new MyDAO();
		ArrayList<permissionBean> currentPermission = md.select_all_permission();
		
		request.setAttribute("ApkSum",MyDAO.get_apk_count());
        request.setAttribute("CodeSum",md.get_code_sum());
        request.setAttribute("CFGTimeSum",md.get_CFGTime_sum());
        request.setAttribute("CFGAverage", md.get_CFGTime_avg()) ;
        request.setAttribute("FastDroidSum",md.get_FastTime_sum());
        request.setAttribute("FastDroidAverage", md.get_FastTime_avg());
        request.setAttribute("ClassSum",md.get_class_sum());
        request.setAttribute("MethodSum",md.get_method_sum());
        request.setAttribute("StatementSum",md.get_statement_sum());
        request.setAttribute("TaintSum",md.get_taint_sum());
        request.setAttribute("MayTaintSum",md.get_maytaint_sum());
        request.setAttribute("PermissionSum",MyDAO.get_permission_count());
        request.setAttribute("APISum",0);
        
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
        
        
        request.setAttribute("CFGAverage", md.get_CFGTime_avg());
        request.setAttribute("CFGMax", md.get_CFGTime_max());
        request.setAttribute("CFGMin", md.get_CFGTime_min());
        request.setAttribute("FastDroidAverage", md.get_FastTime_avg());
        request.setAttribute("FastDroidMax", md.get_FastTime_max());
        request.setAttribute("FastDroidMin", md.get_FastTime_min());
        
        
        request.getRequestDispatcher("/summaryReport.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
