package com.fotra.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/forum")
public class ForumController {

    @GetMapping("/forum")
    public String getForum() {
        return "forum";
    }

}
