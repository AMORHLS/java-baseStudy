package com.zl.service;

import com.zl.pojo.NewsCategory;

/*对新闻类别进行业务逻辑的操作的service*/
public interface NewsCategoryService {
	// 删除特定新闻类别
	public void deleteNewsCategory(NewsCategory category);
}