package org.example.demo5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository repository;
    private final BoardRepository boardRepository;  // 새 리포지토리 추가

    @Autowired
    public ArticleService(ArticleRepository repository, BoardRepository boardRepository) {
        this.repository = repository;
        this.boardRepository = boardRepository;
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
    public List<Article> findByBoardId(String boardId) {
        return repository.findByBoardId(boardId);
    }
    public Board findBoardById(String boardId) {
        return boardRepository.findById(boardId);
    }
}
