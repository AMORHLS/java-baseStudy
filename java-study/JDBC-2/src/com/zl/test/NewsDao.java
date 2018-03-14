package com.zl.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.sun.xml.internal.bind.v2.runtime.Name;

//ʹ��jdbcʵ�����ŵ���ɾ�Ĳ�
public class NewsDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	// ��ȡ���ݿ������
	public void getConnection() {
		// ��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// ��ȡ����(��������������ȡ����)
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
	// ����������Ϣ
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
				System.out.println("�����������ݳɹ���");
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// ɾ���ض������ŷ���������Ϊsql��������
	public void deleteNews(int id){
		try{
			this.getConnection();
			String sql ="DELETE FROM news_detail WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			int i=pstmt.executeUpdate();
			if(i>0){
				System.out.println("ɾ���������ݳɹ���");
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// �޸��ض������ŷ���
	public void alterNews(int id,String title){
		try{
			this.getConnection();
			String sql ="UPDATE news_detail SET title =?WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,title);
			pstmt.setInt(2,id);
			
			int i=pstmt.executeUpdate();
			if(i>0){ //iΪ����
				System.out.println("�޸��������ݳɹ���");
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// ��ѯȫ�����������
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
	// ��ѯ�ض���������� 
	public void getNewsByTitle(String title) {
		try{
			this.getConnection();
			// ���Statement����
			String sql = "SELECT * FROM news_detail where title='" + title+ "'";
			/*
			 * �ַ�����ƴ��--����sql©��
			 */
			pstmt = con.prepareStatement(sql);
			// ִ��sql��䣬��ý����
			rs = pstmt.executeQuery();
			// ��������
			while (rs.next()) {
				int id = rs.getInt("id");
				String newsTitle = rs.getString("title");
				Timestamp time = rs.getTimestamp("createdate");
				System.out.println(id + "\t" + title + "\t" + time + "\t");
			}
			// �ر���Դ
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		NewsDao nDao = new NewsDao();
		//nDao.getNewsByTitle("̸��������");//��ѯȫ��
		//nDao.addNews(3, 1, "��Ӿ", "��Ӿ", "��Ӿ", "��Ӿ", new Date());//��
		//nDao.alterNews(3, "�й�");//��
		//nDao.getNewsList();//��ѯ�ض�����
		nDao.deleteNews(3);//ɾ��
		
		
		
	}

}
