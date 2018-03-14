package com.zl.service;

import java.util.List;

import com.zl.pojo.News;

/*��������Ϣ����ҵ���߼��Ľӿ�*/
public interface NewsService {
	// ��ѯȫ������
	public List<News> getNewsList();

	// ��������
	public boolean addNews(News news);

	// ����id��ѯ�ض�������Ϣ
	public News getNewsById(int id);

	// ��ȡ����������
	public int getTotalCount();

	// ��ҳ��ȡ��������(��ǰҳ��/ҳ������)
	public List<News> getPageNewsList(int pageNo, int pageSize);
}
