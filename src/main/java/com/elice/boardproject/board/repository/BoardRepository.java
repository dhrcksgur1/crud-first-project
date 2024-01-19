package com.elice.boardproject.board.repository;

import java.util.List;
import java.util.Optional;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.elice.boardproject.board.entity.Board;

@Repository
public class BoardRepository {
    
    private final JdbcTemplate jdbcTemplate;

    public BoardRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Board> boardRowMapper() {
        return (resultSet, rowNum) -> {
            return Board.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .description(resultSet.getString("description"))
                        .createdAt(resultSet.getTimestamp("created_at").toLocalDateTime())
                        .build();
        };
    }

    public List<Board> findAll() {
        String sql = "SELECT * FROM board";
        return jdbcTemplate.query(sql, boardRowMapper());
    }

    public Optional<Board> findById(Long id) {
        try {
            String sql = "SELECT * FROM board WHERE id = ?";
            Board board = jdbcTemplate.queryForObject(sql, boardRowMapper(), id);
            
            return Optional.ofNullable(board);
        } catch(EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }

    public Board create(Board board) {
        String insertSql = "INSERT INTO board (name, description, created_at) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        LocalDateTime createdAt = LocalDateTime.now();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(insertSql, new String[]{"id"});
            ps.setString(1, board.getName());
            ps.setString(2, board.getDescription());
            ps.setTimestamp(3, Timestamp.valueOf(createdAt));
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();

        if(key == null) return board;
        return board.toBuilder()
                    .id(key.longValue())
                    .createdAt(createdAt)
                    .build();
    }
    public Board update(Board board) {
        String updateSql = "UPDATE board SET name = ?, description = ? WHERE id = ?";
        jdbcTemplate.update(updateSql, board.getName(), board.getDescription(), board.getId());

        return board;
    }

    public void delete(Board board) {
        String sql = "DELETE FROM board WHERE id = ?";
        jdbcTemplate.update(sql, board.getId());
    }
}
