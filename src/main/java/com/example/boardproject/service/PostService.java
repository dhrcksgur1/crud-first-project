package com.example.boardproject.service;

import com.example.boardproject.domain.Board;
import com.example.boardproject.domain.Post;
import com.example.boardproject.global.exception.ExceptionCode;
import com.example.boardproject.global.exception.ServiceLogicException;
import com.example.boardproject.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page; //Page
import org.springframework.data.domain.PageRequest;//PageRequest
import org.springframework.data.domain.Sort;//Sort
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostService {


}

