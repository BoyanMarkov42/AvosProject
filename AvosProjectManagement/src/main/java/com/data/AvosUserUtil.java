package com.data;

public class AvosUserUtil {
	private static final long serialVersionUID = 1L;

	private String email;

	private String fName;

	private String lName;

	private String role;

	public AvosUserUtil(AvosUsersUtil dbUserData) {
		email = dbUserData.getEmail();
		fName = dbUserData.getFname();
		lName = dbUserData.getLname();

			//check if its null or empty
		if (role != null && !role.isEmpty()) {
		role =  dbUserData.getAvosRoles().get(0).getRoleName();
		}
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
