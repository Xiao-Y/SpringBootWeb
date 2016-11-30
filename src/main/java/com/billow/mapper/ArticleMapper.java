package com.billow.mapper;

import java.util.List;

import com.billow.model.Article;

public interface ArticleMapper {

	public Article findArticleById(int id);

	public List<Article> findArticleByUserid();
}
