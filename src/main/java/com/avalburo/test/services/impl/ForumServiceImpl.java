package com.avalburo.test.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avalburo.test.AppProperties;
import com.avalburo.test.models.Comment;
import com.avalburo.test.models.Forum;
import com.avalburo.test.services.ForumService;
import com.avalburo.test.storage.ForumStorage;

@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    AppProperties properties;

    @Override
    public void addComment(Comment comment) {
	ForumStorage forumStorage = ForumStorage.getInstance(properties.getStorageFilePath());
	forumStorage.addComment(comment);
    }

    @Override
    public Forum getForum() {
	ForumStorage forumStorage = ForumStorage.getInstance(properties.getStorageFilePath());
	return forumStorage.getForum();
    }

    @Override
    public void replayComment(String id, Comment comment) {
	ForumStorage forumStorage = ForumStorage.getInstance(properties.getStorageFilePath());
	forumStorage.replayComment(id, comment);
    }

    @Override
    public Comment findCommentById(String id) {
	ForumStorage forumStorage = ForumStorage.getInstance(properties.getStorageFilePath());
	return forumStorage.findCommentById(id);
    }

    @Override
    public Comment findResponseByCommentAndResponseId(String commentId, String responseId) {
	ForumStorage forumStorage = ForumStorage.getInstance(properties.getStorageFilePath());
	return forumStorage.findResponseByCommentAndResponseId(commentId, responseId);
    }

    @Override
    public void replayResponse(String commentId, String responseId, Comment comment) {
	ForumStorage forumStorage = ForumStorage.getInstance(properties.getStorageFilePath());
	forumStorage.replayResponse(commentId, responseId, comment);
    }

}
