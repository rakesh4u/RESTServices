package org.rakesh.restapi.messenger.database;

import org.rakesh.restapi.messenger.model.ErrorMessage;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errorMessage=new ErrorMessage(ex.getMessage(), 404,"https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html");
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}

}
