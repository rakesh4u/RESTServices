package org.rakesh.restapi.xclient;


import java.util.Date;

import org.rakesh.restapi.messenger.model.Message;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class RestClient {

	public static void main(String[] args) {
		
		Client client=ClientBuilder.newClient();
		 
		//Calling GET Method
		WebTarget basetarget=client.target("http://localhost:8080/messenger/webapi/messages/1");
		WebTarget messagetarget=basetarget.path("message");
		WebTarget singleMessageTarget=messagetarget.path("{messageId}");
		
		Message message2=singleMessageTarget.resolveTemplate("messageId", "2").
				request(MediaType.APPLICATION_JSON).
				get(Message.class);
		Message message1=singleMessageTarget.resolveTemplate("messageId", "1").
				request(MediaType.APPLICATION_JSON).
				get(Message.class);
		System.out.println(message1.getMessage());
		System.out.println(message2.getMessage());


		//Calling POST Method
		Message newMessage=new Message(5, "My new message form JAX RS client", new Date(), "Raki123");
		Response postresponse=messagetarget.request().post(Entity.json(newMessage));
		if(postresponse.getStatus()!=201){
			System.out.println("Error!!");
		}
		Message createdMessage=postresponse.readEntity(Message.class);
		System.out.println(createdMessage.getMessage());
		
	}
}
