package org.rakesh.restapi.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.rakesh.restapi.messenger.database.DataBaseClass;
import org.rakesh.restapi.messenger.model.Profile;

public class ProfileService {



	private Map<String, Profile> profiles = DataBaseClass.getProfile();

	public ProfileService(){
		profiles.put("Raki", new Profile(1L, "Raki", "R", "N", new Date()));
		profiles.put("Ron", new Profile(2L, "Ron","R", "V",new Date()));

	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProflieName(), profile);
		return profile;
	}
	
	
	public Profile updateMessage(Profile profile) {
		if (profile.getProflieName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProflieName(), profile);
		return profile;
	}
	
	public Profile removeMessage(String profileName){
		return profiles.remove(profileName);
	}
	


}
