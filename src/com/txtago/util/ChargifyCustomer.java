package com.txtago.util;


import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@XmlRootElement(name="customer")
public class ChargifyCustomer {
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String first_name;
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	private String last_name;
	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	private String email;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String organization;
	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	private String reference;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Override
	public String toString() {
		return new StringBuffer().
				append("id"+ id).
				append("first_name"+ first_name).
				append("last_name"+ last_name).
				append("email"+ email).
				append("organization"+ organization).
				append("reference"+ reference).
				toString();
	}
}
