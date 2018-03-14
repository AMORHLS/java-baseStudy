package com.zl.service.impl;

import java.util.List;

import com.zl.dao.NewsDao;
import com.zl.dao.impl.NewsDaoImpl;
import com.zl.pojo.News;
import com.zl.service.NewsService;

public class NewsServiceImpl implements NewsService {
	private NewsDao newsDao;

	public NewsServiceImpl() {
		newsDao = new NewsDaoImpl();
	}

	public List<News> getNewsList() {
		return newsDao.getNewsList();
	}

	// ��������
	public boolean addNews(News news) {
		return newsDao.addNews(news);
	}

	// ����id��ѯ�ض�������Ϣ
	public News getNewsById(int id) {
		return newsDao.getNewsById(id);
	}

	// ��ȡ����������
	public int getTotalCount(){
		return newsDao.getTotalCount();
	}

	// ��ҳ��ȡ��������(��ǰҳ��/ҳ������)
	public List<News> getPageNewsList(int pageNo, int pageSize){
		return newsDao.getPageNewsList(pageNo, pageSize);
	}

}
