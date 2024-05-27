package org.example.demo5;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository repository;

    @Autowired
    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }
    @PostConstruct
    public void initData() {
        Article article1 = new Article();
        article1.setId("1");
        article1.setWriterId("1");
        article1.setBoardId("1");
        article1.setTitle("제목1");
        article1.setSubject("내용1");
        article1.setDate("2024-05-14");

        Article article2 = new Article();
        article2.setId("2");
        article1.setWriterId("2");
        article2.setBoardId("1");
        article2.setTitle("제목2");
        article2.setSubject("내용2");
        article2.setDate("2024-05-15");

        repository.save(article1);
        repository.save(article2);
    }

    public List<Article> findAll() {
        return repository.findAll();
    }

    public Article findById(String id) {
        return repository.findById(id);
    }

    public void save(Article article) {
        repository.save(article);
    }

    public void update(Article article) {
        repository.update(article);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
