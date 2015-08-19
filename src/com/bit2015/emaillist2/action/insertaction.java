package com.bit2015.emaillist2.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.emaillist.dao.EmailListDao;
import com.bit2015.emaillist.vo.EmailListVo;
import com.bit2015.web.action.action;
import com.bit2015.web.util.webutil;

public class insertaction extends action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
try{		
		String firstname= request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		
		EmailListVo vo= new EmailListVo();
		vo.setEmail(email);
		vo.setFirstName(firstname);
		vo.setLastName(lastname);
		
		EmailListDao dao=EmailListDao.getInstance();
		dao.insert(vo);
		
		webutil.redirect(request, response, "el"); //자기자신한테 리다이렉트?
		}catch(SQLException ex){
			System.out.println("db error" +ex);
		}
		
		
		System.out.println("insert action");

	}

}
