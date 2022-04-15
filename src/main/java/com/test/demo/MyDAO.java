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
			System.out.println("读取所有apk失败");
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
			api.setCaller(rst.getString("caller"));
			api.setRouteType(rst.getString("routeType"));;
			array.add(api);
		}
		stmt.close();
		rst.close();
		conn.close();
		return array;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("读取所有api失败");
			return new ArrayList<apiBean>();
		}
		
	}
	
	public ArrayList<permissionBean> select_all_permission(){
		Connection conn=null;
		Statement stmt = null;
		ResultSet rst = null;
		try {		
		conn=DBUtil.getConncetion();	
		stmt=conn.createStatement();
		String sql = "select * from permission";
		rst=stmt.executeQuery(sql);
		ArrayList<permissionBean> array = new ArrayList<permissionBean>();
		while(rst.next()){
			permissionBean pms = new permissionBean();
			pms.setPid(rst.getInt("pid"));
			pms.setApkid(rst.getInt("apkid"));
			pms.setPname(rst.getString("pname"));
			pms.setPlevel(rst.getString("plevel"));
			array.add(pms);
		}
		stmt.close();
		rst.close();
		conn.close();
		return array;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("读取所有permission失败");
			return new ArrayList<permissionBean>();
		}
		
	}
	
	public ArrayList<permissionBean> select_permission_by_apkid(String apkid){
		Connection conn=null;
		Statement stmt = null;
		ResultSet rst = null;
		try {		
		conn=DBUtil.getConncetion();	
		stmt=conn.createStatement();
		String selectHeader = "select * from permission where apkid = ";
		String sql = selectHeader+apkid;
		rst=stmt.executeQuery(sql);
		ArrayList<permissionBean> array = new ArrayList<permissionBean>();
		while(rst.next()){
			permissionBean pms = new permissionBean();
			pms.setPid(rst.getInt("pid"));
			pms.setApkid(rst.getInt("apkid"));
			pms.setPname(rst.getString("pname"));
			pms.setPlevel(rst.getString("plevel"));
			array.add(pms);
		}
		stmt.close();
		rst.close();
		conn.close();
		return array;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("以apkid读取permission失败");
			return new ArrayList<permissionBean>();
		}
		
	}
	
	public ArrayList<apiBean> select_api_by_apkid(String apkid){
		Connection conn=null;
		Statement stmt = null;
		ResultSet rst = null;
		try {		
		conn=DBUtil.getConncetion();	
		stmt=conn.createStatement();
		String selectHeader = "select * from api where apkid = ";
		String sql = selectHeader+apkid;
		rst=stmt.executeQuery(sql);
		ArrayList<apiBean> array = new ArrayList<apiBean>();
		while(rst.next()){
			apiBean api = new apiBean();
			api.setAid(rst.getInt("aid"));
			api.setApkid(rst.getInt("apkid"));
			api.setAname(rst.getString("aname"));
			api.setCaller(rst.getString("caller"));
			api.setRouteType(rst.getString("routeType"));
			array.add(api);
		}
		stmt.close();
		rst.close();
		conn.close();
		return array;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("以apkid读取api失败");
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
			System.out.println("读取apk数目失败");
			return -1;
		}
	}
	
	public static int get_permission_count() {
		Connection conn=null;
		Statement stmt = null;
		ResultSet rst = null;
		int recordCount = 0;
		try {		
		conn=DBUtil.getConncetion();	
		stmt=conn.createStatement();
		String sql = "select count(*) from permission";
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
			System.out.println("读取permission数目失败");
			return -1;
		}
	}
	
	public void insert_single_apk(apkBean a) {
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
			System.out.println(a.toString()+"apk添加成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(a.toString()+"apk添加失败");
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
			System.out.println("apk读取失败");
			return new apkBean();
		}
	}

	public void insert_single_permission(permissionBean pb)  {
		Connection conn = DBUtil.getConncetion();;
		PreparedStatement ps = null;					
		String sql = "insert into permission values(?,?,?,?)";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, pb.getPid());
			ps.setInt(2, pb.getApkid());
			ps.setString(3, pb.getPname());
			ps.setString(4, pb.getPlevel());
								
			ps.executeUpdate();
	
			conn.close();
			System.out.println(pb.toString()+"permission添加成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(pb.toString()+"permission添加失败");
		}
	}

	public int get_code_sum() {
		Connection conn=null;
		Statement stmt = null;
		ResultSet rst = null;
		int codeSum = 0;
		try {		
		conn=DBUtil.getConncetion();	
		stmt=conn.createStatement();
		String sql = "select sum(codeSize) from apkinfo";
		rst=stmt.executeQuery(sql);
		if (rst.next()) 
	      {
	              codeSum = rst.getInt(1);
	       }
		stmt.close();
		rst.close();
		conn.close();
		return codeSum;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("读取code总和失败");
			return -1;
		}
	}
	
	public float get_CFGTime_sum() {
		Connection conn=null;
		Statement stmt = null;
		ResultSet rst = null;
		float CFGTimeSum = 0;
		try {		
		conn=DBUtil.getConncetion();	
		stmt=conn.createStatement();
		String sql = "select round(sum(CFGTime),5) from apkinfo";
		rst=stmt.executeQuery(sql);
		if (rst.next()) 
	      {
			CFGTimeSum = rst.getFloat(1);
	       }
		stmt.close();
		rst.close();
		conn.close();
		return CFGTimeSum;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("读取CFGTime总和失败");
			return -1;
		}
	}
	
	public float get_FastTime_sum() {
		Connection conn=null;
		Statement stmt = null;
		ResultSet rst = null;
		float FastTimeSum = 0;
		try {		
		conn=DBUtil.getConncetion();	
		stmt=conn.createStatement();
		String sql = "select round(sum(FastDroidTime),5) from apkinfo";
		rst=stmt.executeQuery(sql);
		if (rst.next()) 
	      {
			FastTimeSum = rst.getFloat(1);
	       }
		stmt.close();
		rst.close();
		conn.close();
		return FastTimeSum;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("读取FastTime总和失败");
			return -1;
		}
	}
	
	public int get_class_sum() {
		Connection conn=null;
		Statement stmt = null;
		ResultSet rst = null;
		int classSum = 0;
		try {		
		conn=DBUtil.getConncetion();	
		stmt=conn.createStatement();
		String sql = "select sum(AnalysedClass) from apkinfo";
		rst=stmt.executeQuery(sql);
		if (rst.next()) 
	      {
			classSum = rst.getInt(1);
	       }
		stmt.close();
		rst.close();
		conn.close();
		return classSum;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("读取class总和失败");
			return -1;
		}
	}
	
	public int get_method_sum() {
		Connection conn=null;
		Statement stmt = null;
		ResultSet rst = null;
		int methodSum = 0;
		try {		
		conn=DBUtil.getConncetion();	
		stmt=conn.createStatement();
		String sql = "select sum(AnalysedMethod) from apkinfo";
		rst=stmt.executeQuery(sql);
		if (rst.next()) 
	      {
			methodSum = rst.getInt(1);
	       }
		stmt.close();
		rst.close();
		conn.close();
		return methodSum;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("读取method总和失败");
			return -1;
		}
	}
	
	public int get_statement_sum() {
		Connection conn=null;
		Statement stmt = null;
		ResultSet rst = null;
		int statementSum = 0;
		try {		
		conn=DBUtil.getConncetion();	
		stmt=conn.createStatement();
		String sql = "select sum(AnalysedStatement) from apkinfo";
		rst=stmt.executeQuery(sql);
		if (rst.next()) 
	      {
			statementSum = rst.getInt(1);
	       }
		stmt.close();
		rst.close();
		conn.close();
		return statementSum;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("读取statement总和失败");
			return -1;
		}
	}
	
	public int get_taint_sum() {
		Connection conn=null;
		Statement stmt = null;
		ResultSet rst = null;
		int taintSum = 0;
		try {		
		conn=DBUtil.getConncetion();	
		stmt=conn.createStatement();
		String sql = "select sum(TaintFlow) from apkinfo";
		rst=stmt.executeQuery(sql);
		if (rst.next()) 
	      {
			taintSum = rst.getInt(1);
	       }
		stmt.close();
		rst.close();
		conn.close();
		return taintSum;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("读取taint总和失败");
			return -1;
		}
	}
	
	public int get_maytaint_sum() {
		Connection conn=null;
		Statement stmt = null;
		ResultSet rst = null;
		int maytaintSum = 0;
		try {		
		conn=DBUtil.getConncetion();	
		stmt=conn.createStatement();
		String sql = "select sum(MayTaintFlow) from apkinfo";
		rst=stmt.executeQuery(sql);
		if (rst.next()) 
	      {
			maytaintSum = rst.getInt(1);
	       }
		stmt.close();
		rst.close();
		conn.close();
		return maytaintSum;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("读取maytaint总和失败");
			return -1;
		}
	}

	public float get_CFGTime_avg() {
		Connection conn=null;
		Statement stmt = null;
		ResultSet rst = null;
		float CFGTime = 0;
		try {		
		conn=DBUtil.getConncetion();	
		stmt=conn.createStatement();
		String sql = "select round(avg(CFGTime),5) from apkinfo";
		rst=stmt.executeQuery(sql);
		if (rst.next()) 
	      {
			CFGTime = rst.getFloat(1);
	       }
		stmt.close();
		rst.close();
		conn.close();
		return CFGTime;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("读取CFGTime平均数失败");
			return -1;
		}
	}

	public float get_FastTime_avg() {
		Connection conn=null;
		Statement stmt = null;
		ResultSet rst = null;
		float FastTime = 0;
		try {		
		conn=DBUtil.getConncetion();	
		stmt=conn.createStatement();
		String sql = "select round(avg(FastDroidTime),5) from apkinfo";
		rst=stmt.executeQuery(sql);
		if (rst.next()) 
	      {
			FastTime = rst.getFloat(1);
	       }
		stmt.close();
		rst.close();
		conn.close();
		return FastTime;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("读取FastTime平均数失败");
			return -1;
		}
	}
	
	public int get_apksize_avg() {
		Connection conn=null;
		Statement stmt = null;
		ResultSet rst = null;
		int avg = 0;
		try {		
		conn=DBUtil.getConncetion();	
		stmt=conn.createStatement();
		String sql = "select avg(apkSize) from apkinfo";
		rst=stmt.executeQuery(sql);
		if (rst.next()) 
	      {
			avg = rst.getInt(1);
	       }
		stmt.close();
		rst.close();
		conn.close();
		return avg;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("读取apksize平均数失败");
			return -1;
		}
}
	
		public int get_code_avg() {
			Connection conn=null;
			Statement stmt = null;
			ResultSet rst = null;
			int avg = 0;
			try {		
			conn=DBUtil.getConncetion();	
			stmt=conn.createStatement();
			String sql = "select avg(codeSize) from apkinfo";
			rst=stmt.executeQuery(sql);
			if (rst.next()) 
		      {
				avg = rst.getInt(1);
		       }
			stmt.close();
			rst.close();
			conn.close();
			return avg;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("读取code平均数失败");
				return -1;
			}
	}

		public static int get_api_count() {
			Connection conn=null;
			Statement stmt = null;
			ResultSet rst = null;
			int recordCount = 0;
			try {		
			conn=DBUtil.getConncetion();	
			stmt=conn.createStatement();
			String sql = "select count(*) from api";
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
				System.out.println("读取api数目失败");
				return -1;
			}
		}

		public void insert_single_api(apiBean ab) {
			Connection conn = DBUtil.getConncetion();;
			PreparedStatement ps = null;					
			String sql = "insert into api values(?,?,?,?,?)";
			
			try {
				ps=conn.prepareStatement(sql);
				ps.setInt(1, ab.getAid());
				ps.setInt(2, ab.getApkid());
				ps.setString(3, ab.getAname());
				ps.setString(4, ab.getCaller());
				ps.setString(5, ab.getRouteType());
									
				ps.executeUpdate();
		
				conn.close();
				System.out.println(ab.toString()+"API添加成功");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(ab.toString()+"API添加失败");
			}
		}

		public Object get_CFGTime_max() {
			Connection conn=null;
			Statement stmt = null;
			ResultSet rst = null;
			float CFGTime = 0;
			try {		
			conn=DBUtil.getConncetion();	
			stmt=conn.createStatement();
			String sql = "select max(CFGTime) from apkinfo";
			rst=stmt.executeQuery(sql);
			if (rst.next()) 
		      {
				CFGTime = rst.getFloat(1);
		       }
			stmt.close();
			rst.close();
			conn.close();
			return CFGTime;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("读取CFGTime max失败");
				return -1;
			}
		}

		public Object get_CFGTime_min() {
			Connection conn=null;
			Statement stmt = null;
			ResultSet rst = null;
			float CFGTime = 0;
			try {		
			conn=DBUtil.getConncetion();	
			stmt=conn.createStatement();
			String sql = "select min(CFGTime) from apkinfo";
			rst=stmt.executeQuery(sql);
			if (rst.next()) 
		      {
				CFGTime = rst.getFloat(1);
		       }
			stmt.close();
			rst.close();
			conn.close();
			return CFGTime;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("读取CFGTime min失败");
				return -1;
			}
		}

		public Object get_FastTime_max() {
			Connection conn=null;
			Statement stmt = null;
			ResultSet rst = null;
			float FastTime = 0;
			try {		
			conn=DBUtil.getConncetion();	
			stmt=conn.createStatement();
			String sql = "select max(FastDroidTime) from apkinfo";
			rst=stmt.executeQuery(sql);
			if (rst.next()) 
		      {
				FastTime = rst.getFloat(1);
		       }
			stmt.close();
			rst.close();
			conn.close();
			return FastTime;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("读取FastDroidTime max失败");
				return -1;
			}
		}

		public Object get_FastTime_min() {
			Connection conn=null;
			Statement stmt = null;
			ResultSet rst = null;
			float FastTime = 0;
			try {		
			conn=DBUtil.getConncetion();	
			stmt=conn.createStatement();
			String sql = "select min(FastDroidTime) from apkinfo";
			rst=stmt.executeQuery(sql);
			if (rst.next()) 
		      {
				FastTime = rst.getFloat(1);
		       }
			stmt.close();
			rst.close();
			conn.close();
			return FastTime;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("读取FastDroidTime min失败");
				return -1;
			}
		}
	
	
}
