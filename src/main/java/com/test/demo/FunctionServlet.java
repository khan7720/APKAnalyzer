package com.test.demo;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FunctionServlet
 */
@WebServlet("/FunctionServlet")
public class FunctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FunctionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MyDAO md = new MyDAO();
		apkBean[] array = new apkBean[5];
		for(int i=0;i<5;i++) {
			array[i] = new apkBean();
		}
		
		int maxIDINT = MyDAO.get_apk_count();

		for(int i=0;i<5;i++) {
			if(maxIDINT>0) {
				array[i].setApkName(md.get_single_apk_by_id(String.valueOf(maxIDINT)).getApkName());
				array[i].setApkID(maxIDINT);
				array[i].setStartTime(md.get_single_apk_by_id(String.valueOf(maxIDINT)).getStartTime());
				maxIDINT--;
			}else {break;}
		}

		
		
		request.setAttribute("a1name", array[0].getApkName());
        request.setAttribute("a1id", array[0].getApkID());
        request.setAttribute("a1time", array[0].getStartTime());
        request.setAttribute("a2name", array[1].getApkName());
        request.setAttribute("a2id", array[1].getApkID());
        request.setAttribute("a2time", array[1].getStartTime());
        request.setAttribute("a3name", array[2].getApkName());
        request.setAttribute("a3id", array[2].getApkID());
        request.setAttribute("a3time", array[2].getStartTime());
        request.setAttribute("a4name", array[3].getApkName());
        request.setAttribute("a4id", array[3].getApkID());
        request.setAttribute("a4time", array[3].getStartTime());
        request.setAttribute("a5name", array[4].getApkName());
        request.setAttribute("a5id", array[4].getApkID());
        request.setAttribute("a5time", array[4].getStartTime());
        
        request.getRequestDispatcher("/function.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
