package com.zl.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.sun.xml.internal.bind.v2.runtime.Name;

//使用jdbc实现新闻的增删改查
public class NewsDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	// 获取数据库的连接
	public void getConnection() {
		// 加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接(由驱动管理来获取连接)
			String url = "jdbc:mysql://127.0.0.1:3306/news";
			String user = "root";
			String password = "root";
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// 增加新闻信息
	public void addNews(int id,int categoryid,String title,String summary,String content,String author,Date createdate){
		try{
			this.getConnection();
			String sql ="INSERT INTO news_detail(id,categoryid,title,summary,content,author,createdate)values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, categoryid);
			pstmt.setString(3, title);
			pstmt.setString(4, summary);
			pstmt.setString(5, content);
			pstmt.setString(6, author);
			pstmt.setTimestamp(7,new Timestamp(createdate.getTime()));
			int i=pstmt.executeUpdate();
			if(i>0){
				System.out.println("插入新闻数据成功！");
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 删除特定的新闻方法（参数为sql的条件）
	public void deleteNews(int id){
		try{
			this.getConnection();
			String sql ="DELETE FROM news_detail WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			int i=pstmt.executeUpdate();
			if(i>0){
				System.out.println("删除新闻数据成功！");
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 修改特定的新闻方法
	public void alterNews(int id,String title){
		try{
			this.getConnection();
			String sql ="UPDATE news_detail SET title =?WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,title);
			pstmt.setInt(2,id);
			
			int i=pstmt.executeUpdate();
			if(i>0){ //i为行数
				System.out.println("修改新闻数据成功！");
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 查询全部标题的新闻
	public void getNewsList() {
		try{
			this.getConnection();
			String sql = "SELECT id,categoryid,title,summary,content,author,createdate FROM news_detail";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int categoryid=rs.getInt("categoryid");
				String title = rs.getString("title");
				String summary = rs.getString("summary");
				String content = rs.getString("content");
				String author = rs.getString("author");
				Timestamp time = rs.getTimestamp("createdate");
				System.out.println(id + "\t" +categoryid
						+ "\t"+title + "\t" +summary+"\t"+content+"\t"+author+"\t"+ time + "\t");
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 查询特定标题的新闻 
	public void getNewsByTitle(String title) {
		try{
			this.getConnection();
			// 获得Statement对象
			String sql = "SELECT * FROM news_detail where title='" + title+ "'";
			/*
			 * 字符串的拼接--》有sql漏洞
			 */
			pstmt = con.prepareStatement(sql);
			// 执行sql语句，获得结果集
			rs = pstmt.executeQuery();
			// 处理结果集
			while (rs.next()) {
				int id = rs.getInt("id");
				String newsTitle = rs.getString("title");
				Timestamp time = rs.getTimestamp("createdate");
				System.out.println(id + "\t" + title + "\t" + time + "\t");
			}
			// 关闭资源
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		NewsDao nDao = new NewsDao();
		//nDao.getNewsByTitle("谈北京精神");//查询全部
		//nDao.addNews(3, 1, "游泳", "游泳", "游泳", "游泳", new Date());//增
		//nDao.alterNews(3, "中国");//改
		//nDao.getNewsList();//查询特定新闻
		nDao.deleteNews(3);//删除
		
		
		
	}

}
