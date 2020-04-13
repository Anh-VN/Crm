package com.crm.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.dao.GeneralTaskDAO;
import com.crm.dao.TaskDAO;
import com.crm.dao.UserDAO;
import com.crm.entity.Task;
import com.crm.util.PathConstants;
import com.crm.util.UrlConstants;

@WebServlet(name = "TaskServlet", urlPatterns = { UrlConstants.URL_TASK_ADD, UrlConstants.URL_TASK_DELETE,
		UrlConstants.URL_TASK_EDIT, UrlConstants.URL_TASK_STATUS })

public class TaskController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	TaskDAO taskDao;
	UserDAO userDao;
	GeneralTaskDAO generalTaskDao;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		taskDao = new TaskDAO();		
		userDao = new UserDAO();
		generalTaskDao = new GeneralTaskDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getServletPath();

		switch (action) {
		case UrlConstants.URL_TASK_ADD:
			taskAddGet(req, resp);
			break;
		case UrlConstants.URL_TASK_EDIT:
			taskEditGet(req, resp);
			break;
		case UrlConstants.URL_TASK_DELETE:
			taskDelete(req, resp);
			break;
		case UrlConstants.URL_TASK_STATUS:
			taskStatusGet(req, resp);
			break;
		default:
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getServletPath();

		switch (action) {
		case UrlConstants.URL_TASK_ADD:
			taskAddPost(req, resp);
			break;
		case UrlConstants.URL_TASK_EDIT:
			taskEditPost(req, resp);
			break;
		case UrlConstants.URL_TASK_STATUS:
			taskStatusPost(req, resp);
			break;
		default:
			break;
		}

	}

	private void taskDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		int generalTaskId = Integer.parseInt(req.getParameter("generalTaskId"));
		
		taskDao.deleteById(id);

		resp.sendRedirect(req.getContextPath() + UrlConstants.URL_GENERALTASK_DETAILS + "?id=" + String.valueOf(generalTaskId));
	}

	private void taskAddGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int generalTaskId = Integer.parseInt(req.getParameter("id"));
		
		req.setAttribute("generalTaskId", generalTaskId);
		req.setAttribute("generalTasks", generalTaskDao.findAll());
		req.setAttribute("users", userDao.findAll());
		req.setAttribute("status", taskDao.findAllStatus());
		
		req.getRequestDispatcher(PathConstants.PATH_TASK_ADD).forward(req, resp);
	}

	private void taskAddPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		int userId = Integer.parseInt(req.getParameter("userId"));
		int generalTaskId = Integer.parseInt(req.getParameter("generalTaskId"));
		int statusId = Integer.parseInt(req.getParameter("statusId"));

		Task task = new Task(-1, name, startDate, endDate, userId, generalTaskId, statusId);

		taskDao.insert(task);

		resp.sendRedirect(req.getContextPath() + UrlConstants.URL_GENERALTASK_DETAILS + "?id=" + String.valueOf(generalTaskId));
	}

	private void taskEditGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		req.setAttribute("task", taskDao.findById(id));
		req.setAttribute("generalTasks", generalTaskDao.findAll());
		req.setAttribute("users", userDao.findAll());
		req.setAttribute("status", taskDao.findAllStatus());
		
		req.getRequestDispatcher(PathConstants.PATH_TASK_EDIT).forward(req, resp);
	}

	private void taskStatusGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		req.setAttribute("task", taskDao.findById(id));

		req.setAttribute("status", taskDao.findAllStatus());
		
		req.getRequestDispatcher(PathConstants.PATH_TASK_STATUS).forward(req, resp);
	}
	
	private void taskEditPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
	
		
		String name = req.getParameter("name");
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		int userId = Integer.parseInt(req.getParameter("userId"));
		int generalTaskId = Integer.parseInt(req.getParameter("generalTaskId"));
		int statusId = Integer.parseInt(req.getParameter("statusId"));

		Task task = new Task(id, name, startDate, endDate, userId, generalTaskId, statusId);

		taskDao.update(task);

		resp.sendRedirect(req.getContextPath() + UrlConstants.URL_GENERALTASK_DETAILS + "?id=" + String.valueOf(generalTaskId));
	}
	
	private void taskStatusPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		
		int statusId = Integer.parseInt(req.getParameter("statusId"));
		int userId = Integer.parseInt(req.getParameter("userId"));
		
		Task task = new Task(id, "", "", "", -1, -1, statusId);

		taskDao.updateStatus(task);

		resp.sendRedirect(req.getContextPath() + UrlConstants.URL_USER_DETAILS + "?id=" + String.valueOf(userId));
	}
}
