package com.crm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.util.PathConstants;
import com.crm.util.UrlConstants;

@WebServlet(name = "BlankPageServlet", urlPatterns = { UrlConstants.URL_BLANKPAGE})
public class BlankPageController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher(PathConstants.PATH_BLANKPAGE_INDEX).forward(req, resp);
	}
}
