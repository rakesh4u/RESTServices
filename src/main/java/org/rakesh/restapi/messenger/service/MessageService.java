package org.rakesh.restapi.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.rakesh.restapi.messenger.database.DataBaseClass;
import org.rakesh.restapi.messenger.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DataBaseClass.getMessage();

	public MessageService(){
		messages.put(1L, new Message(1, "Raki", new Date(),"Hey there"));
		messages.put(2L, new Message(2, "Ron", new Date(),"Hey Ron here"));

	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messageForYear=new ArrayList<>();
		Calendar cal= Calendar.getInstance();
		for(Message message: messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year){
				messageForYear.add(message);
			}
		}
		return messageForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start,int size){
		ArrayList<Message> list=new ArrayList<Message>(messages.values());
		return list.subList(start, start+size);
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}
		
	
	
}
