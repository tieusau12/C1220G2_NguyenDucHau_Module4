package com.codegym.ajax.controller;

import com.codegym.ajax.model.Blog;
import com.codegym.ajax.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/listBlog/")
    public ResponseEntity<Page<Blog>> showHome(@PageableDefault(size = 5) Pageable pageable) {
        return new ResponseEntity<>(blogService.findAllBlog(pageable), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> search(@RequestParam String name) {
        return new ResponseEntity<>(blogService.findAllByName(name), HttpStatus.OK);
    }
}
