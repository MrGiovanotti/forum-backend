package com.avalburo.test.models;

import com.avalburo.test.utils.Utils;

public class User {

    private String id;
    private String name;

    public User(String name) {
	id = Utils.generateUniqueId();
	this.name = name;
    }

    public String getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return "User [id=" + id + ", name=" + name + "]";
    }

}
