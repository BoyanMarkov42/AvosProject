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

import org.apache.commons.codec.digest.DigestUtils;

import com.data.AvosUsersUtil;
import com.entity.EntityManagerUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginBean")
public class LoginBean extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get request parameters for userID and password
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String sha256hex = DigestUtils.sha256Hex(pwd);

		// pwd

		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		String query = ("SELECT au from AvosUsersUtil au WHERE au.email = :email");
		Query queryObj = entityManager.createQuery(query);
		queryObj.setParameter("email", email);
		List<AvosUsersUtil> result = queryObj.getResultList();
		AvosUsersUtil myUser = result.get(0);

		if (result != null && !result.isEmpty() && myUser.getPassword().equals(sha256hex)) {

			HttpSession session = request.getSession();
			session.setAttribute("email", "Boyan");
			// setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30 * 60);
			Cookie userName = new Cookie("email", email);
			userName.setMaxAge(30 * 60);
			response.addCookie(userName);
			response.sendRedirect("LoginSuccess.xhtml");
		} else {
			RequestDispatcher reqDispatcher = getServletContext().getRequestDispatcher("/Login.xhtml");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Either email or password is wrong.</font>");
			reqDispatcher.include(request, response);
		}

	}

}
