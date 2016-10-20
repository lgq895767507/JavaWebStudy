package com.lgq.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * 该类的目的是优化连接数据库
 * 静态代码块读取配置信息内容
 * 将连接数据库的属性参数放到配置文件中
 * 单例使用连接工厂类
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
			System.out.println("读取配置信息错误！");
			e.printStackTrace();
		}
		//加载配置信息
		driver = properties.getProperty("driver");
		dburl = properties.getProperty("dburl");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
	}
	
	//单例模式
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
