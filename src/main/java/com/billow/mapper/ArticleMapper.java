package com.billow.mapper;

import java.util.List;

import com.billow.model.Article;

public interface ArticleMapper {

	public Article findArticleById(int articleId);

	public List<Article> findArticleByUserId();

	public void deleteUserByArticleIds(Integer[] articleIds);

	int deleteByPrimaryKey(Integer articleId);

	int insert(Article record);

	int insertSelective(Article record);

	int updateByPrimaryKeySelective(Article record);

	int updateByPrimaryKeyWithBLOBs(Article record);

	int updateByPrimaryKey(Article record);
}
