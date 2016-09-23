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
	//����ģʽ
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
			System.out.println("���ݿ����ӳɹ�");
		Statement sm=conn.createStatement();
		ResultSet rs= sm.executeQuery("select * from items");
		while(rs.next()) {
			System.out.println(rs.getString("name"));
		}
		}else{
			System.out.println("����ʧ��");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
