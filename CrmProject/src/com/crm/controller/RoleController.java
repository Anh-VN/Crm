package com.crm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crm.dao.RoleDAO;
import com.crm.entity.Role;
import com.crm.util.PathConstants;
import com.crm.util.UrlConstants;

@WebServlet(name = "RoleServlet", urlPatterns = { UrlConstants.URL_ROLE_LIST, UrlConstants.URL_ROLE_ADD,
		UrlConstants.URL_ROLE_EDIT, UrlConstants.URL_ROLE_DELETE

})
public class RoleController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RoleDAO roleDao = null;

	@Override
	public void init() throws ServletException {
		roleDao = new RoleDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getServletPath();

		switch (action) {
		case UrlConstants.URL_ROLE_LIST:

			HttpSession session = req.getSession();
			String mess = (String) session.getAttribute("mess");
			req.setAttribute("notify", mess);
			session.removeAttribute("mess");

			roleListGet(req, resp);
			break;
		case UrlConstants.URL_ROLE_ADD:
			roleAddGet(req, resp);
			break;
		case UrlConstants.URL_ROLE_EDIT:
			roleEditGet(req, resp);
			break;
		case UrlConstants.URL_ROLE_DELETE:
			roleDeleteGet(req, resp);
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		String action = req.getServletPath();

		switch (action) {
		case UrlConstants.URL_ROLE_ADD:
			roleAddPost(req, resp);
			break;
		case UrlConstants.URL_ROLE_EDIT:
			roleEditPost(req, resp);
			break;
		default:
			break;
		}
	}

	private void roleListGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("roles", roleDao.findAll());
		req.getRequestDispatcher(PathConstants.PATH_ROLE_LIST).forward(req, resp);
	}

	private void roleAddGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(PathConstants.PATH_ROLE_ADD).forward(req, resp);
	}

	private void roleEditGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		Role role = roleDao.findById(id);

		req.setAttribute("role", role);
		req.getRequestDispatcher(PathConstants.PATH_ROLE_EDIT).forward(req, resp);
	}

	private void roleDeleteGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
        roleDao.deleteById(id);

		resp.sendRedirect(req.getContextPath() + UrlConstants.URL_ROLE_LIST);
	}

	private void roleAddPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		String name = req.getParameter("name");
		String description = req.getParameter("description");

		Role role = new Role(-1, name, description);

		roleDao.insert(role);

		resp.sendRedirect(req.getContextPath() + UrlConstants.URL_ROLE_LIST);
	}

	private void roleEditPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String description = req.getParameter("description");

		Role role = new Role(id, name, description);
		roleDao.update(role);

		resp.sendRedirect(req.getContextPath() + UrlConstants.URL_ROLE_LIST);
	}
	
}
