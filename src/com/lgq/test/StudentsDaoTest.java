package com.lgq.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.lgq.dao.StudentsDao;
import com.lgq.dao.impl.StudentsDaoImpl;
import com.lgq.entity.Students;
import com.lgq.utils.ConnectionFactory;

public class StudentsDaoTest {

	public static void main(String[] args) {
		Connection conn = null;	
		try {
			ConnectionFactory cf = ConnectionFactory.getInstanceConnection();
			conn = cf.getConnection();
			conn.setAutoCommit(false);
			
			StudentsDao studentsDao = new StudentsDaoImpl();
			Students stu = new Students();
			stu.setName("王小二");
			stu.setAge(22);
			stu.setBanji(3);
			
			studentsDao.insert(conn, stu);
			
			conn.commit();//提交事务
			
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		

	}

}
