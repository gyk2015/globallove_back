package com.mcii.repository.article;

import org.springframework.stereotype.Repository;

import com.mcii.entity.Article;
import com.mcii.repository.DomainRepositoryImpl;
@Repository
public class ArticleDaoImpl extends DomainRepositoryImpl<Article> implements ArticleDao {

}
