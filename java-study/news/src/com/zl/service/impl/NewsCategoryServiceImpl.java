package com.zl.service.impl;

import com.zl.dao.NewsCategoryDao;
import com.zl.dao.NewsDao;
import com.zl.dao.impl.NewsCategoryImpl;
import com.zl.dao.impl.NewsDaoImpl;
import com.zl.pojo.NewsCategory;
import com.zl.service.NewsCategoryService;



public class NewsCategoryServiceImpl implements NewsCategoryService {

	private NewsCategoryDao newsCategoryDao;
	private NewsDao newsDao;

	// 别人掉用service的时候才创建以上两个对象
	public NewsCategoryServiceImpl() {
		newsCategoryDao = new NewsCategoryImpl();
		newsDao = new NewsDaoImpl();
	}

	public void deleteNewsCategory(NewsCategory category) {
		// count新闻分类下的新闻个数
		int count = newsDao.getCountByCategory(category);
		if (count > 0) {
			System.out.println("该类别下还有新闻，不允许删除！");
		} else {
			newsCategoryDao.deleteCategory(category);
		}
	}
}
