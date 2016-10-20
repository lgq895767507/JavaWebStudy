package com.lgq.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * �����Ŀ�����Ż��������ݿ�
 * ��̬������ȡ������Ϣ����
 * ���������ݿ�����Բ����ŵ������ļ���
 * ����ʹ�����ӹ�����
 */
public class ConnectionFactory {
	
	private static String driver = null;
	private static String dburl = null;
	private static String user = null;
	private static String password = null;
	
	private Connection conn;
	
	static{
		Properties properties = new Properties();
		
		try {
			InputStream is = ConnectionFactory.class.getClassLoader()
					.getResourceAsStream("dbconfig.properties");
			properties.load(is);
		} catch (Exception e) {
			System.out.println("��ȡ������Ϣ����");
			e.printStackTrace();
		}
		//����������Ϣ
		driver = properties.getProperty("driver");
		dburl = properties.getProperty("dburl");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
	}
	
	//����ģʽ
	private ConnectionFactory() {		
	}
	
	public static ConnectionFactory getInstanceConnection(){
		return SingleHolder.connectionFactory;
	}
	private static class SingleHolder{
		static final ConnectionFactory connectionFactory = new ConnectionFactory();
	}
	
	public  Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
