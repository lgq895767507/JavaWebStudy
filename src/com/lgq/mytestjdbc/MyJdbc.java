package com.lgq.mytestjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyJdbc {
	
	public static Connection getConnect() {
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/webtest","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	//����
	public static void insert() {
		
		Connection conn = getConnect();
		
		try {
			String insertSql = "insert into students(name,age,class)"+
					"values('С��','18','1')";
			Statement st = conn.createStatement();
			int count = st.executeUpdate(insertSql);
			System.out.println("������"+count+"�����ݡ�");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	public static void main(String[] args) {
	
		insert();
	}

}
