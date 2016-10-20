package com.lgq.mytestjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionTest {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/webtest", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void insertData(Connection conn) throws SQLException {

		String insertSql = "insert into students(name,age,class)" + "values('小刘','18','1')";
		Statement st = conn.createStatement();
		int count = st.executeUpdate(insertSql);
		System.out.println("插入了" + count + "条数据。");

	}

	public static void updateGrade(Connection conn) throws SQLException {

		String insertSql = "insert into grade(id,class,size)" + "values('2','2','22')";
		Statement st = conn.createStatement();
		int count = st.executeUpdate(insertSql);
		System.out.println("插入了" + count + "条数据。");

	}

	public static void main(String[] args) {
		
		Connection conn = null;
		
		try {
			conn= getConnection();
			conn.setAutoCommit(false);//设置不自动提交事务
			
			
			insertData(conn);
			updateGrade(conn);
			
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				System.out.println(" 事务回滚成功 ！");
				conn.rollback(); //异常，事务回滚，事务的一致性
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		
	}

}
