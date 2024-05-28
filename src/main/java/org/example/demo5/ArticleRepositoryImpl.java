package org.example.demo5;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {
    private final Map<String, Article> articles = new HashMap<>();

    @Override
    public List<Article> findAll() {
        return new ArrayList<>(articles.values());
    }

    @Override
    public Article findById(String id) {
        return articles.get(id);
    }

    @Override
    public void save(Article article) {
        articles.put(article.getId(), article);
    }

    @Override
    public void update(Article article) {
        articles.put(article.getId(), article);
    }

    @Override
    public void deleteById(String id) {
        articles.remove(id);
    }

    @Override
    public List<Article> findByBoardId(String boardId) {
        return articles.values().stream()
                .filter(article -> boardId.equals(article.getBoardId()))
                .collect(Collectors.toList());
    }
}
