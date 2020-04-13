package com.crm.controller;

import java.io.IOException;
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
import com.crm.dto.UserTasksDto;
import com.crm.entity.Status;
import com.crm.util.PathConstants;

@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserDAO userDao;
	TaskDAO taskDao;
	@Override
	public void init(ServletConfig config) throws ServletException {
	
		userDao = new UserDAO();
		taskDao = new TaskDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		 * List<UserTasksDto> listUserTasks = userDao.findAllUserTasks(); List<Status>
		 * listStatus = taskDao.findAllStatus(); req.setAttribute("statusDto",
		 * taskDao.listStatusDto(listUserTasks, listStatus));
		 */
		
		req.getRequestDispatcher(PathConstants.PATH_HOME_INDEX).forward(req, resp);
	}
	
}
