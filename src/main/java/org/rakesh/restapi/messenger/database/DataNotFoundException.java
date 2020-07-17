package org.rakesh.restapi.messenger.database;

public class DataNotFoundException extends RuntimeException {

	public DataNotFoundException(String message){
		super(message);
	}
}
