package org.rakesh.restapi.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.rakesh.restapi.messenger.database.DataNotFoundException;
import org.rakesh.restapi.messenger.model.Message;
import org.rakesh.restapi.messenger.service.MessageService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.core.Response.Status;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)	
public class MessageResource {

	MessageService messageservice=new MessageService();
	
	
	@GET
	public List<Message> getMessages(@QueryParam("year") int year,
									 @QueryParam("start") int start,
									 @QueryParam("size") int size){
		if(year>0){
			return messageservice.getAllMessagesForYear(year);
		}
		if(start>=0 && size>=0){
			return messageservice.getAllMessagesPaginated(start, size);
		}
		return messageservice.getAllMessages() ;
	}

	/**
	 * Returns all the messages{GET method}
	 * @return
	 */
	@GET
	@Path("/{messageId}")
	public Response getMessage(@PathParam("messageId") long id){
		//return messageservice.getMessage(id);
		Message message=messageservice.getMessage(id);
		if(message==null){
			throw new DataNotFoundException("Message with id :"+id+" not found");
		}
		return Response.status(Status.CREATED).entity(message).build();

	}
	
	/**
	 * Post a message{POST method}
	 * @return
	 */
	
	@POST
	public Response addMessage(Message message,@Context UriInfo uriInfo) throws URISyntaxException{
		Message newMessage= messageservice.addMessage(message);
		String newID=String.valueOf(newMessage.getId());
		URI uri=uriInfo.getAbsolutePathBuilder().path(newID).build();
		return Response.created(uri).entity(newMessage).build();
	}
	
	/**
	 * Update a message by Id{PUT method}
	 * @return
	 */
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id,Message message){
		message.setId(id);
		return messageservice.updateMessage(message);
	}
	
	/**
	 * Delete a message by Id{DELETE method}
	 * @return
	 */
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id){
		messageservice.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getcommonresource(){
		return new CommentResource();
	}
	

}
