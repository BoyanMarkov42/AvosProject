package com.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Avos_roles", schema = "AvosDB")
public class AvosRolesUtil {

	@Id
	@Column(name = "role_name")
	String roleName;

	@ManyToMany(mappedBy = "avosRoles")
	private List<AvosUsersUtil> avosUsers = new ArrayList<AvosUsersUtil>();

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
