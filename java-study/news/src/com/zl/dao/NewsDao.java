package com.zl.dao;

import java.util.List;

import com.zl.pojo.News;
import com.zl.pojo.NewsCategory;

public interface NewsDao {
	// 增加
	public boolean addNews(News news);

	// 删除
	public boolean deleteNews(News news);

	// 修改
	public void modifyNews(News news);

	// 查询(页面显示新闻 将新闻对象放进集合list，再将集合给页面)
	public List<News> queryNews();

	// 查询特定新闻（title）
	public void queryNewsByTitle(News news);
	
	// 通过数据源连接来查询
	public void queryNewsByDs();
	
	//根据ID查询特定新闻信息
	public News getNewsById(int id);
	
	//获取新闻总数据
	public int getTotalCount();
	
	//分页获取新闻数据
	public List<News> getPageNewsList(int pageNo,int pageSize);
	
	//查询某个新闻分类下是否有新闻
	public int getCountByCategory(NewsCategory newsCategory);
}
