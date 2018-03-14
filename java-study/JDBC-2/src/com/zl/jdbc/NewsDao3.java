package com.zl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.sun.xml.internal.bind.v2.runtime.Name;

public class NewsDao3 {
	// ��ѯ�ض���������� preparedstatement
	public void getNewsByTitle(String title) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// ��������
			Class.forName("com.mysql.jdbc.Driver");
			// ��ȡ����(��������������ȡ����)
			String url = "jdbc:mysql://127.0.0.1:3306/news";
			String user = "root";
			String password = "root";
			con = DriverManager.getConnection(url, user, password);
			// ��ּ��sql�������ռλ��
			String sql = "SELECT id,title FROM news_detail where title=?";
			//String sql = "SELECT id,title FROM news_detail where title='"+title+"'";
			/*
			 * �ַ�����ƴ��--����sql©��:ͨ��ƴ���ַ��������׳����ݱ����������
			 * */
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,title);//��һ������������λ��   ����2������ֵ
			// ִ��sql��䣬��ý����
			rs = pstmt.executeQuery();
			// ��������
			while (rs.next()) {
				int id = rs.getInt("id");
				String newsTitle = rs.getString("title");
				System.out.println(id+"\t"+newsTitle);
			}
			// �ر���Դ
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		NewsDao3 nDao2 = new NewsDao3();
		nDao2.getNewsByTitle("̸��������");
		
	}

}
