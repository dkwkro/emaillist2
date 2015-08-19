package com.bit2015.emaillist2.action;

import com.bit2015.web.action.action;
import com.bit2015.web.action.actionfactory;

public class emaillistactionfactory extends actionfactory {

	public action getAction( String actionName ) {
		action action =null;
		if ("insert".equals(actionName)) {
		action = new insertaction();
			
			
			System.out.println("insert action");
		} else if ("form".equals(actionName)) {
			System.out.println("form action");
			action= new formaction();
			
			
		} else { /* index,default 첫번째 페이지를 인덱스라고 한다 */
			// default action list
			// 1. DAO(Model) 한테 list 요청
			System.out.println("dao 한테 회원 list 요청");
			action = new indexaction();
		
			
		}
		
		return action;
	}
}
