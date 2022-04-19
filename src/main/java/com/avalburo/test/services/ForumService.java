package com.avalburo.test.services;

import com.avalburo.test.models.Comment;
import com.avalburo.test.models.Forum;

public interface ForumService {

    void addComment(Comment comment);

    Forum getForum();

    void replayComment(String id, Comment comment);

    Comment findCommentById(String id);

    Comment findResponseByCommentAndResponseId(String commentId, String responseId);

    void replayResponse(String commentId, String responseId, Comment comment);

}
