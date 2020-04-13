package com.crm.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.crm.dao.GeneralTaskDAO;
import com.crm.dao.TaskDAO;
import com.crm.dao.UserDAO;
import com.crm.dto.StatusDto;
import com.crm.dto.TaskDto;
import com.crm.dto.UserTasksDto;
import com.crm.entity.GeneralTask;
import com.crm.entity.Status;
import com.crm.entity.Task;
import com.crm.util.PathConstants;
import com.crm.util.UrlConstants;

@WebServlet(name = "GeneralTaskServlet", urlPatterns = { UrlConstants.URL_GENERALTASK_LIST,
		UrlConstants.URL_GENERALTASK_ADD, UrlConstants.URL_GENERALTASK_DELETE, UrlConstants.URL_GENERALTASK_EDIT,
		UrlConstants.URL_GENERALTASK_DETAILS })

public class GeneralTaskController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	GeneralTaskDAO generalTaskDao;
	UserDAO userDao;
	TaskDAO taskDao;
	@Override
	public void init(ServletConfig config) throws ServletException {
		generalTaskDao = new GeneralTaskDAO();
		userDao = new UserDAO();
		taskDao = new TaskDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getServletPath();

		switch (action) {
		case UrlConstants.URL_GENERALTASK_LIST:
			generalTaskListGet(req, resp);
			break;
		case UrlConstants.URL_GENERALTASK_ADD:
			generalTaskAddGet(req, resp);
			break;
		case UrlConstants.URL_GENERALTASK_EDIT:
			generalTaskEditGet(req, resp);
			break;
		case UrlConstants.URL_GENERALTASK_DETAILS:
			generalTaskDetailsGet(req, resp);
			break;
		case UrlConstants.URL_GENERALTASK_DELETE:
			generalTaskDelete(req, resp);
			break;
		default:
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getServletPath();

		switch (action) {
		case UrlConstants.URL_GENERALTASK_ADD:
			generalTaskAddPost(req, resp);
			break;
		case UrlConstants.URL_GENERALTASK_EDIT:
			generalTaskEditPost(req, resp);
			break;
		default:
			break;
		}

	}

	private void generalTaskListGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<GeneralTask> generalTasks = generalTaskDao.findAll();
		List<UserTasksDto> listUserTasks = userDao.findAllUserTasks();
		List<Status> listStatus = taskDao.findAllStatus();
		
		req.setAttribute("generalTasks", generalTasks);
		req.setAttribute("statusDto", taskDao.listStatusDto(listUserTasks, listStatus));
		
		req.getRequestDispatcher(PathConstants.PATH_GENERALTASK_LIST).forward(req, resp);
	}

	private void generalTaskDetailsGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		
		List<UserTasksDto> listUserTasks = userDao.findUserTasksByGeneralTaskId(id);
		List<Status> listStatus = taskDao.findAllStatus();
		
		req.setAttribute("generalTask", generalTaskDao.findById(id) );
	
		req.setAttribute("listUserTasks", listUserTasks);
		req.setAttribute("status", listStatus );
		req.setAttribute("statusDto", taskDao.listStatusDto(listUserTasks, listStatus));
		
		req.getRequestDispatcher(PathConstants.PATH_GENERALTASK_DETAILS).forward(req, resp);
	}

	private void generalTaskDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		generalTaskDao.deleteById(id);
		
		resp.sendRedirect(req.getContextPath() + UrlConstants.URL_GENERALTASK_LIST);
	}

	private void generalTaskAddGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher(PathConstants.PATH_GENERALTASK_ADD).forward(req, resp);
	}

	private void generalTaskAddPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		

		GeneralTask generalTask = new GeneralTask(-1, name,startDate, endDate);

		generalTaskDao.insert(generalTask);

		resp.sendRedirect(req.getContextPath() + UrlConstants.URL_GENERALTASK_LIST);
	}

	private void generalTaskEditGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		req.setAttribute("generalTask", generalTaskDao.findById(id));

		req.getRequestDispatcher(PathConstants.PATH_GENERALTASK_EDIT).forward(req, resp);
	}

	private void generalTaskEditPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		String name = req.getParameter("name");
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		

		GeneralTask generalTask = new GeneralTask(id, name,startDate, endDate);

		generalTaskDao.update(generalTask);

		resp.sendRedirect(req.getContextPath() + UrlConstants.URL_GENERALTASK_LIST);
	}
	
	
}