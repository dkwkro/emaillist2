package com.bit2015.emaillist2.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.emaillist.dao.EmailListDao;
import com.bit2015.emaillist.vo.EmailListVo;
import com.bit2015.web.action.action;

public class indexaction extends action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		// TODO Auto-generated method stub
		super.execute(request,response);
		try{
			
			// default action list
			// 1. DAO(Model) 한테 list 요청
			System.out.println("dao 한테 회원 list 요청");
			EmailListDao dao = EmailListDao.getInstance();
			List<EmailListVo> list = dao.getList();

			// 2. list를 request 범위안에 저장
			System.out.println("list를  request 범위안에 저장");
			request.setAttribute( "list", list );

			// 3. JSP(View) 포워딩(요청을 넘김)
			System.out.println("jsp 포워딩 요청 넘김");
		}catch(SQLException ex){
			System.out.println("db error:" +ex);
		}
		
		
		
		
	}

}
