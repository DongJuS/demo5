package org.example.demo5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ArticleController {
    private final ArticleService service;

    @Autowired
    public ArticleController(ArticleService service) {
        this.service = service;
    }

    @GetMapping("/postsv1")
    public String getPostsPage(Model model) {
        List<Article> articles = service.findAll();
        model.addAttribute("articles", articles);
        Board board = new Board();
        board.setId("1");
        board.setBoardNm("Example Board");
        model.addAttribute("board", board);
        return "posts";
    }

    @GetMapping("/posts")
    public String getPostsByBoardId(@RequestParam String boardId, Model model) {
        List<Article> articles = service.findByBoardId(boardId);
        Board board = service.findBoardById(boardId);  // 새 메소드 추가 필요
        model.addAttribute("articles", articles);
        model.addAttribute("boardName", board.getBoardNm());
        return "posts";
    }


    @GetMapping("/articles")
    @ResponseBody
    public List<Article> getAllArticles() {
        return service.findAll();
    }

    @GetMapping("/articles/{id}")
    @ResponseBody
    public Article getArticleById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping("/articles")
    @ResponseBody
    public void createArticle(@RequestBody Article article) {
        service.save(article);
    }

    @PutMapping("/articles/{id}")
    @ResponseBody
    public void updateArticle(@PathVariable String id, @RequestBody Article article) {
        article.setId(id);
        service.update(article);
    }

    @DeleteMapping("/articles/{id}")
    @ResponseBody
    public void deleteArticle(@PathVariable String id) {
        service.deleteById(id);
    }
}
