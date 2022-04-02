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
}
