package org.rakesh.restapi.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.rakesh.restapi.messenger.model.Message;
import org.rakesh.restapi.messenger.model.Profile;

public class DataBaseClass {

	private static Map<Long,Message> messages=new HashMap<>();
	private static Map<String,Profile> profiles=new HashMap<>();

	public static Map<Long, Message> getMessage(){
		return messages;
	}
	
	public static Map<String, Profile> getProfile(){
		return profiles;
	}
}
