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

//ʹ��jdbcʵ�����ŵ���ɾ�Ĳ�
public interface NewsDao {
	// ����������Ϣ
	public boolean addNews(News news);

	// ɾ���ض������ŷ���������Ϊsql��������
	public void deleteNews(News news);

	// �޸��ض������ŷ���
	public void alterNews(News news);

	// ��ѯȫ�����������
	public List<News> getNewsList();

	// ��ѯ�ض����������
	public void getNewsByTitle(News news);
	
	//��ѯĳ�����ŷ������Ƿ�������
	public int getCountByCategory(NewsCategory newsCategory);

	//����id��ѯ�ض�������Ϣ
	public News getNewsById(int id);
	
	//��ȡ����������
	public int getTotalCount();
	
	//��ҳ��ȡ��������(��ǰҳ��/ҳ������)
	public List<News> getPageNewsList(int pageNo,int pageSize);
}
