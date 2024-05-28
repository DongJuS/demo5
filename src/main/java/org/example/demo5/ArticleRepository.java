package org.example.demo5;

import java.util.List;


public interface ArticleRepository {
    List<Article> findAll();

    Article findById(String id);
    void save(Article article);
    void update(Article article);
    void deleteById(String id);
    List<Article> findByBoardId(String boardId);  // 새로운 메소드 추가

}
