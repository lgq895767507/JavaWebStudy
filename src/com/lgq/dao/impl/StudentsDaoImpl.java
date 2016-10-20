package com.lgq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lgq.dao.StudentsDao;
import com.lgq.entity.Students;

public class StudentsDaoImpl implements StudentsDao{

	/**
	 * ������Ϣ
	 */
	@Override
	public void insert(Connection conn, Students stu) throws SQLException {
		PreparedStatement ps = conn.prepareCall("insert into students(name,age,banji) values (?,?,?)");
		//������1��ʼ
		ps.setString(1, stu.getName());
		ps.setInt(2, stu.getAge());
		ps.setInt(3, stu.getBanji());
		ps.execute();
		
	}
	
	/**
	 * ����id�޸���Ϣ
	 */
	@Override
	public void update(Connection conn, long id, Students stu) throws SQLException {
		String sql = "update students set name = ?,age = ?,banji = ? where id = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, stu.getName());
		ps.setInt(2, stu.getAge());
		ps.setInt(3, stu.getBanji());
		ps.setLong(4, stu.getId());
		ps.execute();
		
	}

	/**
	 * ����idɾ����Ϣ
	 */
	@Override
	public void delete(Connection conn, Students stu) throws SQLException {
		String sql = "delete from students where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setLong(1, stu.getId());
		ps.execute();
		
	}

}
