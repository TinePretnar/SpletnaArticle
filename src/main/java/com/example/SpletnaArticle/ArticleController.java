package com.example.SpletnaArticle;
import com.example.SpletnaArticle.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.SpletnaArticle.service.ArticleService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


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
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/{id}")
    public String getArticleById(@PathVariable int id) {
        return "Article with ID " + id;
    }

    /*@GetMapping("/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = new ClassPathResource(filename);
        if (file.exists()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + file.getFilename() + "\"")
                    .contentType(MediaTypeFactory.getMediaType(file).orElse(MediaType.APPLICATION_OCTET_STREAM))
                    .body(file);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

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
