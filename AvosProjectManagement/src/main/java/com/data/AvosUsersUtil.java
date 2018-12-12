package com.data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Avos_users", schema = "AvosDB")
public class AvosUsersUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8858497754451664235L;

	@Id
	@Column(name = "db_email")
	private String email;

	@Basic
	@Column(name = "db_fName")
	private String fName;

	@Basic
	@Column(name = "db_lName")
	private String lName;

	@Basic
	@Column(name = "db_password")
	private String password;

	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(name = "AvosUsersUtil_AvosRolesUtil", joinColumns = @JoinColumn(name = "db_email"), 
	inverseJoinColumns = @JoinColumn(name = "role_name"))
	private List<AvosRolesUtil> avosRoles;

	public List<AvosRolesUtil> getAvosRoles() {
		return avosRoles;
	}

	public void setAvosRoles(List<AvosRolesUtil> avosRoles) {
		this.avosRoles = avosRoles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fName;
	}

	public void setFname(String fName) {
		this.fName = fName;
	}

	public String getLname() {
		return lName;
	}

	public void setLname(String lName) {
		this.lName = lName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
