package org.rakesh.restapi.messenger.resources;

import java.util.List;

import org.rakesh.restapi.messenger.model.Profile;
import org.rakesh.restapi.messenger.service.ProfileService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/messages")
public class ProfileResource {
	
	ProfileService profileService=new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Profile> getMessages(){
		
		return profileService.getAllProfiles() ;
	}
		
	@GET
	@Path("/{profileName}")
	@Produces(MediaType.TEXT_PLAIN)
	public Profile getProfile(@PathParam("profileName") String profileName ){
		return profileService.getProfile(profileName);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)	
	@Produces(MediaType.APPLICATION_JSON)
	public Profile addMessage(Profile profile){
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile updateProfile(@PathParam("profileName") String profileName,Profile profile){
		profile.setProflieName(profileName);
		return profileService.updateMessage(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteProfile(@PathParam("profileName") String profileName){
		profileService.removeMessage(profileName);
	}


}
