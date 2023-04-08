package com.example.SpletnaArticle.service;

import com.example.SpletnaArticle.model.Article;
import java.util.List;

public interface ArticleService {
    List<Article> getAllArticles();
    Article getArticleById(int id);
    void saveOrUpdate(Article article);
    void deleteArticle(int id);
}
