package com.avalburo.test.storage;

import com.avalburo.test.models.Comment;
import com.avalburo.test.models.Forum;
import com.avalburo.test.utils.FilesUtils;
import com.google.gson.Gson;

public class ForumStorage {

    private static ForumStorage instance;

    Gson gson = new Gson();

    private Forum forum;
    private String storageFilePath;

    private ForumStorage(String storageFilePath) {
	this.storageFilePath = storageFilePath;
	forum = getForum();
    }

    public static ForumStorage getInstance(String storageFilePath) {
	if (instance == null) {
	    instance = new ForumStorage(storageFilePath);
	}
	return instance;
    }

    public Forum getForum() {
	String jsonFileContent = FilesUtils.readFile(storageFilePath);
	forum = gson.fromJson(jsonFileContent, Forum.class);
	if (forum == null) {
	    return new Forum();
	}
	return forum;
    }

    public void addComment(Comment comment) {
	forum = getForum();
	forum.getComments().add(comment);
	save();
    }

    public Comment findCommentById(String id) {
	for (Comment comment : forum.getComments()) {
	    if (comment.getId().equals(id)) {
		return comment;
	    }
	}
	return null;
    }

    public void replayComment(String id, Comment comment) {
	findCommentById(id).getResponses().add(comment);
	save();
    }

    public Comment findResponseByCommentAndResponseId(String commentId, String responseId) {
	for (Comment comment : findCommentById(commentId).getResponses()) {
	    if (comment.getId().equals(responseId)) {
		return comment;
	    }
	}
	return null;
    }

    public void replayResponse(String commentId, String responseId, Comment comment) {
	findResponseByCommentAndResponseId(commentId, responseId).getResponses().add(comment);
	save();
    }

    private void save() {
	String forumAsJson = gson.toJson(forum);
	FilesUtils.writeFile(storageFilePath, forumAsJson);
    }

}
