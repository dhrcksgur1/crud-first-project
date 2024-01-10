package com.example.boardproject.repository;

import com.example.boardproject.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
        //Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);//검색어가 들어간 모든 글을 띄움 = Containing!

}
