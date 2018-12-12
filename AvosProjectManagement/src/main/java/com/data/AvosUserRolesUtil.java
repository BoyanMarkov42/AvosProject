package com.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Avos_users_roles", schema = "AvosDB")
public class AvosUserRolesUtil {

	@Id
	@Column(name = "db_email")
	private String email;

	@Column(name = "role_name")
	private String roleName;

	@ManyToOne
	@JoinColumn(name = "db_email", insertable = false, updatable = false)

	private AvosRolesUtil avosRoles;

	public AvosUserRolesUtil() {

	}

	public AvosRolesUtil getAvosRoles() {
		return avosRoles;
	}

	public void setAvosRoles(AvosRolesUtil avosRoles) {
		this.avosRoles = avosRoles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
