package com.zl.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zl.dao.BaseDao;
import com.zl.dao.NewsDao;
import com.zl.pojo.News;
import com.zl.pojo.NewsCategory;

public class NewsDaoImpl extends BaseDao implements NewsDao {
	// ����������Ϣ
	public boolean addNews(News news) {
		boolean flag = false;
		String sql = "INSERT INTO news_detail (categoryId,title,summary,content,picPath,author,createDate) "
				+ "VALUES (?,?,?,?,?,?,?)";
		// ���ռλ��
		Object[] params = { news.getCategoryId(), news.getTitle(),
				news.getSummary(), news.getContent(), news.getPicPath(),
				news.getAuthor(), news.getCreateDate() };
		// ִ��sql
		int i = this.executeUpdate(sql, params);
		if (i > 0) {
			System.out.println("�������ųɹ���");
			flag = true;
		}
		this.closeResource();
		return flag;
	}

	// ɾ�����ű������id
	public boolean deleteNews(News news) {
		boolean flag = false;
		String sql = "DELETE FROM news_detail WHERE id=?";
		// ���ռλ��
		Object[] params = { news.getId() };
		// ִ��sql
		int i = this.executeUpdate(sql, params);
		if (i > 0) {
			System.out.println("ɾ�����ųɹ���");
			flag = true;
		}
		this.closeResource();
		return flag;
	}

	// �޸����ű������id
	public void modifyNews(News news) {
		String sql = "UPDATE news_detail SET title=?  WHERE id = ?";
		// ���ռλ��
		Object[] params = { news.getTitle(), news.getId() };
		// ִ��sql
		int i = this.executeUpdate(sql, params);
		if (i > 0) {
			System.out.println("�޸����ųɹ���");
		}
		this.closeResource();
	}

	// ��ѯȫ�����������
	public List<News> queryNews() {
		List<News> list = new ArrayList<News>();// ��̬
		String sql = "SELECT id,categoryId,title,summary,content,author,createDate FROM news_detail";
		Object[] params = {};
		rs = this.executeQuery(sql, params);
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				int categoryId = rs.getInt("categoryid");
				String title = rs.getString("title");
				String summary = rs.getString("summary");
				String content = rs.getString("content");
				String author = rs.getString("author");
				Timestamp createDate = rs.getTimestamp("createdate");
				// �ó��������ŷ�װ�ɶ���
				News news = new News();
				news.setId(id);
				news.setCategoryId(categoryId);
				news.setTitle(title);
				news.setSummary(summary);
				news.setContent(content);
				news.setAuthor(author);
				news.setCreateDate(createDate);

				list.add(news);
				// ����̨���
				/*
				 * System.out.println(id + "\t" + categoryId + "\t" + title +
				 * "\t" + summary + "\t" + content + "\t" + author + "\t" +
				 * createDate + "\t");
				 */
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
		return list;
	}

	// ��ѯ�ض����Ÿ���title
	public void queryNewsByTitle(News news) {
		try {
			String sql = "SELECT * FROM news_detail where title=?";
			Object[] params = { news.getTitle() };
			rs = this.executeQuery(sql, params);
			// ��������
			while (rs.next()) {
				int id = rs.getInt("id");
				String newsTitle = rs.getString("title");
				Timestamp time = rs.getTimestamp("createdate");
				System.out.println(id + "\t" + newsTitle + "\t" + time + "\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
	}

	// ͨ������Դ��������ѯ
	public void queryNewsByDs() {
		String sql = "SELECT id,categoryId,title,summary,content,author,createDate FROM news_detail";
		Object[] params = {};
		rs = this.executeQuery(sql, params);
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				int categoryId = rs.getInt("categoryid");
				String title = rs.getString("title");
				String summary = rs.getString("summary");
				String content = rs.getString("content");
				String author = rs.getString("author");
				Timestamp createDate = rs.getTimestamp("createdate");
				System.out.println(id + "\t" + categoryId + "\t" + title + "\t"
						+ summary + "\t" + content + "\t" + author + "\t"
						+ createDate + "\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
	}

	// ����ID��ѯ�ض�������Ϣ
	public News getNewsById(int id) {
		News news = new News();
		String sql = "SELECT title,summary,content,author,createDate,picpath FROM news_detail where id=?";
		Object[] params = {id};//?Ϊʲô��дid
		rs = this.executeQuery(sql, params);
		try {
			while (rs.next()) {
				String title = rs.getString("title");
				String summary = rs.getString("summary");
				String content = rs.getString("content");
				String author = rs.getString("author");
				Timestamp createDate = rs.getTimestamp("createdate");
				String picPath = rs.getString("picpath");

				news.setTitle(title);
				news.setSummary(summary);
				news.setAuthor(author);
				news.setContent(content);
				news.setCreateDate(createDate);
				news.setPicPath(picPath);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return news;
	}

	//��ȡ����������
	public int getTotalCount(){
		int total= 0 ; //û���ʱ������������Ϊ0
		String sql = "select count(1) from news_detail";
		Object[] params = {};
		rs=this.executeQuery(sql, params);
		try {
			while (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	
	//��ҳ��ȡ��������
	public List<News> getPageNewsList(int pageNo,int pageSize){
		List<News> list = new ArrayList<News>();
		String sql = "SELECT id,title,author,createDate FROM news_detail WHERE 1=1 ORDER BY createDate DESC LIMIT ?,?";
		Object[] params = {(pageNo-1)*pageSize,pageSize};
		rs = this.executeQuery(sql, params);
		try {
			while(rs.next()){
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				Timestamp createDate = rs.getTimestamp("createDate");
				//���ó������ֶηŽ�news������
				News news = new News();
				news.setId(id);
				news.setTitle(title);
				news.setAuthor(author);
				news.setCreateDate(createDate);
				
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// ��ѯĳ�����ŷ������Ƿ�������
	public int getCountByCategory(NewsCategory newsCategory) {
		int count = 0;
		try {
			String sql = "SELECT COUNT(1) FROM news_detail WHERE categoryId=?";
			Object[] params = { newsCategory.getId() };
			rs = this.executeQuery(sql, params);
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;

	}
	
	
	// �������ϴ���
	public static void main(String[] args) {
		/*
		 * NewsDao nd = new NewsDaoImpl(); News news = new News(); //��ѯ
		 * nd.queryNews(news);
		 */
		// ����
		/*
		 * news.setTitle("��Ӿ"); news.setAuthor("AMOR");
		 * news.setContent("content"); news.setCategoryId(3);
		 * news.setSummary("summary"); news.setCreateDate(new Date());
		 * nd.addNews(news);
		 */
		// �޸�
		/*
		 * news.setId(4); news.setTitle("title"); nd.modifyNews(news);
		 */
		// ɾ��
		/*
		 * news.setId(4); nd.deleteNews(news);
		 */
		// ��ѯ�ض�����
		/*
		 * news.setTitle("Java Web������"); nd.queryNewsByTitle(news);
		 */
		// һ�β���ͨ��

	}

}
