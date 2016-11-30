package com.billow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.billow.mapper.ArticleMapper;
import com.billow.model.Article;

@Controller
public class ArticleController {

	@Autowired
	private ArticleMapper articleMapper;

	@ResponseBody
	@RequestMapping("/findArticleById/{id}")
	public Article findArticleById(@PathVariable int id) {
		return articleMapper.findArticleById(id);
	}

}
