package com.avalburo.test.services;

import com.avalburo.test.models.Comment;
import com.avalburo.test.models.Forum;

public interface ForumService {

    void addComment(Comment comment);

    Forum getForum();

}