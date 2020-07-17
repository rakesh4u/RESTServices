package org.rakesh.restapi.messenger.model;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {

	private long id;
	private String proflieName;
	private String fname;
	private String lastname;

	public Profile() {

	}

	public Profile(long id, String proflieName, String fname, String lastname, Date created) {
		super();
		this.id = id;
		this.proflieName = proflieName;
		this.fname = fname;
		this.lastname = lastname;
		this.created = created;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProflieName() {
		return proflieName;
	}

	public void setProflieName(String proflieName) {
		this.proflieName = proflieName;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	private Date created;

}
