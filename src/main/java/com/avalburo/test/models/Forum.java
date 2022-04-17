package com.avalburo.test.models;

import java.util.ArrayList;
import java.util.List;

public class Forum {

    private List<Comment> comments;

    public Forum() {
	comments = new ArrayList<>();
    }

    public List<Comment> getComments() {
	return comments;
    }

    public void setComments(List<Comment> comments) {
	this.comments = comments;
    }

    @Override
    public String toString() {
	return "Forum [comments=" + comments + "]";
    }

}
