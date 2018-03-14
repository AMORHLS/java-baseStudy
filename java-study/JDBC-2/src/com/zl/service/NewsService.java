package com.zl.service;

import java.util.List;

import com.zl.pojo.News;

/*对新闻信息进行业务逻辑的接口*/
public interface NewsService {
	// 查询全部新闻
	public List<News> getNewsList();

	// 增加新闻
	public boolean addNews(News news);

	// 根据id查询特定新闻信息
	public News getNewsById(int id);

	// 获取新闻总数据
	public int getTotalCount();

	// 分页获取新闻数据(当前页码/页面容量)
	public List<News> getPageNewsList(int pageNo, int pageSize);
}
