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
	String jsonFileContent = FilesUtils.readFile(storageFilePath);
	forum = gson.fromJson(jsonFileContent, Forum.class);
	if (forum == null) {
	    forum = new Forum();
	}
    }

    public static ForumStorage getInstance(String storageFilePath) {
	if (instance == null) {
	    instance = new ForumStorage(storageFilePath);
	}
	return instance;
    }

    public Forum getForum() {
	return forum;
    }

    public void addComment(Comment comment) {
	forum.getComments().add(comment);
    }

    public void save() {
	String forumAsJson = gson.toJson(forum);
	FilesUtils.writeFile(storageFilePath, forumAsJson);
    }

}
