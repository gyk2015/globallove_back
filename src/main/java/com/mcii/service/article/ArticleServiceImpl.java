package com.mcii.service.article;

import java.io.Serializable;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcii.entity.Article;
import com.mcii.repository.article.ArticleDao;
import com.mcii.tools.PageRecord;
import com.mcii.tools.Tool;
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{
	@Autowired 
	ArticleDao articleDao;
	
	@Override
	public Article get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable save(Article entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Article entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Article entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PageRecord getArticleList(Integer type, Integer page,
			Integer pageSize) {
		// TODO Auto-generated method stub
		String hql = "from Article where type=?0";
		Query<Article> query = articleDao.queryByHql(hql);
		query.setParameter(0, type);
		return Tool.pageList(page,pageSize,query);
	}

	@Override
	public Article getArticleById(Integer id) {
		// TODO Auto-generated method stub
		return articleDao.get(Article.class, id);
	}

	@Override
	public PageRecord getPop(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		String hql = "from Article order by liked DESC";
		Query<Article> query = articleDao.queryByHql(hql);
		return Tool.pageList(page,pageSize,query);
	}

	@Override
	public PageRecord getNewest(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		String hql = "from Article order by time DESC";
		Query<Article> query = articleDao.queryByHql(hql);
		return Tool.pageList(page,pageSize,query);
	}

	@Override
	public void updateGood(Integer id) {
		// TODO Auto-generated method stub
		Article article = getArticleById(id);
		int liked = article.getLiked();
		liked = liked+1;
		article.setLiked(liked);
		articleDao.save(article);
	}

}
