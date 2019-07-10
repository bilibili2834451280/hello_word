package Connectpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connectionfactory {
	private  static  final  String URL="jdbc:mysql://localhost:3306/exam?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	private static  final  String USERNAME="root";
	private  static  final  String  PASSWORD="123";

	private  Connectionfactory(){}

	static{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static  Connection  getConnection()
	{
		Connection  conn=null;
		try {
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  conn;
		}

	public  static  void closeConnection(Connection conn)
	{
		try {
			if(conn!=null)
			{
			conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public  static  void  closeResultSet(ResultSet rs)
	{
		try {
			if(rs!=null)
			{
			rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	public  static  void  closeStatement(Statement  stmt)
	{
		try {
			if(stmt!=null)
			{
				stmt.close();
			}
		}
			
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
