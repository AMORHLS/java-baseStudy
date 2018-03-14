package com.zl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import com.sun.xml.internal.bind.v2.runtime.Name;


public class NewsDao {
	public static void main(String[] args) throws Exception {
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接(由驱动管理来获取连接)
		String url = "jdbc:mysql://127.0.0.1:3306/news";
		String user ="root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, user, password);
		/*
		 * 查询所有的
		 * */
		//获得Statement对象
		String sql= "SELECT * FROM news_category";
		Statement stmt=con.createStatement();
		//执行sql语句，获得结果集
		ResultSet rs=stmt.executeQuery(sql);
		//处理结果集
		while (rs.next()) {
			int id =rs.getInt("id");
			String name = rs.getString("name");
			Timestamp time = rs.getTimestamp("createdate");
			System.out.println(id+"\t"+name+"\t"+time+"\t");
		}
		//关闭资源
		rs.close();
		stmt.close();
		con.close();
	}

}
