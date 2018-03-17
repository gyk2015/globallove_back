package com.mcii.service.article;

import com.mcii.entity.Article;
import com.mcii.service.BaseService;
import com.mcii.tools.PageRecord;

public interface ArticleService extends BaseService<Article>{
	//获取 栏目文章
	PageRecord getArticleList(Integer type, Integer page, Integer pageSize);
	//获取某篇文章
	Article getArticleById(Integer id);
	//获取人气文章
	PageRecord getPop(Integer page, Integer pageSize);
	//获取最新文章
	PageRecord getNewest(Integer page, Integer pageSize);
	//点赞
	void updateGood(Integer id);


}
