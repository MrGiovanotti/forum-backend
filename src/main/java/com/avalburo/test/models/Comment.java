package com.avalburo.test.models;

import java.util.List;

import com.avalburo.test.utils.DateUtils;
import com.avalburo.test.utils.Utils;

public class Comment {

    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    String id;
    String content;
    String date;
    User user;
    List<Comment> responses;

    public Comment() {
	id = Utils.generateUniqueId();
	date = DateUtils.getCurrentDateAsString(DATE_PATTERN);
    }

    public Comment(String content, User user, List<Comment> responses) {
	id = Utils.generateUniqueId();
	this.content = content;
	date = DateUtils.getCurrentDateAsString(DATE_PATTERN);
	this.user = user;
	this.responses = responses;
    }

    public String getId() {
	return id;
    }

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public List<Comment> getResponses() {
	return responses;
    }

    public void setResponses(List<Comment> responses) {
	this.responses = responses;
    }

    @Override
    public String toString() {
	return "Comment [id=" + id + ", content=" + content + ", date=" + date + ", user=" + user + ", responses="
		+ responses + "]";
    }

}
