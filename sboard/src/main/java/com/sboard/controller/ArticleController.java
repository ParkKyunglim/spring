package com.sboard.controller;

import com.sboard.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;



    @GetMapping("/list")
    public String list() {
        return "/article/list";
    }

    @GetMapping("/write")
    public String write() {
        return "/article/write";
    }


    @GetMapping("/modify")
    public String modify() {
        return "/article/modify";
    }


    @GetMapping("/view")
    public String view() {
        return "/article/view";
    }


}