package net.emcheris.spboot.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="VHHUSER")
public class User {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotBlank
	@Size(max=32)
	@Column(name="LOGIN", length=32, nullable=false)
	private String login;
	
	@NotBlank
	@Size(max=32)
	@Column(name="FIRSTNAME", length=32)
	private String firstname;
	
	@NotBlank
	@Size(max=32)
	@Column(name="LASTNAME", length=32)
	private String lastname;
	
	@Size(max=50)
	@Column(name="EMAIL", length=50)
	private String email;
	
	@NotBlank
	@Size(max=5)
	@Column(name="ENTITYCODE", length=5)
	private String entityCode;
	
	@NotBlank
	@Column(name="PROFILE", length=3)
	private String profile;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEntityCode() {
		return entityCode;
	}

	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

}
