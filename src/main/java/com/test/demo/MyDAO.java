package com.test.demo;

import java.sql.*;
import java.util.ArrayList;

public class MyDAO {
	public ArrayList<apkBean> select_all_apk(){
		Connection conn=null;
		Statement stmt = null;
		ResultSet rst = null;
		try {		
		conn=DBUtil.getConncetion();	
		stmt=conn.createStatement();
		String sql = "select * from apkinfo";
		rst=stmt.executeQuery(sql);
		ArrayList<apkBean> array = new ArrayList<apkBean>();
		while(rst.next()){
			apkBean apk = new apkBean();
			apk.setApkID(rst.getInt("apkID"));
			apk.setApkName(rst.getString("apkName"));
			apk.setApkSize(rst.getInt("apkSize"));
			apk.setCodeSize(rst.getInt("codeSize"));
			apk.setCFGTime(rst.getFloat("CFGTime"));
			apk.setFastDroidTime(rst.getFloat("FastDroidTime"));
			apk.setAnalysedClass(rst.getInt("AnalysedClass"));
			apk.setAnalysedMethod(rst.getInt("AnalysedMethod"));
			apk.setAnalysedStatement(rst.getInt("AnalysedStatement"));
			apk.setTaintFlow(rst.getInt("TaintFlow"));
			apk.setMayTaintFlow(rst.getInt("MayTaintFlow"));
			apk.setStartTime(rst.getString("StartTime"));
			apk.setPermission(rst.getInt("permission"));
			apk.setAPI(rst.getInt("API"));
			
			array.add(apk);
		}
		stmt.close();
		rst.close();
		conn.close();
		return array;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("读取失败");
			return new ArrayList<apkBean>();
		}
		
	}
	
	public ArrayList<apiBean> select_all_api(){
		Connection conn=null;
		Statement stmt = null;
		ResultSet rst = null;
		try {		
		conn=DBUtil.getConncetion();	
		stmt=conn.createStatement();
		String sql = "select * from api";
		rst=stmt.executeQuery(sql);
		ArrayList<apiBean> array = new ArrayList<apiBean>();
		while(rst.next()){
			apiBean api = new apiBean();
			api.setAid(rst.getInt("aid"));
			api.setApkid(rst.getInt("apkid"));
			api.setAname(rst.getString("aname"));
			array.add(api);
		}
		stmt.close();
		rst.close();
		conn.close();
		return array;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("读取失败");
			return new ArrayList<apiBean>();
		}
		
	}
	
	public static int get_apk_count() {
		Connection conn=null;
		Statement stmt = null;
		ResultSet rst = null;
		int recordCount = 0;
		try {		
		conn=DBUtil.getConncetion();	
		stmt=conn.createStatement();
		String sql = "select count(*) from apkinfo";
		rst=stmt.executeQuery(sql);
		if (rst.next()) 
	      {
	              recordCount = rst.getInt(1);
	       }
		stmt.close();
		rst.close();
		conn.close();
		return recordCount;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("读取数目失败");
			return -1;
		}
	}
	
	public boolean insert_single_apk(apkBean a) {
		Connection conn = DBUtil.getConncetion();;
		PreparedStatement ps = null;
		
		String sql = "insert into apkinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
		//String insertSQLhead = "insert into apkinfo values (";
		//String currentAPKinfo = String.valueOf(a.getApkID())+", \'"+a.getApkName()+"\', "+String.valueOf(a.getApkSize())+", "+String.valueOf(a.getCodeSize())+", "+String.valueOf(a.getCFGTime())+", "+String.valueOf(a.getFastDroidTime())+", "+String.valueOf(a.getAnalysedClass())+", "+String.valueOf(a.getAnalysedMethod())+", "+String.valueOf(a.getAnalysedStatement())+", "+String.valueOf(a.getTaintFlow())+", "+String.valueOf(a.getMayTaintFlow())+", \'"+a.getStartTime()+"\', "+String.valueOf(a.getPermission())+", "+String.valueOf(a.getAPI())+")";
		//System.out.println(sql);
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, a.getApkID());
			ps.setString(2, a.getApkName());
			ps.setInt(3, a.getApkSize());
			ps.setInt(4, a.getCodeSize());
			ps.setFloat(5, a.getCFGTime());
			ps.setFloat(6, a.getFastDroidTime());
			ps.setInt(7, a.getAnalysedClass());
			ps.setInt(8, a.getAnalysedMethod());
			ps.setInt(9, a.getAnalysedStatement());
			ps.setInt(10, a.getTaintFlow());
			ps.setInt(11, a.getMayTaintFlow());
			ps.setString(12, a.getStartTime());
			ps.setInt(13, a.getPermission());
			ps.setInt(14, a.getAPI());
			
			
			ps.executeUpdate();
	
			conn.close();
			System.out.println("添加成功");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("添加失败");
			return false;
		}
	}

	public apkBean get_single_apk_by_id(String currentID) {
		Connection conn=null;
		Statement stmt = null;
		ResultSet rst = null;
		try {		
		conn=DBUtil.getConncetion();	
		stmt=conn.createStatement();
		String selectHeader = "select * from apkinfo where apkID = ";
		String sql = selectHeader+String.valueOf(currentID);
		rst=stmt.executeQuery(sql);
		apkBean apk = new apkBean();
		while(rst.next()){			
			apk.setApkID(rst.getInt("apkID"));
			apk.setApkName(rst.getString("apkName"));
			apk.setApkSize(rst.getInt("apkSize"));
			apk.setCodeSize(rst.getInt("codeSize"));
			apk.setCFGTime(rst.getFloat("CFGTime"));
			apk.setFastDroidTime(rst.getFloat("FastDroidTime"));
			apk.setAnalysedClass(rst.getInt("AnalysedClass"));
			apk.setAnalysedMethod(rst.getInt("AnalysedMethod"));
			apk.setAnalysedStatement(rst.getInt("AnalysedStatement"));
			apk.setTaintFlow(rst.getInt("TaintFlow"));
			apk.setMayTaintFlow(rst.getInt("MayTaintFlow"));
			apk.setStartTime(rst.getString("StartTime"));
			apk.setPermission(rst.getInt("permission"));
			apk.setAPI(rst.getInt("API"));
		}
		stmt.close();
		rst.close();
		conn.close();
		return apk;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("读取失败");
			return new apkBean();
		}
	}
}
