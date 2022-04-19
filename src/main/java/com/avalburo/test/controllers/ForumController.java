package com.avalburo.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avalburo.test.models.Comment;
import com.avalburo.test.models.Forum;
import com.avalburo.test.models.RequestHelper;
import com.avalburo.test.models.User;
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

    @PostMapping("/add-comment")
    public void addComment(@RequestBody RequestHelper requestHelper) {
	User user = new User(requestHelper.getName());
	Comment comment = new Comment(requestHelper.getComment());
	comment.setUser(user);
	forumService.addComment(comment);
    }

    @PutMapping("/replay-comment/{id}")
    public void replayComment(@PathVariable String id, @RequestBody RequestHelper requestHelper) {
	User user = new User(requestHelper.getName());
	Comment comment = new Comment(requestHelper.getComment());
	comment.setUser(user);
	forumService.replayComment(id, comment);
    }

    @GetMapping("/comment/{id}")
    public Comment findCommentById(@PathVariable String id) {
	return forumService.findCommentById(id);
    }

    @GetMapping("/response/{commentId}/{responseId}")
    public Comment findResponseByCommentAndResponseId(@PathVariable String commentId, @PathVariable String responseId) {
	return forumService.findResponseByCommentAndResponseId(commentId, responseId);
    }

    @PutMapping("/replay-response/{commentId}/{responseId}")
    public void replayResponse(@PathVariable String commentId, @PathVariable String responseId,
	    @RequestBody RequestHelper requestHelper) {
	User user = new User(requestHelper.getName());
	Comment comment = new Comment(requestHelper.getComment());
	comment.setUser(user);
	forumService.replayResponse(commentId, responseId, comment);
    }

}
