package com.zl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.sun.xml.internal.bind.v2.runtime.Name;

public class NewsDao3 {
	// 查询特定标题的新闻 preparedstatement
	public void getNewsByTitle(String title) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接(由驱动管理来获取连接)
			String url = "jdbc:mysql://127.0.0.1:3306/news";
			String user = "root";
			String password = "root";
			con = DriverManager.getConnection(url, user, password);
			// 下旨（sql命令），？占位符
			String sql = "SELECT id,title FROM news_detail where title=?";
			//String sql = "SELECT id,title FROM news_detail where title='"+title+"'";
			/*
			 * 字符串的拼接--》有sql漏洞:通过拼接字符串可以套出数据表的所有数据
			 * */
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,title);//第一个参数：？的位置   参数2：填充的值
			// 执行sql语句，获得结果集
			rs = pstmt.executeQuery();
			// 处理结果集
			while (rs.next()) {
				int id = rs.getInt("id");
				String newsTitle = rs.getString("title");
				System.out.println(id+"\t"+newsTitle);
			}
			// 关闭资源
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
		nDao2.getNewsByTitle("谈北京精神");
		
	}

}
