package org.rakesh.restapi.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.rakesh.restapi.messenger.database.DataBaseClass;
import org.rakesh.restapi.messenger.model.Comment;
import org.rakesh.restapi.messenger.model.Message;

public class CommentsSerive {

	private Map<Long,Message> messages=DataBaseClass.getMessage();
	
	public List<Comment> getAllComments(long messageID) {
		Map<Long,Comment> comments=messages.get(messages).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageId,long commentId){
		Map<Long,Comment> comments=messages.get(messageId).getComments();
		return comments.get(commentId);
	}
	
	public Comment addComment(long messageId,Comment comment) {
		Map<Long,Comment> comments=messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updatecomment(long messageId,Comment comment) {
		Map<Long,Comment> comments=messages.get(messageId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removecomment(long messageID,long commentid){
		Map<Long,Comment> comments=messages.get(messageID).getComments();
		return comments.remove(commentid);
	}
}
