public class DBUtil {
	public static Connection getConncetion(){
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url="jdbc:sqlserver://localhost:1433;DatabaseName=test";
			String user="sa";
			String password="88888888";
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("连接失败");
			e.printStackTrace();
		}
		return conn;
	}

}
