package com.zl.service;

import java.util.List;

import com.zl.pojo.News;

public interface NewsService {
	//��ѯȫ������
	public List<News> getNewsList();
	
	//��������
	public boolean addNews(News news);
	
	//����ID��ѯ�ض�������Ϣ
	public News getNewsById(int id);
	
	//��ȡ����������
	public int getTotalCount();
	
	//��ҳ��ȡ��������
	public List<News> getPageNewsList(int pageNo,int pageSize);
	
	// ɾ�����ű������id
	public boolean deleteNews(News news);

}
