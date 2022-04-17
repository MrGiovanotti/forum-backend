package com.avalburo.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avalburo.test.models.Forum;
import com.avalburo.test.services.ForumService;

@RestController
@RequestMapping("/api/v1")
public class ForumController {

    @Autowired
    ForumService forumService;

    @GetMapping("/all-comments")
    public Forum listComments() {
	return forumService.getForum();
    }

}
