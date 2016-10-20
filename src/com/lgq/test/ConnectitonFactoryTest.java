package com.lgq.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lgq.utils.ConnectionFactory;

public class ConnectitonFactoryTest {

	public static void main(String[] args) {
		ConnectionFactory connectionFactory = ConnectionFactory.getInstanceConnection();
		
		Connection conn = connectionFactory.getConnection();
		
		String sqlString = "select * from students";
		
		try {
			System.out.println(""+conn.getAutoCommit());
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sqlString);
			while (rs.next()) {
				System.out.println(""+rs.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
