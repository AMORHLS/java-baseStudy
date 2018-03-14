package com.zl.dao.impl;

import com.zl.dao.BaseDao;
import com.zl.dao.NewsCategoryDao;
import com.zl.pojo.NewsCategory;

public class NewsCategoryDaoImpl extends BaseDao implements NewsCategoryDao {
	//重写了删除新闻类别
	public void deleteNewsCategory(NewsCategory newsCategory) {
		String sql="delete from news_category where id=?";
		Object[] params = {newsCategory.getId()};
		if (this.getConnection()) {
			int count =this.update(sql, params);
			if (count>0) {
				System.out.print("删除新闻类别成功！");
			}
			this.closeResource();
		}
	}


}
