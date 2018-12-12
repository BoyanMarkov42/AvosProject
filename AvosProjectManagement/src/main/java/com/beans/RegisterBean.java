package com.beans;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.commons.codec.digest.DigestUtils;

import com.data.AvosUserRolesUtil;
import com.data.AvosUsersUtil;
import com.entity.EntityManagerUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/RegisterBean")
public class RegisterBean extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Transactional
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String pwd = request.getParameter("pwd");
		String sha256hex = DigestUtils.sha256Hex(pwd);
		String roleName = "user";

		// load the user from db
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		String query = ("SELECT au FROM AvosUsersUtil au WHERE  au.email = :email");
		Query queryObj = entityManager.createQuery(query);

		queryObj.setParameter("email", email);
		List<AvosUsersUtil> list = queryObj.getResultList();

		if (list == null || list.isEmpty()) {

			AvosUsersUtil myUser = new AvosUsersUtil();
			// if myUser existst?

			// if exist
			myUser.setEmail(email);
			myUser.setFname(fName);
			myUser.setLname(lName);
			myUser.setPassword(sha256hex);

			entityManager.getTransaction().begin();
			entityManager.persist(myUser);
			entityManager.getTransaction().commit();

			HttpSession session = request.getSession();
			session.setAttribute("user", "Boyan");
			// setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30 * 60);
			Cookie userName = new Cookie("email", email);
			userName.setMaxAge(30 * 60);
			response.addCookie(userName);
			System.out.println("<font color=green>Registration complete !</font>");

		} else {
			RequestDispatcher reqDispatcher = getServletContext().getRequestDispatcher("/Login.xhtml");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Please fill all the fields or thi user already exist.</font>");
			reqDispatcher.include(request, response);

		}

		AvosUserRolesUtil myRole = new AvosUserRolesUtil();
		myRole.setEmail(email);
		myRole.setRoleName(roleName);

		entityManager.getTransaction().begin();
		entityManager.persist(myRole);
		entityManager.getTransaction().commit();
	}

}
