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
	// 增加新闻信息
	public boolean addNews(News news) {
		boolean flag = false;
		String sql = "INSERT INTO news_detail (categoryId,title,summary,content,picPath,author,createDate) "
				+ "VALUES (?,?,?,?,?,?,?)";
		// 填充占位符
		Object[] params = { news.getCategoryId(), news.getTitle(),
				news.getSummary(), news.getContent(), news.getPicPath(),
				news.getAuthor(), news.getCreateDate() };
		// 执行sql
		int i = this.executeUpdate(sql, params);
		if (i > 0) {
			System.out.println("增加新闻成功！");
			flag = true;
		}
		this.closeResource();
		return flag;
	}

	// 删除新闻标题根据id
	public boolean deleteNews(News news) {
		boolean flag = false;
		String sql = "DELETE FROM news_detail WHERE id=?";
		// 填充占位符
		Object[] params = { news.getId() };
		// 执行sql
		int i = this.executeUpdate(sql, params);
		if (i > 0) {
			System.out.println("删除新闻成功！");
			flag = true;
		}
		this.closeResource();
		return flag;
	}

	// 修改新闻标题根据id
	public void modifyNews(News news) {
		String sql = "UPDATE news_detail SET title=?  WHERE id = ?";
		// 填充占位符
		Object[] params = { news.getTitle(), news.getId() };
		// 执行sql
		int i = this.executeUpdate(sql, params);
		if (i > 0) {
			System.out.println("修改新闻成功！");
		}
		this.closeResource();
	}

	// 查询全部标题的新闻
	public List<News> queryNews() {
		List<News> list = new ArrayList<News>();// 多态
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
				// 拿出来的新闻封装成对象
				News news = new News();
				news.setId(id);
				news.setCategoryId(categoryId);
				news.setTitle(title);
				news.setSummary(summary);
				news.setContent(content);
				news.setAuthor(author);
				news.setCreateDate(createDate);

				list.add(news);
				// 控制台输出
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

	// 查询特定新闻根据title
	public void queryNewsByTitle(News news) {
		try {
			String sql = "SELECT * FROM news_detail where title=?";
			Object[] params = { news.getTitle() };
			rs = this.executeQuery(sql, params);
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

	// 通过数据源连接来查询
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

	// 根据ID查询特定新闻信息
	public News getNewsById(int id) {
		News news = new News();
		String sql = "SELECT title,summary,content,author,createDate,picpath FROM news_detail where id=?";
		Object[] params = {id};//?为什么填写id
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

	//获取新闻总数据
	public int getTotalCount(){
		int total= 0 ; //没查的时候数据总数量为0
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
	
	//分页获取新闻数据
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
				//把拿出来的字段放进news对象中
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
	
	// 查询某个新闻分类下是否有新闻
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
	
	
	// 测试以上代码
	public static void main(String[] args) {
		/*
		 * NewsDao nd = new NewsDaoImpl(); News news = new News(); //查询
		 * nd.queryNews(news);
		 */
		// 增加
		/*
		 * news.setTitle("游泳"); news.setAuthor("AMOR");
		 * news.setContent("content"); news.setCategoryId(3);
		 * news.setSummary("summary"); news.setCreateDate(new Date());
		 * nd.addNews(news);
		 */
		// 修改
		/*
		 * news.setId(4); news.setTitle("title"); nd.modifyNews(news);
		 */
		// 删除
		/*
		 * news.setId(4); nd.deleteNews(news);
		 */
		// 查询特定新闻
		/*
		 * news.setTitle("Java Web开课啦"); nd.queryNewsByTitle(news);
		 */
		// 一次测试通过

	}

}
