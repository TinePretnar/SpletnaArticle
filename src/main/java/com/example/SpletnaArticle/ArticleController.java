package com.example.SpletnaArticle;
import org.springframework.ui.Model;
import com.example.SpletnaArticle.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.SpletnaArticle.service.ArticleService;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class ArticleController {

    @Autowired
    private  ArticleService articleService;
    @GetMapping
    public ModelAndView getAllArticles() {
        List<Article> articles = articleService.getAllArticles();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("articles", articles);
        modelAndView.setViewName("articleList");
        return modelAndView;
    }

    @GetMapping("/{id}")
    public String getArticleById(@PathVariable Long id) {
        return "Article with ID " + id;
    }

    @PostMapping
    public String createArticle(@RequestBody Article article) {
        return "Article created: " + article.getTitle();
    }

    @PutMapping("/{id}")
    public String updateArticle(@PathVariable Long id, @RequestBody Article article) {
        return "Article with ID " + id + " updated: " + article.getTitle();
    }

    @DeleteMapping("/{id}")
    public String deleteArticle(@PathVariable Long id) {
        return "Article with ID " + id + " deleted";
    }

    @GetMapping("/articles")
    public String getAllArticles(Model model) {
        List<Article> articles = articleService.getAllArticles();
        model.addAttribute("articles", articles);
        return "articles";
    }
}
