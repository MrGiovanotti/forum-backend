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
	forumStorage.save();
    }

    @Override
    public Forum getForum() {
	ForumStorage forumStorage = ForumStorage.getInstance(properties.getStorageFilePath());
	return forumStorage.getForum();
    }

}
