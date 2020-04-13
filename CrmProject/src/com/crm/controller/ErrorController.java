package com.crm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.util.PathConstants;
import com.crm.util.UrlConstants;

@WebServlet(name = "ErrorServlet", urlPatterns = { UrlConstants.URL_ERROR404})
public class ErrorController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher(PathConstants.PATH_ERROR404_INDEX).forward(req, resp);
	}
}
