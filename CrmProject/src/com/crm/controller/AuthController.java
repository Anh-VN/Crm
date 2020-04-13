package com.crm.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.crm.dao.UserDAO;
import com.crm.dto.LoginDto;

import com.crm.util.PathConstants;
import com.crm.util.UrlConstants;

@WebServlet(name = "LoginServlet", urlPatterns = { UrlConstants.URL_LOGIN, UrlConstants.URL_LOGOUT })
public class AuthController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UserDAO userDao = null;

	@Override
	public void init() throws ServletException {

		userDao = new UserDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getServletPath();
		
		if (action.equals(UrlConstants.URL_LOGOUT)) {
			
			HttpSession session = req.getSession();
			
			if(session.getAttribute("USER_LOGIN") != null)
			{
				session.removeAttribute("USER_LOGIN");
			}	
			
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_LOGIN);
			return;
		}
		
		req.getRequestDispatcher(PathConstants.PATH_LOGIN_INDEX).forward(req, resp);
			
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");

		String password = req.getParameter("password");
		
		LoginDto userLogin = userDao.getLoginInfor(email);

		if (userLogin == null || !BCrypt.checkpw(password, userLogin.getPassword())) {
			req.setAttribute("message", "You have entered an invalid username or password!");
			req.setAttribute("email", email);
			req.setAttribute("password", password);
			req.getRequestDispatcher(PathConstants.PATH_LOGIN_INDEX).forward(req, resp);

			return;
		}

		HttpSession session = req.getSession();
		session.setAttribute("USER_LOGIN", userLogin);

		resp.sendRedirect(req.getContextPath() + UrlConstants.URL_HOME);
		
	}
}
