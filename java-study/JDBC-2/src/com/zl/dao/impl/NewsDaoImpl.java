package com.zl.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zl.dao.BaseDao;
import com.zl.dao.NewsDao;
import com.zl.pojo.News;
import com.zl.pojo.NewsCategory;

//ʹ��jdbcʵ�����ŵ���ɾ�Ĳ�
public class NewsDaoImpl extends BaseDao implements NewsDao {

	// ��ȡ����������
	public int getTotalCount() {

		int totalCount = 0;
		String sql = "SELECT count(1) FROM `news_detail`";
		Object[] params = {};
		rs = this.queryAll(sql, params);
		try {
			while(rs.next()){
				totalCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCount;
	}

	// ��ҳ��ȡ��������
	public List<News> getPageNewsList(int pageNo, int pageSize) {
		List<News> list = new ArrayList<News>();
		String sql = "SELECT `id`,`title`,`author`,`createdate` FROM `news_detail`order by createdate desc LIMIT ?,?";
		pageNo = (pageNo - 1) * pageSize;
		Object[] params = { pageNo, pageSize };
		rs = this.queryAll(sql, params);
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				Timestamp createDate = rs.getTimestamp("createdate");
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

	// ����id��ѯ�ض�������Ϣ
	public News getNewsById(int id) {
		News news = new News();
		String sql = "select title,summary,author,content,createdate,picpath from news_detail where id=?";
		Object[] params = { id };
		ResultSet rs = this.queryAll(sql, params);
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

	// ��ѯĳ�����ŷ������Ƿ�������
	public int getCountByCategory(NewsCategory newsCategory) {
		int count = 0;
		try {
			String sql = "SELECT COUNT(1) FROM news_detail WHERE categoryId=?";
			Object[] params = { newsCategory.getId() };
			rs = this.queryAll(sql, params);
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;

	}

	// ����������Ϣ
	public boolean addNews(News news) {
		boolean flag = false;
		try {
			String sql = "INSERT INTO news_detail(categoryId,title,summary,content,author,createdate,picPath)values(?,?,?,?,?,?,?)";
			Object[] params = { news.getCategoryId(), news.getTitle(),
					news.getSummary(), news.getContent(), news.getAuthor(),
					news.getCreateDate(), news.getPicPath() };
			int i = this.update(sql, params);
			if (i > 0) {
				System.out.println("�����������ݳɹ���");
				flag = true;
			}
		} finally {
			this.closeResource();
		}
		return flag;
	}

	// ɾ���ض������ŷ���������Ϊsql��������
	public void deleteNews(News news) {
		try {
			String sql = "delete from news_detail where id=?";
			Object[] params = { news.getId() };
			int i = this.update(sql, params);
			if (i > 0) {
				System.out.println("ɾ���������ݳɹ���");
			}
		} finally {
			this.closeResource();
		}
	}

	// �޸��ض������ŷ���
	public void alterNews(News news) {
		try {
			String sql = "update news_detail set title=? where id=?";
			Object[] params = { news.getTitle(), news.getId() };
			int i = this.update(sql, params);
			if (i > 0) {
				System.out.println("�޸��������ݳɹ���");
			}
		} finally {
			this.closeResource();
		}
	}

	// ��ѯȫ�����������
	public List<News> getNewsList() {
		List<News> list = new ArrayList<News>();
		try {
			String sql = "SELECT id,categoryid,title,summary,content,author,createdate FROM news_detail";
			Object[] params = {};
			rs = this.queryAll(sql, params);
			while (rs.next()) {
				int id = rs.getInt("id");
				int categoryId = rs.getInt("categoryid");
				String title = rs.getString("title");
				String summary = rs.getString("summary");
				String content = rs.getString("content");
				String author = rs.getString("author");
				Timestamp createDate = rs.getTimestamp("createdate");
				/*
				 * System.out.println(id + "\t" + categoryid + "\t" + title +
				 * "\t" + summary + "\t" + content + "\t" + author + "\t" +
				 * createDate + "\t");
				 */
				News news = new News();
				news.setId(id);
				news.setCategoryId(categoryId);
				news.setTitle(title);
				news.setSummary(summary);
				news.setContent(content);
				news.setAuthor(author);
				news.setCreateDate(createDate);
				list.add(news);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
		return list;
	}

	// ��ѯ�ض����������
	public void getNewsByTitle(News news) {
		try {
			String sql = "SELECT * FROM news_detail where title=?";
			Object[] params = { news.getTitle() };
			rs = this.queryAll(sql, params);
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

	public static void main(String[] args) {
		NewsDao nDao = new NewsDaoImpl();
		// ��������
		/*
		 * News news=new News(); news.setId(4); news.setCategory(2);
		 * news.setTitle("����"); news.setSummary("����"); news.setContent("����");
		 * news.setAuthor("admin"); news.setCreateDate(new Date());
		 * nDao.addNews(news);
		 */
		// �޸�����
		/*
		 * News news=new News(); news.setId(4); news.setTitle("����Ӿ");
		 * nDao.alterNews(news);
		 */
		// ɾ������
		/*
		 * News news=new News(); news.setId(4); nDao.deleteNews(news);
		 */
		// ��ѯȫ������

		News news = new News();
		nDao.getNewsList();

		// ��ѯ�ض�����
		/*
		 * News news = new News(); news.setTitle("̸��������");
		 * nDao.getNewsByTitle(news);
		 */

		/* ԭ���ķ�������
		 nDao.getNewsByTitle("̸��������");//��ѯȫ��
		 nDao.addNews(3, 1, "��Ӿ", "��Ӿ", "��Ӿ", "��Ӿ", new Date());//��
		 nDao.alterNews(3, "�й�");//��
		 nDao.getNewsList();//��ѯ�ض�����
		 nDao.deleteNews(3);//ɾ��
		 */
	}

}
