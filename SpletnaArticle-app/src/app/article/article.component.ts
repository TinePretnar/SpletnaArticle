import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Article } from '../article';
import { ArticleService } from '../article.service';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {
  article!: Article;

  constructor(private route: ActivatedRoute, private articleService: ArticleService) { }


ngOnInit(): void {
  console.log("output")
  const id = +this.route.snapshot.paramMap.get('id')!;
  this.articleService.getArticleById(id)
    .subscribe(article => {
      this.article = article;;
    });
  }
}
