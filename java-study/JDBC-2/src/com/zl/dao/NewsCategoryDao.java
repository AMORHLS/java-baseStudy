package com.zl.dao;

import com.zl.pojo.NewsCategory;

//操作新闻类别的接口
public interface NewsCategoryDao {
	//删除某个新闻类别
	public void deleteNewsCategory(NewsCategory newsCategory);
}
