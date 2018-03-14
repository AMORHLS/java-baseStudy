package com.zl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.Name;
import com.zl.pojo.News;
import com.zl.pojo.NewsCategory;

//使用jdbc实现新闻的增删改查
public interface NewsDao {
	// 增加新闻信息
	public boolean addNews(News news);

	// 删除特定的新闻方法（参数为sql的条件）
	public void deleteNews(News news);

	// 修改特定的新闻方法
	public void alterNews(News news);

	// 查询全部标题的新闻
	public List<News> getNewsList();

	// 查询特定标题的新闻
	public void getNewsByTitle(News news);
	
	//查询某个新闻分类下是否有新闻
	public int getCountByCategory(NewsCategory newsCategory);

	//根据id查询特定新闻信息
	public News getNewsById(int id);
	
	//获取新闻总数据
	public int getTotalCount();
	
	//分页获取新闻数据(当前页码/页面容量)
	public List<News> getPageNewsList(int pageNo,int pageSize);
}
