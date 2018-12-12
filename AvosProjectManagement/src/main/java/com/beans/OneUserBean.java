package com.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.data.AvosRolesUtil;
import com.data.AvosUserUtil;
import com.data.AvosUsersUtil;
import com.info.OneUserTableInfo;

/**
 * Servlet implementation class UserServlet
 */

public class OneUserBean extends HttpServlet {
	private static final long serialVersionUID = 1L;

	OneUserTableInfo oneUserTableInfo = new OneUserTableInfo();

	public AvosUserUtil getOneUser() {
		// get faces context -> get request from context -> get parameter from request
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		// get user from parameter
		String username = req.getParameter("username");
		// send the data to the view/frontend/xhtml
		List<AvosUsersUtil> user = oneUserTableInfo.getUser(username);
		AvosUsersUtil dbAvosUsers = user.get(0);

		return new AvosUserUtil(dbAvosUsers);

	}

	public List<String> getAllUserRoles() {

		List<String> result = new ArrayList<String>();
		List<AvosRolesUtil> dbAvosRoles = oneUserTableInfo.getAllUserRoles();

		for (AvosRolesUtil role : dbAvosRoles) {
			result.add(role.getRoleName());
		}

		return result;
	}

	
	
/*	button action save insert role to user roles
  */
 
	 
}
