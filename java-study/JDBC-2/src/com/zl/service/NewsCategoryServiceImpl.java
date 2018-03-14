package com.zl.service;

import com.zl.dao.NewsCategoryDao;
import com.zl.dao.NewsDao;
import com.zl.dao.impl.NewsCategoryDaoImpl;
import com.zl.dao.impl.NewsDaoImpl;
import com.zl.pojo.NewsCategory;

public class NewsCategoryServiceImpl implements NewsCategoryService {

	private NewsCategoryDao newsCategoryDao;
	private NewsDao newsDao;

	// ���˵���service��ʱ��Ŵ���������������
	public NewsCategoryServiceImpl() {
		newsCategoryDao = new NewsCategoryDaoImpl();
		newsDao = new NewsDaoImpl();
	}

	public void deleteNewsCategory(NewsCategory category) {
		// count���ŷ����µ����Ÿ���
		int count = newsDao.getCountByCategory(category);
		if (count > 0) {
			System.out.println("������»������ţ�������ɾ����");
		} else {
			newsCategoryDao.deleteNewsCategory(category);
		}
	}
}
