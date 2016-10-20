package com.lgq.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.lgq.entity.Students;

public interface StudentsDao {

	public void insert(Connection conn, Students stu) throws SQLException;

	public void update(Connection conn, long id, Students stu) throws SQLException;

	public void delete(Connection conn, Students stu) throws SQLException;

}
