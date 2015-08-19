package com.bit2015.emaillist2.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.web.action.action;
import com.bit2015.web.util.webutil;

public class formaction extends action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("form action");
		//	 JSP(View) 포워딩(요청을 넘김)
			webutil.forward(request, response, "/form_emaillist.jsp");
	}

}
