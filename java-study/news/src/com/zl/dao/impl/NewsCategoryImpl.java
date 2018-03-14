package com.zl.dao.impl;

import com.zl.dao.BaseDao;
import com.zl.dao.NewsCategoryDao;
import com.zl.pojo.NewsCategory;

public class NewsCategoryImpl extends BaseDao implements NewsCategoryDao {
	//重写删除新闻分类的方法
	public void deleteCategory(NewsCategory category) {
		String sql = "delete from news_category where id = ?";
		Object[] params = {category.getId()};
		int i = this.executeUpdate(sql, params);
		if (i>0) {
			System.out.println("删除新闻类别成功！");
		}
		this.closeResource();
	} 

}
