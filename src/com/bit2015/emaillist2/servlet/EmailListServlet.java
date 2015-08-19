package com.bit2015.emaillist2.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.emaillist2.action.emaillistactionfactory;
import com.bit2015.emaillist2.action.formaction;
import com.bit2015.emaillist2.action.indexaction;
import com.bit2015.emaillist2.action.insertaction;
import com.bit2015.web.action.action;

/**
 * Servlet implementation class EmailListServlet
 */
@WebServlet("/el")
public class EmailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response); //두포스트로 넘기기
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			
			String actionName = request.getParameter("a");

			emaillistactionfactory actionFactory = new emaillistactionfactory();
			action action = actionFactory.getAction(actionName);
			
			action.execute(request, response);
	
	}
}
