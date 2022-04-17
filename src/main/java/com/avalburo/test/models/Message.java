package com.avalburo.test.models;

import java.util.List;

public class Message {

    int id;
    String content;
    User user;
    List<Message> responses;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
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

    public List<Message> getResponses() {
	return responses;
    }

    public void setResponses(List<Message> responses) {
	this.responses = responses;
    }

}
