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

//使用jdbc实现新闻的增删改查
public class NewsDaoImpl extends BaseDao implements NewsDao {

	// 获取新闻总数据
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

	// 分页获取新闻数据
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

	// 根据id查询特定新闻信息
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

	// 查询某个新闻分类下是否有新闻
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

	// 增加新闻信息
	public boolean addNews(News news) {
		boolean flag = false;
		try {
			String sql = "INSERT INTO news_detail(categoryId,title,summary,content,author,createdate,picPath)values(?,?,?,?,?,?,?)";
			Object[] params = { news.getCategoryId(), news.getTitle(),
					news.getSummary(), news.getContent(), news.getAuthor(),
					news.getCreateDate(), news.getPicPath() };
			int i = this.update(sql, params);
			if (i > 0) {
				System.out.println("插入新闻数据成功！");
				flag = true;
			}
		} finally {
			this.closeResource();
		}
		return flag;
	}

	// 删除特定的新闻方法（参数为sql的条件）
	public void deleteNews(News news) {
		try {
			String sql = "delete from news_detail where id=?";
			Object[] params = { news.getId() };
			int i = this.update(sql, params);
			if (i > 0) {
				System.out.println("删除新闻数据成功！");
			}
		} finally {
			this.closeResource();
		}
	}

	// 修改特定的新闻方法
	public void alterNews(News news) {
		try {
			String sql = "update news_detail set title=? where id=?";
			Object[] params = { news.getTitle(), news.getId() };
			int i = this.update(sql, params);
			if (i > 0) {
				System.out.println("修改新闻数据成功！");
			}
		} finally {
			this.closeResource();
		}
	}

	// 查询全部标题的新闻
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

	// 查询特定标题的新闻
	public void getNewsByTitle(News news) {
		try {
			String sql = "SELECT * FROM news_detail where title=?";
			Object[] params = { news.getTitle() };
			rs = this.queryAll(sql, params);
			// 处理结果集
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
		// 增加新闻
		/*
		 * News news=new News(); news.setId(4); news.setCategory(2);
		 * news.setTitle("唱歌"); news.setSummary("唱歌"); news.setContent("唱歌");
		 * news.setAuthor("admin"); news.setCreateDate(new Date());
		 * nDao.addNews(news);
		 */
		// 修改新闻
		/*
		 * News news=new News(); news.setId(4); news.setTitle("新游泳");
		 * nDao.alterNews(news);
		 */
		// 删除新闻
		/*
		 * News news=new News(); news.setId(4); nDao.deleteNews(news);
		 */
		// 查询全部新闻

		News news = new News();
		nDao.getNewsList();

		// 查询特定新闻
		/*
		 * News news = new News(); news.setTitle("谈北京精神");
		 * nDao.getNewsByTitle(news);
		 */

		/* 原来的方法调用
		 nDao.getNewsByTitle("谈北京精神");//查询全部
		 nDao.addNews(3, 1, "游泳", "游泳", "游泳", "游泳", new Date());//增
		 nDao.alterNews(3, "中国");//改
		 nDao.getNewsList();//查询特定新闻
		 nDao.deleteNews(3);//删除
		 */
	}

}
