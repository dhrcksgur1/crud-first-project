package com.example.boardproject.service;

import com.example.boardproject.domain.Post;
import com.example.boardproject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page; //Page
import org.springframework.data.domain.PageRequest;//PageRequest
import org.springframework.data.domain.Sort;//Sort
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private PostRepository postRepository;


}

