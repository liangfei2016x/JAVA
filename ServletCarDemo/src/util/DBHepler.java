package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;





public class DBHepler {
	private static final String driver="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://127.0.0.1:3306/shopping";
	private static final String USER="root";
	private static final String PASSWORD="123456";
	
	private static Connection conn=null;
	
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//单例模式
	public static Connection getConnection() throws Exception{
		if(conn==null){
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			return conn;
		}
		return conn;		
	}
	public static void main(String[] args) {
	try {
		Connection conn=DBHepler.getConnection();
		if(conn!=null){
			System.out.println("数据库连接成功");
		Statement sm=conn.createStatement();
		ResultSet rs= sm.executeQuery("select * from items");
		while(rs.next()) {
			System.out.println(rs.getString("name"));
		}
		}else{
			System.out.println("连接失败");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
