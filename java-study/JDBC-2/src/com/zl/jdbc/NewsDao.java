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
		//��������
		Class.forName("com.mysql.jdbc.Driver");
		//��ȡ����(��������������ȡ����)
		String url = "jdbc:mysql://127.0.0.1:3306/news";
		String user ="root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, user, password);
		/*
		 * ��ѯ���е�
		 * */
		//���Statement����
		String sql= "SELECT * FROM news_category";
		Statement stmt=con.createStatement();
		//ִ��sql��䣬��ý����
		ResultSet rs=stmt.executeQuery(sql);
		//��������
		while (rs.next()) {
			int id =rs.getInt("id");
			String name = rs.getString("name");
			Timestamp time = rs.getTimestamp("createdate");
			System.out.println(id+"\t"+name+"\t"+time+"\t");
		}
		//�ر���Դ
		rs.close();
		stmt.close();
		con.close();
	}

}
