public class barDao {
	public ArrayList<barBean> select_all(){
		Connection conn=null;
		Statement stmt = null;
		ResultSet rst = null;
		try {		
		conn=DBUtil.getConncetion();	
		stmt=conn.createStatement();
		String sql = "select * from bar";
		rst=stmt.executeQuery(sql);
		ArrayList<barBean> array = new ArrayList<barBean>();
		while(rst.next()){
			barBean bar = new barBean();
			bar.setName(rst.getString("name"));
			bar.setNum(rst.getInt("num"));
			array.add(bar);
		}
		stmt.close();
		rst.close();
		conn.close();
		return array;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("读取失败");
			return new ArrayList<barBean>();
		}
		
	}
}
