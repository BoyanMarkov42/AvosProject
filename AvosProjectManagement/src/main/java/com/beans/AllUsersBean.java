package com.beans;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.data.AvosUsersUtil;
import com.info.AllUsersTableInfo;

/**
 * Servlet implementation class UserServlet
 */

public class AllUsersBean extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AllUsersTableInfo allUsersTableInfo = new AllUsersTableInfo();
	private AvosUsersUtil avosUsers = new AvosUsersUtil();

	private List<AvosUsersUtil> usersList = new ArrayList();

	public List<AvosUsersUtil> getUsersList() {
		usersList = allUsersTableInfo.findUsers();
		return usersList;
	}

	public String viewUser() {
		return "Inserts.xhtml";
	}
}
