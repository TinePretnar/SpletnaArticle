package com.example.SpletnaArticle.service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.example.SpletnaArticle.model.Article;

@Service
public class ArticleServiceImpl implements ArticleService {
    private static Map<Integer, Article> articleMap = new HashMap<>();
    private static int nextId = 1;

    static {
        Article article1 = new Article(nextId++, "", "", "", LocalDate.now(),"");
        article1.setTitle("First Article");
        article1.setSubtitle("First subtitle");
        article1.setContent("This is the content of the first article.");
        article1.setDate(LocalDate.of(2017, 10, 8));
        article1.setAuthor("Tone Cvetek");
        articleMap.put(article1.getId(), article1);

        Article article2 = new Article(nextId++, "", "", "", LocalDate.now(),"");
        article2.setTitle("Second Article");
        article2.setSubtitle("Second subtitle");
        article2.setContent("This is the content of the second article.");
        article2.setDate(LocalDate.of(2019, 10, 8));
        article2.setAuthor("Marija Cvetek");
        articleMap.put(article2.getId(), article2);

        Article article3 = new Article(nextId++, "", "", "", LocalDate.now(),"");
        article3.setTitle("Third Article");
        article3.setSubtitle("Third subtitle");
        article3.setContent("This is the content of the third article.");
        article3.setDate(LocalDate.of(2019, 10, 15));
        article3.setAuthor("Marija Oblak");
        articleMap.put(article3.getId(), article3);

        Article article4 = new Article(nextId++, "", "", "", LocalDate.now(),"");
        article4.setTitle("Fourth Article");
        article4.setSubtitle("Fourth subtitle");
        article4.setContent("This is the content of the Fourth article.");
        article4.setDate(LocalDate.of(2019, 7, 8));
        article4.setAuthor("Ana Guzelj");
        articleMap.put(article4.getId(), article4);
    }

    @Override
    public List<Article> getAllArticles() {
        return new ArrayList<>(articleMap.values());
    }

    @Override
    public Article getArticleById(int id) {
        return articleMap.get(id);
    }

    @Override
    public void saveOrUpdate(Article article) {
        if (article.getId() == 0) {
            article.setId(nextId++);
        }
        articleMap.put(article.getId(), article);
    }

    @Override
    public void deleteArticle(int id) {
        articleMap.remove(id);
    }
}
