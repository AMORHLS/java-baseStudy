package com.zl.dao;

import java.util.List;

import com.zl.pojo.News;
import com.zl.pojo.NewsCategory;

public interface NewsDao {
	// ����
	public boolean addNews(News news);

	// ɾ��
	public boolean deleteNews(News news);

	// �޸�
	public void modifyNews(News news);

	// ��ѯ(ҳ����ʾ���� �����Ŷ���Ž�����list���ٽ����ϸ�ҳ��)
	public List<News> queryNews();

	// ��ѯ�ض����ţ�title��
	public void queryNewsByTitle(News news);
	
	// ͨ������Դ��������ѯ
	public void queryNewsByDs();
	
	//����ID��ѯ�ض�������Ϣ
	public News getNewsById(int id);
	
	//��ȡ����������
	public int getTotalCount();
	
	//��ҳ��ȡ��������
	public List<News> getPageNewsList(int pageNo,int pageSize);
	
	//��ѯĳ�����ŷ������Ƿ�������
	public int getCountByCategory(NewsCategory newsCategory);
}
