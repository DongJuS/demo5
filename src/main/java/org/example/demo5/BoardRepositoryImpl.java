package org.example.demo5;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BoardRepositoryImpl implements BoardRepository {
    private final Map<String, Board> boards = new HashMap<>();

    public BoardRepositoryImpl() {
        Board board1 = new Board();
        board1.setId("1");
        board1.setBoardNm("Example Board");
        boards.put(board1.getId(), board1);
    }

    @Override
    public Board findById(String id) {
        return boards.get(id);
    }
}