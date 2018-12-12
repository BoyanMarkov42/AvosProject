package com.info;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServlet;

import com.data.AvosUsersUtil;
import com.entity.EntityManagerUtil;

/**
 * Servlet implementation class TableServlet
 */
public class AllUsersTableInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AvosUsersUtil dbAvosusers = null;

	private EntityManager entityManager;

	public AllUsersTableInfo() {
		entityManager = EntityManagerUtil.getEntityManager();
	}

	public List<AvosUsersUtil> findUsers() {
		TypedQuery<AvosUsersUtil> query = entityManager.createQuery("SELECT au from AvosUsersUtil au", AvosUsersUtil.class);
		return query.getResultList();
	}

}
