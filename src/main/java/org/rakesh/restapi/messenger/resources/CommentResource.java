package org.rakesh.restapi.messenger.resources;

import java.util.List;

import org.rakesh.restapi.messenger.model.Comment;
import org.rakesh.restapi.messenger.service.CommentsSerive;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)	
public class CommentResource {

	private CommentsSerive commentservice=new CommentsSerive();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId){
		return commentservice.getAllComments(messageId);
	}
	
	
	@POST
	public Comment addMessage(@PathParam("messageId") long messageId,
			@PathParam("commentId") long id,Comment comment){
		comment.setId(id);
		return commentservice.updatecomment(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId){
		commentservice.removecomment(messageId, commentId);
	}
	
	
	@GET
	@Path("/{commentId}") 
	public String test2(@PathParam("messageID") long messageID,@PathParam("commentID") String commentID){
		return "Method to retuen comment ID:"+commentID + "for Message" +messageID ;
	}
	
}
