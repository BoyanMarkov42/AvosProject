package com.info;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServlet;

import com.data.AvosRolesUtil;
import com.data.AvosUserRolesUtil;
import com.data.AvosUsersUtil;
import com.entity.EntityManagerUtil;

/**
 * Servlet implementation class TableServlet
 */
public class OneUserTableInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AvosUserRolesUtil dbAvosUsersRoles = null;

	private EntityManager entityManager;

	public OneUserTableInfo() {
		entityManager = EntityManagerUtil.getEntityManager();
	}

	public List<AvosUserRolesUtil> findUsers() {
		TypedQuery<AvosUserRolesUtil> query = entityManager.createQuery("SELECT ar from AvosRolesUtil ar",
				AvosUserRolesUtil.class);
		return query.getResultList();
	}

	// getuser(String userID)
	// get from join roledate and userdata

	public List<AvosUsersUtil> getUser(String email) {

		String userQuery = ("SELECT au from AvosUsersUtil au WHERE au.email = :email");
		Query queryObj = entityManager.createQuery(userQuery);
		queryObj.setParameter("email", email);

		return queryObj.getResultList();
	}

	public List<AvosRolesUtil> getAllUserRoles() {
		String userQuery = ("SELECT ar from AvosRolesUtil ar");
		Query queryObj = entityManager.createQuery(userQuery);

		return queryObj.getResultList();
	}

}
