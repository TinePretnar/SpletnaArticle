package com.example.SpletnaArticle;
import com.example.SpletnaArticle.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.SpletnaArticle.service.ArticleService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ArticleController {

    @Autowired
    private  ArticleService articleService;
    @GetMapping("/articles")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable int id) {
        Article article = articleService.getArticleById(id);
        if (article != null) {
            return ResponseEntity.ok(article);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public String createArticle(@RequestBody Article article) {
        return "Article created: " + article.getTitle();
    }

    @PutMapping("/{id}")
    public String updateArticle(@PathVariable int id, @RequestBody Article article) {
        return "Article with ID " + id + " updated: " + article.getTitle();
    }

    @DeleteMapping("/{id}")
    public String deleteArticle(@PathVariable int id) {
        return "Article with ID " + id + " deleted";
    }

}
